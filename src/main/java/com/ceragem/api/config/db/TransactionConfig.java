package com.ceragem.api.config.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * <pre>
 * com.ceragem.crm.config - TransactionConfig.java
 * </pre>
 *
 * @ClassName : TransactionConfig
 * @Description : 트랜잭션 설정
 * @author : 김성태
 * @date : 2021. 1. 5.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

@Configuration
@EnableTransactionManagement
public class TransactionConfig {

//	@Bean(name = "transactionManager")
//	public DataSourceTransactionManager txManager(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//		return new DataSourceTransactionManager(dataSource);
//	}

	@Primary
	@Bean(name = "crmTransactionManager")
	DataSourceTransactionManager crmTxManager(@Qualifier("crmDataSource") DataSource dataSource) throws Exception {
		DataSourceTransactionManager tx = new DataSourceTransactionManager(dataSource);
		tx.setDefaultTimeout(60);
		return tx;
	}


//	@Bean(name = "txManager")
//	public PlatformTransactionManager chainedTransactionManager(
//			@Qualifier("crmTransactionManager") PlatformTransactionManager crmTransactionManager,
//			@Qualifier("ctcTransactionManager") PlatformTransactionManager ctcTransactionManager,
//			@Qualifier("asTransactionManager") PlatformTransactionManager asTransactionManager) {
//		return new ChainedTransactionManager(crmTransactionManager, ctcTransactionManager, asTransactionManager);
//	}
}
