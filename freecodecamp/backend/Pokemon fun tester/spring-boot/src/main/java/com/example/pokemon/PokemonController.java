package com.example.pokemon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @RequestMapping("/")
    public String helloWorld(){
      return "Hello World from Spring Boot";
    }
    
}
