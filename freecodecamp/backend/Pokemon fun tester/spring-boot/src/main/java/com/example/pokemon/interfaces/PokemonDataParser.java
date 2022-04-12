package com.example.pokemon.interfaces;

import java.util.List;
import com.example.Pokemon;

public interface PokemonDataParser {
    public List<Pokemon> getPokemonList();
    public List<String> getPokemonAbilities();
}