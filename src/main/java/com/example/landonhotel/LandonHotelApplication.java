package com.example.landonhotel;

import com.example.landonhotel.service.WelcomeMessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LandonHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandonHotelApplication.class, args);
	}

	@Bean
	public CommandLineRunner runWelcomeMessages() {
		return args -> {
			WelcomeMessageService welcomeMessageService = new WelcomeMessageService();
			welcomeMessageService.displayWelcomeMessages();
		};
	}

}
