package com.ceragem.api.config.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.config.jwt.EzJwtService;
import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;

/**
 * <pre>
 * com.ceragem.crm.common.aop - BaseDaoAspect.java
 * </pre>
 *
 * @ClassName : BaseDaoAspect
 * @Description : TODO
 * @author : MKH
 * @date : 2021. 1. 11.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

@Aspect
@Component
public class BaseDaoAspect {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before(value = "execution(* *..*Dao.insert*(..))")
	public void insertBefore(JoinPoint jp) {
		try {
			String systemCd = EzJwtService.getSystemCd();
			if (Utilities.isEmpty(systemCd))
				systemCd = "000";
			String dt = Utilities.getDateTimeString();
			Map map = getMapObject(jp.getArgs());
			if (map != null) {
				map.put("peerIp", Utilities.getPeerIp());
				if(Utilities.isEmpty(map.get("regrId")))
					map.put("regrId", systemCd);
				map.put("regDt", dt);
				if(Utilities.isEmpty(map.get("amdrId")))
					map.put("amdrId", systemCd);
				map.put("amdDt", dt);
				if(Utilities.isEmpty(map.get("regChlCd")))
					map.put("regChlCd", systemCd);
				
				return;
			}

			ApiBaseVo apiVo = getApiBaseVo(jp.getArgs());
			if (apiVo != null) {
				if (Utilities.isEmpty(apiVo.getRegrId()))
					apiVo.setRegrId(systemCd);
				apiVo.setRegDt(dt);
				if (Utilities.isEmpty(apiVo.getAmdrId()))
					apiVo.setAmdrId(systemCd);
				apiVo.setAmdDt(dt);
				if (Utilities.isEmpty(apiVo.getRegChlCd()))
					apiVo.setRegChlCd(systemCd);
				return;
			}

			BaseVo bo = getBaseVo(jp.getArgs());
			if (bo != null) {
				bo.setPeerIp(Utilities.getPeerIp());
				if (Utilities.isEmpty(bo.getRegrId()))
					bo.setRegrId(systemCd);
				bo.setRegDt(dt);
				if (Utilities.isEmpty(bo.getAmdrId()))
					bo.setAmdrId(systemCd);
				bo.setAmdDt(dt);
				return;
			}

		} catch (Exception ex) {
			Utilities.trace(ex);
		}
	}

	@Before(value = "execution(* *..*Dao.update*(..))")
	public void updateBefore(JoinPoint jp) {
		try {
			insertBefore(jp);
		} catch (Exception ex) {
			Utilities.trace(ex);
		}
	}

	@SuppressWarnings("rawtypes")
	@Before(value = "execution(* *..*Dao.select*(..)) || execution(* *..*Dao.get*(..))")
	public void selectBefore(JoinPoint jp) {
		try {
			Map searchObj = getMapObject(jp.getArgs());
			if (searchObj == null)
				return;
		} catch (Exception ex) {
			Utilities.trace(ex);
		}

	}

	@Before(value = "execution(* *..*Dao.select*List(..)) || execution(* *..*Dao.get*List(..))")
	public void selectListBefore(JoinPoint jp) {
		try {

			setPagination(jp);
		} catch (Exception ex) {
			Utilities.trace(ex);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setPagination(JoinPoint jp) {
		Map searchObj = getMapObject(jp.getArgs());
		Object pinfo = null;
		if (searchObj == null) {
			pinfo = getPagination(jp.getArgs());
			if (pinfo == null)
				return;
			ApiPagination page = (ApiPagination) pinfo;
			if (page.getCurrentPageNo() < 1)
				page.setCurrentPageNo(1);
//			if (page.getPageSize() < 1)
//				page.setPageSize(5);
			if (page.getRecordCountPerPage() < 1)
				page.setRecordCountPerPage(30);
			return;
		} else
			pinfo = searchObj.get("pagination");

		if (pinfo == null) {
			if (searchObj instanceof EzMap) {
				pinfo = ((EzMap) searchObj).getPaginationInfo();
				((EzMap) searchObj).setPaginationInfo((EzPaginationInfo) pinfo);
			} else {
				pinfo = new EzPaginationInfo();
				searchObj.put("pagination", pinfo);
			}
		}
		if (pinfo instanceof EzPaginationInfo) {
			EzPaginationInfo page = (EzPaginationInfo) pinfo;
			Utilities.mapToBean(searchObj, page);
			if (page.getCurrentPageNo() < 1)
				page.setCurrentPageNo(1);
			if (page.getPageSize() < 1)
				page.setPageSize(5);
			if (page.getRecordCountPerPage() < 1)
				page.setRecordCountPerPage(10);
			Utilities.beanToMap(searchObj, page);
		}
		Map<String, Object> param = new HashMap<String, Object>();
		for (Object key : searchObj.keySet()) {
			Object obj = searchObj.get(key);
			if (obj instanceof String || obj instanceof Number || obj instanceof Boolean || !(obj instanceof Object)) {
				param.put(key.toString(), obj);
			}
		}
		searchObj.put("searchParam", param);

	}

	@SuppressWarnings("rawtypes")
	private Map getMapObject(Object[] args) {

		if (args == null || args.length == 0) {
			return null;
		}
		for (Object arg : args) {
			if (arg instanceof EzMap) {
				return (Map) arg;
			} else if (arg instanceof Map) {
				return (Map) arg;
			}
		}
		return null;
	}

	private ApiPagination getPagination(Object[] args) {
		if (args == null || args.length == 0) {
			return null;
		}

		for (Object arg : args) {
			if (arg instanceof ApiPagination) {
				return (ApiPagination) arg;
			}
		}

		return null;
	}

	private ApiBaseVo getApiBaseVo(Object[] args) {

		if (args == null || args.length == 0) {
			return null;
		}

		for (Object arg : args) {
			if (arg instanceof ApiBaseVo) {
				return (ApiBaseVo) arg;
			}
		}

		return null;
	}

	private BaseVo getBaseVo(Object[] args) {

		if (args == null || args.length == 0) {
			return null;
		}

		for (Object arg : args) {
			if (arg instanceof BaseVo) {
				return (BaseVo) arg;
			}
		}

		return null;
	}
}
