package com.example.pokemon;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.Pokemon;
import com.example.pokemon.interfaces.PokemonDataParser;
import com.opencsv.CSVReader;

public class PokemonParserOpenCsv implements PokemonDataParser {

    private String fileName = "pokemon.csv";
    private List<String[]> rawPokemonList = new LinkedList<>();
    public static final Integer POKEMON_NAME_COLUMN = 30;
    public static final Integer POKEMON_HEADER_COLUMN = 1;
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
            System.out.println("filename" + fileName);
            System.out.println(parseCSV("resources/" + fileName));
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
        System.out.println("'TESTER'" + list);
        return list;
    }

    public List<String[]> getRawPokemonData() {
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
    public List<String> getPokemonAbilities() {
        // TODO Auto-generated method stub
        return null;
    }

}
