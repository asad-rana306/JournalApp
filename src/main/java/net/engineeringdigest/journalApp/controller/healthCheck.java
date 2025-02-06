package net.engineeringdigest.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health-check")
public class healthCheck {
    @GetMapping
    public String checkinghealth(){
        System.out.println("health is good");
        return "Health is good";
    }
}
