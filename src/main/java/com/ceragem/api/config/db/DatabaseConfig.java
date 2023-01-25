package com.ceragem.api.config.db;
//package com.ceragem.api.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.ceragem.api.config.annotation.SysMapper;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
///**
// * 
// * <pre>
// * com.ceragem.crm.config - DatabaseConfig.java
// * </pre>
// *
// * @ClassName : DatabaseConfig
// * @Description : DB 설정
// * @author : 김성태
// * @date : 2021. 1. 5.
// * @Version : 1.0
// * @Company : Copyright ⓒ wigo.ai. All Right Reserved
// */
//
//@Configuration
//@MapperScan(basePackages = {
//		"com.ceragem.api.sys" }, value = "System 패키지 경로", annotationClass = SysMapper.class, sqlSessionFactoryRef = "sqlSessionFactory")
//public class DatabaseConfig {
//	@Autowired
//	private ApplicationContext applicationContext;
//
//	@Value("${spring.datasource.crm.driver-class-name}")
//	private String dbDriverClassName;
//
//	@Value("${spring.datasource.crm.url}")
//	private String dbURL;
//
//	@Value("${spring.datasource.crm.username}")
//	private String userName;
//
//	@Value("${spring.datasource.crm.password}")
//	private String password;
//	@Value("${spring.datasource.crm.hikari.connection-timeout}")
//	private int timeout;
//	@Value("${spring.datasource.crm.hikari.maximum-pool-size}")
//	private int poolSize;
//
//	@Bean(name = "dataSource")
//	public DataSource dataSource() {
////		DriverManagerDataSource dataSource = new DriverManagerDataSource();
////
////		dataSource.setDriverClassName(dbDriverClassName);
////		dataSource.setUrl(dbURL);
////		dataSource.setUsername(userName);
////		dataSource.setPassword(password);
////		return dataSource;
//
//		HikariConfig hikariConfig = new HikariConfig(); // 3
//		if (poolSize <= 0)
//			poolSize = 100;
//		if (timeout <= 0)
//			timeout = 60000;
//
//		hikariConfig.setUsername(userName);
//		hikariConfig.setPassword(password);
//		hikariConfig.setJdbcUrl(dbURL);
//		hikariConfig.setConnectionTestQuery("SELECT 1 from dual");
//		hikariConfig.setMaximumPoolSize(poolSize);
//		hikariConfig.setConnectionTimeout(timeout);
//		hikariConfig.setLeakDetectionThreshold(30000);
//		hikariConfig.setPoolName("ceragem-api-pool");
//		return new HikariDataSource(hikariConfig);
//	}
//
//	@Bean(name = "sqlSessionFactory")
//	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		sqlSessionFactoryBean
//				.setConfigLocation(applicationContext.getResource("classpath:/config/mybatis/mybatis-config-base.xml"));
//		sqlSessionFactoryBean
//				.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*_SqlMapper.xml"));
//		sqlSessionFactoryBean.setTypeAliasesPackage("com.ceragem.**.model,com.ceragem.**.entity");
//		return sqlSessionFactoryBean.getObject();
//	}
//
////
//	@Bean(name = "sqlSessionTemplate")
//	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//
//}
