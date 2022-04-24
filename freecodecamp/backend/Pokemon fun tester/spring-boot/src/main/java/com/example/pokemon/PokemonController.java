package com.example.pokemon;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.example.pokemon.models.Pokemon;
import com.example.pokemon.util.PokemonUtil;
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
    return parser.getRawPokemonData().get(0);
  }

  @RequestMapping("/debug")
  public Map<Integer, String> headerToNumberMap() {
    Map<Integer, String> headerToNumberMap = new HashMap<>();
    int i = 0;
    for (String headerColumn : parser.getRawPokemonData().get(0)) {
        headerToNumberMap.put(i++, headerColumn);
    }
    return headerToNumberMap;
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
