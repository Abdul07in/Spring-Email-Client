package org.dailycode;

import jakarta.mail.MessagingException;
import org.dailycode.mailsender.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailClientApplication {

    @Autowired
    private EmailSenderService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailClientApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
//        service.sendSimpleEmail("kanoorabdulaziz@gmail.com" , "Test Body" , "Email From Spring Boot");
        service.sendEmailWithAttachment("kanoorabdulaziz@gmail.com"
                ,"<h1>Download The Apk From Attachment</h1>" ,
                "Download the spotify app : https://apkdone.com/spotify-mod/download/"
                , "C:\\Users\\Majeed Kanoor\\Downloads\\luffy.jpg");
    }

}
