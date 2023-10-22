package com.rest40.demo;

import com.rest40.demo.repository.DBProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan("com.rest40.demo.*")
public class RestApplication {
	@Bean("dataSource")
	public DataSource dataSource(DBProperties dbProperties) {
		var dataSource = new DriverManagerDataSource();
		dataSource.setUrl(dbProperties.getUrl());
		dataSource.setUsername(dbProperties.getUser());
		dataSource.setPassword(dbProperties.getPassword());
		return dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
