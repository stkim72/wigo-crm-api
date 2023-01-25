package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmComnCdBasSo
 * @author    김성태
 * @date    2022. 4. 8.
 * @Version    1.0
 * @description    공통코드 So
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "공통코드 검색 객체")
public class CrmComnCdBasSo extends ApiPagination {
    /**
    * 공통코드 
    */
    @Parameter(description = "공통코드  ", example = "", hidden = true, required = false)
    private String comnCd;
    /**
    * 최상위공통코드 
    */
    @Parameter(description = "최상위공통코드  ", example = "", hidden = true, required = false)
    private String topComnCd;
    /**
    * 공통코드레벨번호 
    */
    @Parameter(description = "공통코드레벨번호  ", example = "", hidden = true, required = false)
    private Integer comnCdLvlNo;
    /**
    * 공통코드순번 
    */
    @Parameter(description = "공통코드순번  ", example = "", hidden = true, required = false)
    private Integer comnCdOdrg;
    /**
    * 부모공통코드 
    */
    @Parameter(description = "부모공통코드  ", example = "", hidden = true, required = false)
    private String prntsComnCd;
    /**
    * 공통코드명 
    */
    @Parameter(description = "공통코드명  ", example = "", hidden = true, required = false)
    private String comnCdNm;
    /**
    * 사용여부 
    */
    @Parameter(description = "사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String useYn;
    /**
    * 참조1공통코드 
    */
    @Parameter(description = "참조1공통코드  ", example = "", hidden = true, required = false)
    private String rfrn1ComnCd;
    /**
    * 참조2공통코드 
    */
    @Parameter(description = "참조2공통코드  ", example = "", hidden = true, required = false)
    private String rfrn2ComnCd;
    /**
    * 참조3공통코드 
    */
    @Parameter(description = "참조3공통코드  ", example = "", hidden = true, required = false)
    private String rfrn3ComnCd;
    /**
    * 참조4공통코드 
    */
    @Parameter(description = "참조4공통코드  ", example = "", hidden = true, required = false)
    private String rfrn4ComnCd;
    /**
    * 참조5공통코드 
    */
    @Parameter(description = "참조5공통코드  ", example = "", hidden = true, required = false)
    private String rfrn5ComnCd;
    /**
    * 참조6공통코드 
    */
    @Parameter(description = "참조6공통코드  ", example = "", hidden = true, required = false)
    private String rfrn6ComnCd;
    /**
    * 참조7공통코드 
    */
    @Parameter(description = "참조7공통코드  ", example = "", hidden = true, required = false)
    private String rfrn7ComnCd;
    /**
    * 참조8공통코드 
    */
    @Parameter(description = "참조8공통코드  ", example = "", hidden = true, required = false)
    private String rfrn8ComnCd;
    /**
    * 참조9공통코드 
    */
    @Parameter(description = "참조9공통코드  ", example = "", hidden = true, required = false)
    private String rfrn9ComnCd;
    /**
    * 공통코드1사용여부 
    */
    @Parameter(description = "공통코드1사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String comnCd1UseYn;
    /**
    * 공통코드2사용여부 
    */
    @Parameter(description = "공통코드2사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String comnCd2UseYn;
    /**
    * 공통코드3사용여부 
    */
    @Parameter(description = "공통코드3사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String comnCd3UseYn;
    /**
    * 공통코드4사용여부 
    */
    @Parameter(description = "공통코드4사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String comnCd4UseYn;
    /**
    * 공통코드5사용여부 
    */
    @Parameter(description = "공통코드5사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String comnCd5UseYn;
    /**
    * 공통코드6사용여부 
    */
    @Parameter(description = "공통코드6사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String comnCd6UseYn;
    /**
    * 공통코드7사용여부 
    */
    @Parameter(description = "공통코드7사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String comnCd7UseYn;
    /**
    * 공통코드8사용여부 
    */
    @Parameter(description = "공통코드8사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String comnCd8UseYn;
    /**
    * 공통코드9사용여부 
    */
    @Parameter(description = "공통코드9사용여부  ", example = "Y", hidden = true, required = false)
    @YnValue
    private String comnCd9UseYn;
}
