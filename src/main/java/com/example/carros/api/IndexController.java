package com.example.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    //@RequestMapping(method = RequestMethod.GET) isso é a mesma coisa do get mapping
    public String hello(){
        return "Hello Spring Boot";
    }

    @PostMapping()
    //@RequestMapping(method = RequestMethod.GET) isso é a mesma coisa do get mapping
    public String post(){
        return "Post Spring Boot";
    }

    @PutMapping()
    //@RequestMapping(method = RequestMethod.GET) isso é a mesma coisa do get mapping
    public String put(){
        return "Put Spring Boot";
    }

    @DeleteMapping()
    //@RequestMapping(method = RequestMethod.GET) isso é a mesma coisa do get mapping
    public String delete(){
        return "Delete Spring Boot";
    }


}
