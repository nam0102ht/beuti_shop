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
public class YG05Datasource {
    @Autowired
    Environment env;
    
    @Bean
    public DataSource data2Source(){
        DriverManagerDataSource dataSource =  new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.yg05"));
        dataSource.setUrl(env.getProperty("spring.datasource.url.yg05"));
        dataSource.setUsername(env.getProperty("spring.datasource.username.yg05"));
        dataSource.setPassword(env.getProperty("spring.datasource.password.yg05"));
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean yg05EntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(data2Source());

        // Scan Entities in Package:
        em.setPackagesToScan(new String[] { ConstantsDatasource.PACKAGE_ENTITIES_YG05 });
        em.setPersistenceUnitName(ConstantsDatasource.JPA_UNIT_NAME_YG05); // Important !!

        //
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();

        // JPA & Hibernate
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.yg05"));
        properties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql.yg05"));
        properties.put("hibernate.ddl-auto", env.getProperty("spring.jpa.hibernate.ddl-auto.yg05"));
        em.setJpaPropertyMap(properties);
        em.afterPropertiesSet();
        return em;
    }
    @Bean
    @Qualifier(value = "yg05TransactionManager")
    public PlatformTransactionManager yg05TransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(yg05EntityManager().getObject());
        return transactionManager;
    }
}
