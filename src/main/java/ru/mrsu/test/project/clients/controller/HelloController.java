package ru.mrsu.test.project.clients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello(){
       return "HELLO";
    }

    @GetMapping("/helloClient")
    public String Hello(@RequestParam String name){
        return "HELLO "+name;
    }

}
