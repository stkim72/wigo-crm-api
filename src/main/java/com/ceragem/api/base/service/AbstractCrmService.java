package com.ceragem.api.base.service;

import java.util.ArrayList;
import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.crm.common.model.EzMap;

/**
 * <pre>
 * com.ceragem.crm.common.service.AbstractCrmService
 * </pre>
 *
 * @ClassName : AbstractCrmService
 * @Description : AbstractCrmService
 * @author : κΉμ±ν
 * @date : 2021. 4. 27.
 * @Version : 1.0
 * @Company : Copyright β wigo.CO.LTD. All Right Reserved
 */
public abstract class AbstractCrmService {
	public abstract ICrmDao getDao();

	public <T> List<T> getList(Object param) throws Exception {
		return getDao().selectList(param);
	}

	public <T> T get(Object param) throws Exception {
		return getDao().select(param);
	}

	public int getListCount(Object param) throws Exception {
		return getDao().selectListCount(param);
	}

	public int insert(Object param) throws Exception {
		return getDao().insert(param);
	}

	public int update(Object param) throws Exception {
		return getDao().update(param);
	}

	public int delete(Object param) throws Exception {
		return getDao().delete(param);
	};

	public EzMap save(ApiBaseVo vo) throws Exception {
//		if ("C".equalsIgnoreCase(vo.getStat()))
//			return Utilities.getInsertResult(insert(vo), vo);
//		else if ("U".equalsIgnoreCase(vo.getStat()))
			return Utilities.getUpdateResult(update(vo), vo);
//		else if ("D".equalsIgnoreCase(vo.getStat()))
//			return Utilities.getDeleteResult(delete(vo));
//		return Utilities.getUpdateResult(0, vo);
	}

	public EzMap insertList(List<? extends ApiBaseVo> list) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		for (int i = 0; i < list.size(); i++) {
			result.add(Utilities.getInsertResult(insert(list.get(i)), list.get(i)));
		}
		return Utilities.getSaveResult(result);
	}

	public EzMap updateList(List<? extends ApiBaseVo> list) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		for (int i = 0; i < list.size(); i++) {
			result.add(Utilities.getUpdateResult(update(list.get(i)), list.get(i)));
		}
		return Utilities.getSaveResult(result);
	}

	public EzMap deleteList(List<? extends ApiBaseVo> list) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		for (int i = 0; i < list.size(); i++) {
			result.add(Utilities.getDeleteResult(delete(list.get(i))));
		}
		return Utilities.getSaveResult(result);
	}

	public EzMap saveList(List<? extends ApiBaseVo> list) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		for (int i = 0; i < list.size(); i++) {
			result.add(save(list.get(i)));
		}
		return Utilities.getSaveResult(result);
	}

}
