package com.ceragem.api.config.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
public class TransactionAspect {
	private static final String CRM_AOP_TRANSCTION_EXPRESSION = "execution(public * com.ceragem.api.crm..*Service.*(..))";
	private static final int TX_TIMEOUT = 30;

	@Bean
	TransactionInterceptor transactionAdvice(TransactionManager txManager) {
		return advice(txManager);
	}

	@Bean
	Advisor crmTransactionAdviceAdvisor(@Qualifier("crmTransactionManager") TransactionManager txManager) {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(CRM_AOP_TRANSCTION_EXPRESSION);
		return new DefaultPointcutAdvisor(pointcut, advice(txManager));
	}

	private TransactionInterceptor advice(TransactionManager txManager) {
		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		DefaultTransactionAttribute readOnlyTransactionAttribute = new DefaultTransactionAttribute(
				TransactionDefinition.PROPAGATION_REQUIRED);
		readOnlyTransactionAttribute.setReadOnly(true);
		readOnlyTransactionAttribute.setTimeout(TX_TIMEOUT);

		RuleBasedTransactionAttribute writeTransactionAttribute = new RuleBasedTransactionAttribute();
		writeTransactionAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		writeTransactionAttribute.setTimeout(TX_TIMEOUT);

		Map<String, TransactionAttribute> txAttribute = new HashMap<String, TransactionAttribute>();

		txAttribute.put("get*", readOnlyTransactionAttribute);
		txAttribute.put("select*", readOnlyTransactionAttribute);
		txAttribute.put("insert*", writeTransactionAttribute);
		txAttribute.put("update*", writeTransactionAttribute);
		txAttribute.put("delete*", writeTransactionAttribute);
		txAttribute.put("delete*", writeTransactionAttribute);
		txAttribute.put("save*", writeTransactionAttribute);
		source.setNameMap(txAttribute);
		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
		transactionInterceptor.setTransactionManager(txManager);
		transactionInterceptor.setTransactionAttributeSource(source);
		return transactionInterceptor;
	}
}
