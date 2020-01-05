package com.fastcollab.userdetails.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.fastcollab.userdetails.repository"})
@PropertySource("classpath:application.properties")
public class JpaConfiguration {
	

	@Autowired 
	private Environment environment;
	
	@Bean
	  public BasicDataSource dataSource() {
	    BasicDataSource basicDataSource = new BasicDataSource();
	    basicDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	    basicDataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
	    basicDataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
	    basicDataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
	    return basicDataSource;
	  }
	 
	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
	    entityManagerFactory.setDataSource(dataSource);
	    entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	    entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
	    entityManagerFactory.setPackagesToScan("com.fastcollab.flightsearch.entities");
	    entityManagerFactory.setJpaPropertyMap(hibernateJpaProperties());
	    return entityManagerFactory;
	  }
	 
	  private Map<String, ?> hibernateJpaProperties() {
	    HashMap<String, String> properties = new HashMap<>();
	    properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
	    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	    properties.put("hibernate.dialect",environment.getRequiredProperty("hibernate.dialect"));
	    properties.put("hibernate.ejb.naming_strategy", environment.getRequiredProperty("hibernate.ejb.naming_strategy"));
	    return properties;
	  }
	 
	  @Bean
	  public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
	    jpaTransactionManager.setEntityManagerFactory(emf);
	    return jpaTransactionManager;
	  }

}
