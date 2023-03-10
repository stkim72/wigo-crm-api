package com.ceragem.api.config.jwt.exception;

/** 
* <pre>
* com.ceragem.crm.common.jwt.exception
*	- EzJwtException.java
* </pre>
*
* @ClassName	: EzJwtException 
* @Description	: 오오 
* @author 		: 김성태
* @date 		: 2021. 1. 22.
* @Version 		: 1.0 
* @Company 		: Copyright ⓒ wigo.ai. All Right Reserved
*/

public class EzJwtEntryPointException extends EzJwtException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6327728825759667613L;

	/**
	* Desc : Constructor of EzJwtAuthenticationException.java class
	* @param Exception
	*/
	
	public EzJwtEntryPointException(Exception exception) {
		super(exception);
	}

	
}
