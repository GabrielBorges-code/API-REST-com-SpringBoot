package com.example.carros.api;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    //@RequestMapping(method = RequestMethod.GET) isso é a mesma coisa do get mapping
    public String hello(){
        return "Hello Spring Boot";
    }

    @PostMapping("/login")
    public String login(@RequestParam ("login") String login, @RequestParam("senha") String senha){
        return "Login: " + login + ", Senha: " + senha;
    }
/*
    @GetMapping("/carros/{id}")
    public String getCarroById(@PathVariable("id") Long id){
        return "Carro by id: " + id;
    }

    @GetMapping("/carros/tipo/{tipo}")
    public String getCarroByTipo(@PathVariable("tipo") String tipo){
        return "Lista de tipo de carros " + tipo;
    }*/

}
