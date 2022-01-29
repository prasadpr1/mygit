package com.profiling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.profiling.controller.DataSource;
import com.profiling.controller.H2DataSource;
import com.profiling.controller.ProdDataSource;

@Configuration
public class CustomConfig {

	@Profile("dev")
	@Bean
	public DataSource devSource() {
		return new H2DataSource();
	}
	

	@Profile("prod")
	@Bean
	public DataSource prodSource() {
		return new ProdDataSource();
	}
}
