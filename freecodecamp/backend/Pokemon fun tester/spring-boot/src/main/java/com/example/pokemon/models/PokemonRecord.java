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

    PokemonRecord(int HP, int attack, int defense, int specialAttack, int specialDefense, int speed, String name, PokemonType pokemonType) {
        super(name, pokemonType);
        this.hitPoints = HP;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
    
}
