package com.example.landonhotel.rest;

import com.example.landonhotel.service.TimeZoneService;
import com.example.landonhotel.service.WelcomeMessageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
public class MessageController {

    private final WelcomeMessageService welcomeMessageService;
    private final TimeZoneService timeZoneService;

    public MessageController(WelcomeMessageService welcomeMessageService, TimeZoneService timeZoneService) {
        this.welcomeMessageService = welcomeMessageService;
        this.timeZoneService = timeZoneService;
    }

    @GetMapping("/welcome")
    public Map<String, String> getWelcomeMessages() {
        return welcomeMessageService.getWelcomeMessages();
    }

    @GetMapping("/presentation-time")
    public String getPresentationTime() {
        ZonedDateTime presentationTime = ZonedDateTime.of(2026, 8, 20, 14, 0, 0, 0, ZoneId.of("America/New_York"));
        return timeZoneService.getPresentationTimeMessage(presentationTime);
    }
}