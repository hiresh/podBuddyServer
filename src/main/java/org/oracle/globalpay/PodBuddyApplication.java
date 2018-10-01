package org.oracle.globalpay;

import org.oracle.globalpay.model.User;
import org.oracle.globalpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PodBuddyApplication {
	@Autowired
	private static UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(PodBuddyApplication.class, args);
		
	}
}
