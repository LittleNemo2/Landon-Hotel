package com.example.landonhotel.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@Service
public class WelcomeMessageService {

    public Map<String, String> getWelcomeMessages() {
        Map<String, String> messages = new HashMap<>();

        Runnable englishTask = () -> {
            ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.ENGLISH);
            String message = bundle.getString("welcome.message");
            System.out.println("[" + Thread.currentThread().getName() + "] " + message);
            synchronized (messages) {
                messages.put("english", message);
            }
        };

        Runnable frenchTask = () -> {
            ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.FRENCH);
            String message = bundle.getString("welcome.message");
            System.out.println("[" + Thread.currentThread().getName() + "] " + message);
            synchronized (messages) {
                messages.put("french", message);
            }
        };

        Thread englishThread = new Thread(englishTask, "English-Thread");
        Thread frenchThread = new Thread(frenchTask, "French-Thread");

        englishThread.start();
        frenchThread.start();

        try {
            englishThread.join();
            frenchThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return messages;
    }
}