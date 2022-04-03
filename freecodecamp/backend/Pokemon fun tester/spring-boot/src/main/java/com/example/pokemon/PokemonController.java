package com.example.pokemon;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @RequestMapping("/")
    public String helloWorld(){
      return "Hello World from Spring Boot";
    }

    @GetMapping("/pokemonList") 
    public List<Pokemon> getPokemonList() throws IOException, URISyntaxException, CsvException{
      // do something to get list of pokemon maybe paged
      List<String[]> lister = CsvParser.test();
      for(String[] st: lister) {
        System.out.println(st);
      }
      return new LinkedList<>();
    }

    @GetMapping("/ability")
    public List<Pokemon> getAbility(@RequestParam String id, @RequestParam(required = false) String pokemonName) {
        return new LinkedList<>();
    }
    
}
