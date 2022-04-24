package com.example.pokemon.models;

import com.example.pokemon.PokemonType;

public class Pokemon {
    private String name;
    private PokemonType[] type;
    private String test;
    private int hitPoints;
    private int attack;
    private int defense;
    private int specialDefense;
    private int specialAttack;
    private int speed;

    public Pokemon(String name, PokemonType[] type, String test, int hitPoints, int attack, int defense,
            int specialDefense, int specialAttack, int speed) {
        this.name = name;
        this.type = type;
        this.test = test;
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.defense = defense;
        this.specialDefense = specialDefense;
        this.specialAttack = specialAttack;
        this.speed = speed;
    }

    Pokemon(String name, PokemonType[] pokemonType) {
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

    public PokemonType[] getPokemonType() {
        return type;
    }

    public String getTest() {
        return test;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType[] getType() {
        return type;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
