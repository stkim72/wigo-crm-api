package com.ceragem.api.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPropertyService;
import com.ceragem.crm.common.model.EzPropertyServiceImpl;

/**
 * 
* <pre>
* com.ceragem.crm.config
*	- TilesConfig.java
* </pre>
*
* @ClassName	: TilesConfig 
* @Description	: Tiles 설정
* @author 		: 김성태
* @date 		: 2021. 1. 5.
* @Version 		: 1.0 
* @Company 		: Copyright ⓒ wigo.ai. All Right Reserved
 */

@Configuration
public class PropertyConfig {
    @Bean(name="propertiesService")
    public EzPropertyService tilesViewResolver() {

        final EzPropertyServiceImpl propertyService = new EzPropertyServiceImpl();
        EzMap map = new EzMap();
        
        propertyService.setProperties(map);
        return propertyService;
    }
}
