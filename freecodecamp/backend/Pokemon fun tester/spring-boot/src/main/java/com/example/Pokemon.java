package com.example;

import com.example.pokemon.PokemonType;

public class Pokemon {
    private String name;
    private PokemonType type;

    Pokemon(String name, PokemonType pokemonType) {
        this.name = name;
        this.type = pokemonType;
    }

    public String getName() {
        return name;
    }

    public PokemonType getPokemonType() {
        return type;
    }
    
}
