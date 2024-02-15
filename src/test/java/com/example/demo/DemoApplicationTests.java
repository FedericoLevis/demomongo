package com.example.demo;

import com.example.demo.repository.model.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DemoApplicationTests {


	private final UserService service;

	@Autowired
	public DemoApplicationTests(UserService service) {

		this.service = service;

	}

	@Test
	void contextLoads() {
		log.info("-------------------------  START TEST");
		User u = new User("LVSFRC...","Federico","Levis");
		service.storeUser(u);
		log.info("........");
		log.info("-------------------------- END TEST");

	}

}
