package com.example.pokemon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

public class PokemonDataBuilder {

    public static final Integer POKEMON_NAME_COLUMN = 30;
    public static final Integer POKEMON_HEADER_COLUMN = 1;

    static Map<String, String[]> pokemonDetailsMap = new HashMap<>();
    static List<String[]> pokemonCSVList = new LinkedList<>();
    static PokemonParserOpenCsv pokemonParserOpenCsv = PokemonParserOpenCsv.getInstance();
    @PostConstruct
    private void buildPokemonMap() throws Exception {
      pokemonCSVList = pokemonParserOpenCsv.getRawPokemonData();
      
      for(String[] pokemon: pokemonCSVList) {
        pokemonDetailsMap.put(pokemon[30].toLowerCase(), pokemon);
      }
    }

    public static Map<String, String[]> getPokemonMap() {
        return pokemonDetailsMap;
    }
    
    public static List<String[]> getPokemonList() {
        return pokemonCSVList;
    }
    
}
