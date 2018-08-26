package com.test.VaadinSessionCleanUp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import com.vaadin.spring.annotation.VaadinSessionScope;

@Service
@VaadinSessionScope
public class ExampleSessionBean {

	
	@PostConstruct
	public void init() {
		System.out.println("Init ExampleSessionBean...");
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("CleanUp ExampleSessionBean...");
	}
}
