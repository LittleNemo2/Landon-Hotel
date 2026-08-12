package com.example.landonhotel;

import com.example.landonhotel.service.WelcomeMessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.landonhotel.service.TimeZoneService;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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

			TimeZoneService timeZoneService = new TimeZoneService();
			ZonedDateTime presentationTime = ZonedDateTime.of(2026, 8, 20, 14, 0, 0, 0, ZoneId.of("America/New_York"));
			System.out.println(timeZoneService.getPresentationTimeMessage(presentationTime));
		};
	}

}
