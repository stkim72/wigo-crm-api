package com.ceragem.api.crm.service;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BosApiParamVo {
	private BosCmCondVo cmCond;
	private Map<String, Object> cond;

	public BosApiParamVo(String randomKey) {
		cmCond = new BosCmCondVo();
		cmCond.setRandomKey(randomKey);
		cond = new HashMap<String, Object>();
	}

	public void setParam(String name, Object value) {
		cond.put(name, value);
	}

}
