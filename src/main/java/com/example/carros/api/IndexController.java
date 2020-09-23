package com.example.carros.api;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    //@RequestMapping(method = RequestMethod.GET) isso é a mesma coisa do get mapping
    public String hello(){

        return "API dos carros ";

    }

}
