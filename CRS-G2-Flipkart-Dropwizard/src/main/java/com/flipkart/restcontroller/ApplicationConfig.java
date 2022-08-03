package com.flipkart.restcontroller;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {

	register(UserRestAPI.class);
	register(ProfessorRestAPI.class);

	}

}