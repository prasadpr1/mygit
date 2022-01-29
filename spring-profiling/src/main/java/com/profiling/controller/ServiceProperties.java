package com.profiling.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("service")
public class ServiceProperties {

	private Boolean enabled;
	
	private String username;
	
	private String password;
	
	

	public Boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "ServiceProperties [enabled=" + enabled + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
