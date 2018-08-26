package com.test.VaadinSessionCleanUp;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

@Theme("valo")
@SpringUI(path = "")
public class ExampleUI extends UI {

	@Autowired
	private ExampleSessionBean exampleSessionBean;
	
	@Override
	protected void init(VaadinRequest request) {
		
		getSession().getService()
			.addSessionDestroyListener(new SessionDestroyListener() {

			@Override
			public void sessionDestroy(SessionDestroyEvent event) {
				System.out.println("Vaadin session destroyed");

			}
		});
		
		setContent(new Button("Close session", (event) -> getSession().close()));
	}

}
