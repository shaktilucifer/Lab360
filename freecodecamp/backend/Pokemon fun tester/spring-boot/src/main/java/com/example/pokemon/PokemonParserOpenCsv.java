package com.example.pokemon;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.example.pokemon.interfaces.PokemonDataParser;
import com.example.pokemon.models.Pokemon;
import com.opencsv.CSVReader;

public class PokemonParserOpenCsv implements PokemonDataParser {

    private String fileName = "pokemon.csv";
    private List<String[]> rawPokemonList = new LinkedList<>();
    public static final Integer POKEMON_NAME_COLUMN = 30;
    public static final Integer POKEMON_HEADER_COLUMN = 1;
    public static final Integer ABILITY_COLUMN = 0;

    private static PokemonParserOpenCsv pokemonParser;

    PokemonParserOpenCsv() {
        loadResources();
    }

    PokemonParserOpenCsv(String fileName) {
        this.fileName = fileName;
        loadResources();
    }

    public static PokemonParserOpenCsv getInstance() {
        System.out.println("instance");
        if (pokemonParser == null) {
            pokemonParser = new PokemonParserOpenCsv();
        }
        return pokemonParser;
    }

    @PostConstruct
    private void buildPokemonMap() throws Exception {
        loadResources();
    }

    /**
     * load all the csv data from the file here
     */
    private void loadResources() {
        try {
            rawPokemonList = parseCSV("resources/" + fileName);
        } catch (Exception e) {
            // TODO logger
            System.out.println("log error parsing resources");
        }
    }

    public List<String[]> parseCSV(String fileToParse) throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource(fileToParse).toURI()));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();
        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }

    public List<String[]> getRawPokemonData() {
        try {
            return parseCSV(fileName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rawPokemonList;
    }

    @Override
    public List<Pokemon> getPokemonList() {
        List<Pokemon> pokemons = new LinkedList<>();
        for (String[] pokemonRawRow : getRawPokemonData()) {
            pokemons.add(new Pokemon(pokemonRawRow[POKEMON_HEADER_COLUMN], pokemonRawRow[2]));
        }
        return pokemons;
    }

    @Override
    public Map<String, String> getPokemonAbilities() {
        Map<String, String> pokemonAbilityMap = new HashMap<>();
        List<String> abilities = new LinkedList<>();
        for (String[] pokemonRawRow : getRawPokemonData()) {
            pokemonAbilityMap.put(pokemonRawRow[POKEMON_NAME_COLUMN], pokemonRawRow[ABILITY_COLUMN]);
            abilities.add(pokemonRawRow[ABILITY_COLUMN]);
        }
        return pokemonAbilityMap;
    }

}
