package com.example;

import com.example.pokemon.PokemonType;

public class Pokemon {
    private String name;
    private PokemonType type;
    private String test;

    Pokemon(String name, PokemonType pokemonType) {
        this.name = name;
        this.type = pokemonType;
    }

    public Pokemon(String name, String test) {
        this.name = name;
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public PokemonType getPokemonType() {
        return type;
    }

    public String getTest() {
        return test;
    }
    
}
