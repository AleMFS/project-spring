package com.example.projetospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachorroController {
    @GetMapping(value = "/hello")
    public String helloWorld(){
        return "Hello World" ;
    }
}
