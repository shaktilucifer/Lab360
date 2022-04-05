package com.example.pokemon;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.opencsv.exceptions.CsvException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

  private static Map<String, String[]> pokemonMap = new HashMap<>();

  @PostConstruct
  private void buildPokemonMap() throws IOException, URISyntaxException, CsvException {
    List<String[]> pokemonList = CsvParser.test();
    for(String[] pokemon: pokemonList) {
      pokemonMap.put(pokemon[30].toLowerCase(), pokemon);
    }
  }

  @RequestMapping("/")
  public String[] helloWorld() throws IOException, URISyntaxException, CsvException {
    // do something to get list of pokemon maybe paged
    List<String[]> lister = CsvParser.test();
    return lister.get(30); 
   }

  @GetMapping("/pokemonList")
  public List<String[]> getPokemonList() throws IOException, URISyntaxException, CsvException {
    // do something to get list of pokemon maybe paged
    List<String[]> lister = CsvParser.test();
    return lister;
  }

  @GetMapping("/pokemonListHeaders")
  public String[] getPokemonHeaders() throws Exception {

    List<String[]> pokemonList = CsvParser.test();
    if (pokemonList == null || pokemonList.size() == 0) {
      return null;
    }

    System.out.println(pokemonList.get(0)[30]);

    return pokemonList.get(0);
  }

  @GetMapping("/pokemon")
  public String[] getPokemon(@RequestParam String pokemonName) throws Exception {
    return pokemonMap.get(pokemonName.toLowerCase());
  }

}
