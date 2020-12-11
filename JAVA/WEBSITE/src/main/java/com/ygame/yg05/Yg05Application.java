package com.ygame.yg05;

import com.ygame.yg05.controller.UploadFileController;
import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ygame.yg05", "controller"})
@EntityScan(basePackages = {"com.ygame.yg05.entity_cometics", "com.ygame.yg05.entity_yg05"})
@EnableConfigurationProperties({ConfigurationFile.class})
@EnableAutoConfiguration(exclude = {
                            DataSourceAutoConfiguration.class,
                            DataSourceTransactionManagerAutoConfiguration.class,
                            HibernateJpaAutoConfiguration.class 
                        })
public class Yg05Application {
	public static void main(String[] args) {
		SpringApplication.run(Yg05Application.class, args);
	}

}
