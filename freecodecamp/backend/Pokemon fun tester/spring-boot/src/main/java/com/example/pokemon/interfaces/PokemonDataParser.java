package com.example.pokemon.interfaces;

import java.util.List;
import java.util.Map;

import com.example.Pokemon;

public interface PokemonDataParser {
    public List<Pokemon> getPokemonList();
    public Map<String, String> getPokemonAbilities();
}