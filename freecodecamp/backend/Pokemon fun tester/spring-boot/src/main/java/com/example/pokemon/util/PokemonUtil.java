package com.example.pokemon.util;

import com.example.pokemon.models.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonUtil {

    public void testMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValueAsString(new Pokemon()});
    }
    
}
