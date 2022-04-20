package com.example.pokemon.models;

import com.example.Pokemon;
import com.example.pokemon.PokemonType;

public class PokemonRecord extends Pokemon {

    PokemonRecord(String name, PokemonType pokemonType) {
        super(name, pokemonType);
        //TODO Auto-generated constructor stub
    }

    int hitPoints;
    int attack;
    int defense;
    int specialDefense;
    int specialAttack;
    int speed;
    
}
