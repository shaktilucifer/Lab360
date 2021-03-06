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

import org.apache.commons.lang3.StringUtils;

public class PokemonParserOpenCsv implements PokemonDataParser {

    private String fileName = "pokemon.csv";
    private List<String[]> rawPokemonList = new LinkedList<>();
    public static final Integer POKEMON_NAME_COLUMN = 30;
    public static final Integer POKEMON_HEADER_COLUMN = 1;
    public static final Integer ABILITY_COLUMN = 0;
    public static final Integer ATTACK = 19;
    public static final Integer SP_ATTACK = 33;
    public static final Integer SPECIAL_DEFENSE = 34;
    public static final Integer SPEED = 35;
    public static final Integer DEFENSE = 25;
    public static final Integer HIT_POINTS = 28;
    public static final Integer TYPE1 = 36;
    public static final Integer TYPE2 = 37;

    private static PokemonParserOpenCsv pokemonParser;

    PokemonParserOpenCsv() {
        loadResources();
    }

    PokemonParserOpenCsv(String fileName) {
        this.fileName = fileName;
        loadResources();
    }

    public static PokemonParserOpenCsv getInstance() {
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
        int i = 0;
        for (String[] pokemonRawRow : getRawPokemonData()) {
            if (i++ == 0)
                continue;
            System.out.println(pokemonRawRow[HIT_POINTS]);
            PokemonType[] pokemonTypes;
            try {
                if (!StringUtils.isEmpty(pokemonRawRow[TYPE2].toUpperCase())) {
                    pokemonTypes = new PokemonType[] { PokemonType.valueOf(pokemonRawRow[TYPE1].toUpperCase()), PokemonType.valueOf(pokemonRawRow[TYPE2].toUpperCase()) };
                } else {
                    pokemonTypes = new PokemonType[] { PokemonType.valueOf(pokemonRawRow[TYPE1].toUpperCase()) };
                }
            } catch (Exception e) {
                System.out.println(pokemonRawRow[TYPE1].toUpperCase());
                System.out.println(pokemonRawRow[TYPE2].toUpperCase());
                System.out.println(e);
                return null;
            }
            pokemons.add(new Pokemon(pokemonRawRow[POKEMON_NAME_COLUMN],
                    pokemonTypes,
                    pokemonRawRow[37],
                    Integer.parseInt(pokemonRawRow[HIT_POINTS]),
                    Integer.parseInt(pokemonRawRow[ATTACK]),
                    Integer.parseInt(pokemonRawRow[DEFENSE]),
                    Integer.parseInt(pokemonRawRow[SPECIAL_DEFENSE]),
                    Integer.parseInt(pokemonRawRow[SP_ATTACK]),
                    Integer.parseInt(pokemonRawRow[SPEED])));

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
