package com.example.pokemon;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.example.Pokemon;
import com.opencsv.exceptions.CsvException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

  private static Map<String, String[]> pokemonMap = PokemonDataBuilder.getPokemonMap();
  private PokemonParserOpenCsv parser;
  
  @PostConstruct
  private void buildPokemonData() {
    parser = PokemonParserOpenCsv.getInstance();
  }

  @RequestMapping("/")
  public String[] helloWorld() throws Exception {
    return PokemonDataBuilder.getPokemonList().get(0);
  }

  @GetMapping("/pokemonList")
  public List<String[]> getPokemonList() throws IOException, URISyntaxException, CsvException {
    return PokemonDataBuilder.getPokemonList();
  }

  @GetMapping("/pokemons") 
  public List<Pokemon> getPokemons() {
    return parser.getPokemonList();
  }

  @GetMapping("/pokemonListHeaders")
  public String[] getPokemonHeaders() throws Exception {

    List<String[]> pokemonList = PokemonDataBuilder.getPokemonList();
    if (pokemonList == null || pokemonList.size() == 0) {
      return null;
    }

    System.out.println(pokemonList.get(0)[PokemonDataBuilder.POKEMON_NAME_COLUMN]);

    return pokemonList.get(PokemonDataBuilder.POKEMON_HEADER_COLUMN);
  }

  @GetMapping("/pokemon")
  public String[] getPokemon(@RequestParam String pokemonName) throws Exception {
    return pokemonMap.get(pokemonName.toLowerCase());
  }

}
