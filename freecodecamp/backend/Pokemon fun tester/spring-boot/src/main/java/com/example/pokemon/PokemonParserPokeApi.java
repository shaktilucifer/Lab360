package com.example.pokemon;

import java.util.List;
import java.util.Map;

import com.example.Pokemon;
import com.example.pokemon.interfaces.PokemonDataParser;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

class PokemonParserPokeApi implements PokemonDataParser{

    private final static String POKE_API = "https://pokeapi.co/api/v2/pokemon?limit=1126/";

    @Override
    public List<Pokemon> getPokemonList() {
      WebClient webClient = WebClient.create(POKE_API);
      webClient.get()
      .uri("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
      .retrieve();
      
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
          = "https://pokeapi.co/api/v2/pokemon?limit=1126/";
        ResponseEntity<String> response
          = restTemplate.getForEntity(fooResourceUrl, String.class);
        return null;
    }

    @Override
    public Map<String, String> getPokemonAbilities() {
        // TODO Auto-generated method stub
        return null;
    }



}