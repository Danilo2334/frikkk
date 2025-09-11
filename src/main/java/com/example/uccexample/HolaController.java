package com.example.uccexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    
    @GetMapping("/")
    public String hol() {
        return this.uccAssistant.chat();
    }
}
