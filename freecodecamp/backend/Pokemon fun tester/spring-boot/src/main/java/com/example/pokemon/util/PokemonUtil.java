package com.example.pokemon.util;

import com.example.pokemon.models.Pokemon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonUtil {

    public void testMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValueAsString(new Pokemon());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
}
