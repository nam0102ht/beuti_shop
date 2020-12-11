/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
// Load to Environment
// (@see resources/application.properties).
@EntityScan(basePackages = {"com.ygame.yg05.entity_cometics"})
public class CometicsDataSource {
    @Autowired
    Environment env;
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource =  new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.comestic"));
        dataSource.setUrl(env.getProperty("spring.datasource.url.comestic"));
        dataSource.setUsername(env.getProperty("spring.datasource.username.comestic"));
        dataSource.setPassword(env.getProperty("spring.datasource.password.comestic"));
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean ygameEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());

        // Scan Entities in Package:
        em.setPackagesToScan(new String[] { "com.ygame.yg05.entity_cometics" });
        em.setPersistenceUnitName(ConstantsDatasource.JPA_UNIT_NAME_COMESTIC); // Important !!

        //
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();

        // JPA & Hibernate
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.comestic"));
        properties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql.comestic"));
        properties.put("hibernate.ddl-auto", env.getProperty("spring.jpa.hibernate.ddl-auto.comestic"));
        em.setJpaPropertyMap(properties);
        em.afterPropertiesSet();
        return em;
    }
    @Bean
    @Qualifier(value = "comesticTransactionManager")
    public PlatformTransactionManager cometicsTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(ygameEntityManager().getObject());
        return transactionManager;
    }
}
