package com.ceragem.api.config.db;

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

import com.ceragem.api.config.annotation.AsMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 *
 * <pre>
 * com.ceragem.api.config - AsDatabaseConfig.java
 * </pre>
 *
 * @ClassName : AsDatabaseConfig
 * @Description : DB 설정
 * @author : 김성태
 * @date : 2021. 1. 5.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

@Configuration
@MapperScan(basePackages = {
		"com.ceragem.api.as" }, value = "AS 패키지 경로", annotationClass = AsMapper.class, sqlSessionFactoryRef = "asSqlSessionFactory")
public class AsDatabaseConfig {
	@Autowired
	ApplicationContext applicationContext;

	@Value("${spring.datasource.as.driver-class-name}")
	String dbDriverClassName;

	@Value("${spring.datasource.as.url}")
	String dbURL;

	@Value("${spring.datasource.as.username}")
	String userName;

	@Value("${spring.datasource.as.password}")
	String password;

	@Value("${spring.datasource.as.hikari.connection-timeout}")
	int timeout;
	@Value("${spring.datasource.as.hikari.maximum-pool-size}")
	int poolSize;

	@Bean(name = "asDataSource")
	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(dbDriverClassName);
//		dataSource.setUrl(dbURL);
//		dataSource.setUsername(userName);
//		dataSource.setPassword(password);
//
//		return dataSource;
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
		hikariConfig.setPoolName("cragem-api-as-pool");

		return new HikariDataSource(hikariConfig);
	}

	@Bean(name = "asSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("asDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean
				.setConfigLocation(applicationContext.getResource("classpath:/config/mybatis/mybatis-config-base.xml"));
		sqlSessionFactoryBean
				.setMapperLocations(applicationContext.getResources("classpath:/mapper/as/**/*_SqlMapper.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.ceragem.**.model,com.ceragem.**.entity");
		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "asSqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("asSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
