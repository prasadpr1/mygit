package com.profiling.controller;

public class H2DataSource implements DataSource {

	@Override
	public void get() {
		System.out.println("Dev is Active");
		
	}

}
