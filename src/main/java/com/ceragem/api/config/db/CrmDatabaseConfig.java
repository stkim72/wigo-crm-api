package com.ceragem.api.config.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

import com.ceragem.api.config.annotation.CrmMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 *
 * <pre>
 * com.ceragem.crm.config - DatabaseConfig.java
 * </pre>
 *
 * @ClassName : CrmDatabaseConfig
 * @Description : DB 설정
 * @author : 김성태
 * @date : 2021. 1. 5.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

@Configuration
@MapperScan(basePackages = { "com.ceragem.api.com", "com.ceragem.api.crm",
		"com.ceragem.api.base.dao" }, value = "CRM 패키지 경로", annotationClass = CrmMapper.class, sqlSessionFactoryRef = "crmSqlSessionFactory")
public class CrmDatabaseConfig {
	@Autowired
	ApplicationContext applicationContext;

	@Value("${spring.datasource.crm.driver-class-name}")
	String dbDriverClassName;

	@Value("${spring.datasource.crm.url}")
	String dbURL;

	@Value("${spring.datasource.crm.username}")
	String userName;

	@Value("${spring.datasource.crm.password}")
	String password;

	@Value("${spring.datasource.crm.hikari.connection-timeout}")
	private int timeout;
	@Value("${spring.datasource.crm.hikari.maximum-pool-size}")
	private int poolSize;

	@Primary
	@Bean(name = "crmDataSource")
	DataSource dataSource() {
		if (poolSize <= 0)
			poolSize = 100;
		if (timeout <= 0)
			timeout = 60000;
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(dbDriverClassName);
		hikariConfig.setUsername(userName);
		hikariConfig.setPassword(password);
		hikariConfig.setJdbcUrl(dbURL);
		hikariConfig.setConnectionTestQuery("SELECT 1 from dual");
		hikariConfig.setMaximumPoolSize(poolSize);
		hikariConfig.setConnectionTimeout(timeout);
		hikariConfig.setLeakDetectionThreshold(30000);
		hikariConfig.setPoolName("cragem-api-crm-pool");

		return new HikariDataSource(hikariConfig);
	}

	@Bean(name = "crmSqlSessionFactory")
	SqlSessionFactory sqlSessionFactory(@Qualifier("crmDataSource") DataSource dataSource) throws Exception {

		List<Resource> mapList = new ArrayList<>();
		mapList.addAll(Arrays.asList(applicationContext.getResources("classpath:/mapper/crm/**/*_SqlMapper.xml")));
		mapList.addAll(Arrays.asList(applicationContext.getResources("classpath:/mapper/com/**/*_SqlMapper.xml")));

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean
				.setConfigLocation(applicationContext.getResource("classpath:/config/mybatis/mybatis-config-base.xml"));
		sqlSessionFactoryBean.setMapperLocations(mapList.toArray(new Resource[mapList.size()]));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.ceragem.**.model,com.ceragem.**.entity");
		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "crmSqlSessionTemplate")
	SqlSessionTemplate sqlSessionTemplate(@Qualifier("crmSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
