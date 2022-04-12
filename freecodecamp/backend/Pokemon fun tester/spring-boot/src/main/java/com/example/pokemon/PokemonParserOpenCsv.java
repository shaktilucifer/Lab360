import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    }

    PokemonParserOpenCsv(String fileName) {
        this.fileName = fileName;
        loadResources();
    }

    public static PokemonParserOpenCsv getInstance() {
        if(pokemonParser == null) {
            pokemonParser = new PokemonParserOpenCsv()
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
        rawPokemonList = parseCSV("resources/" + fileName);
    }

    public List<String[]> parseCSV(String fileToParse) {
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
        return rawPokemonList;
    }

    @Override
    public List<Pokemon> getPokemonList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getPokemonAbilities() {
        // TODO Auto-generated method stub
        return null;
    }

}
