package com.ceragem.api.base.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiExecHstVo extends ApiInfoBaseVo{
    /**
    * <p>API이력코드</p> 
    */
    private String apiHstCd;
    /**
    * <p>API코드</p> 
    */
    private String apiCd;
    /**
    * <p>API호출URL</p> 
    */
    private String apiCallUrl;
    /**
    * <p>API결과코드</p> 
    */
    private String apiRsltCd;
    /**
    * <p>API결과메시지내역</p> 
    */
    private String apiRsltMsgTxn;
    /**
    * <p>API파라미터내역</p> 
    */
    private String apiParamTxn;
    /**
    * <p>API결과내역</p> 
    */
    private String apiRsltTxn;
    /**
    * <p>API호출일시</p> 
    */
    private String apiCallDt;
    /**
    * <p>API실행밀리초</p> 
    */
    private Integer apiExecMsec;
    
    /**
     * <p>API호출IP주소</p> 
     */
     private String apiCallIpAddr;
     
     /**
      * <p>호출토큰</p> 
      */
      private String apiCallToken;
}
