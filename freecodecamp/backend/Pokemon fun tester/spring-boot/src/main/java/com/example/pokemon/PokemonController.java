package com.example.pokemon;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.example.pokemon.models.Pokemon;
import com.example.pokemon.util.PokemonUtil;
import com.opencsv.exceptions.CsvException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PokemonController {

  private static Map<String, String[]> pokemonMap = PokemonDataBuilder.getPokemonMap();
  private PokemonParserOpenCsv parser;

  @PostConstruct
  private void buildPokemonData() {
    parser = PokemonParserOpenCsv.getInstance();
  }

  @RequestMapping("/")
  public List<String[]> helloWorld() throws Exception {
    return parser.getRawPokemonData();
  }

  @RequestMapping("/debug")
  public Map<Integer, String> headerToNumberMap() {
    Map<Integer, String> headerToNumberMap = new HashMap<>();
    int i = 0;
    for (String headerColumn : parser.getRawPokemonData().get(3)) {
      headerToNumberMap.put(i++, headerColumn);
    }
    return headerToNumberMap;
  }

  @GetMapping("/pokemons")
  public List<Pokemon> getPokemons() {
    return parser.getPokemonList().stream().sorted((a, b) -> b.getSpecialAttack() - a.getSpecialAttack())
        .collect(Collectors.toList());
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
  public List<Pokemon> getPokemon(@RequestParam String pokemonName) throws Exception {
    return parser.getPokemonList().stream().filter(i -> i.getName().equals(pokemonName)).collect(Collectors.toList());
  }

}
