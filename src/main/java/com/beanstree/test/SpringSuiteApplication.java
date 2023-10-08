package com.beanstree.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ComponentScan({"com.test.*","com.beanstree.*"})
@EnableJpaRepositories({"com.test.*","com.beanstree.*"})
@EntityScan({"com.test.*","com.beanstree.*"})
@EnableAutoConfiguration
@EnableJms
@EnableCaching
@ImportResource("classpath*:/si-config.xml")
public class SpringSuiteApplication {

	public static void main(String[] args)  throws Exception {
		SpringApplication.run(SpringSuiteApplication.class, args);
	}
}
