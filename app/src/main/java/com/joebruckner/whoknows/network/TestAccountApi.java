package com.joebruckner.whoknows.network;

public class TestAccountApi implements AccountApi {

	public TestAccountApi() {

	}

	@Override public String getName() {
		return "Joe";
	}
}