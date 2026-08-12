package com.example.landonhotel.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeMessageService {
    public void displayWelcomeMessages() {

        Runnable englishTask = () -> {
            ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.ENGLISH);
            String message = bundle.getString("welcome.message");
            System.out.println("[" + Thread.currentThread().getName() + "] " + message);
        };

        Runnable frenchTask = () -> {
            ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.FRENCH);
            String message = bundle.getString("welcome.message");
            System.out.println("[" + Thread.currentThread().getName() + "] " + message);
        };

        Thread englishThread = new Thread(englishTask, "English-Thread");
        Thread frenchThread = new Thread(frenchTask, "French-Thread");

        englishThread.start();
        frenchThread.start();
    }
}


