package com.profiling.controller;

public class ProdDataSource implements DataSource {

	@Override
	public void get() {
		System.out.println("Prod profile is active");
	}

}
