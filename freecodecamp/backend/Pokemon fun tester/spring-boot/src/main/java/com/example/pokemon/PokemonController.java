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
  public String helloWorld() {
    return "Hello World from Spring Boot";
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
    List<String[]> pokemonList = CsvParser.test();
    System.out.println(pokemonName);
    System.out.println(pokemonList.size());
    if (pokemonList == null || pokemonList.size() == 0) {
      return null;
    }
    String[] pokemon = pokemonList.stream().filter( i -> i[30].equalsIgnoreCase(pokemonName)).findAny().orElse(null);

    return pokemon;
  }

  @GetMapping("/ability")
  public List<Pokemon> getAbility(@RequestParam String id, @RequestParam(required = false) String pokemonName) {
    return new LinkedList<>();
  }

}
