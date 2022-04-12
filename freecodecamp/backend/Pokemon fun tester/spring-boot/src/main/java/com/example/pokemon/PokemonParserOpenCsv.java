import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.example.Pokemon;
import com.example.pokemon.interfaces.PokemonDataParser;

public class PokemonParserOpenCsv  implements PokemonDataParser{

    private String fileName = "pokemon.csv";
    public static final Integer POKEMON_NAME_COLUMN = 30;
    public static final Integer POKEMON_HEADER_COLUMN = 1;

     
    @PostConstruct
    private void buildPokemonMap() throws Exception {
        loadResources();
    }

    PokemonParserOpenCsv(String fileName) {
        this.fileName = fileName;
        loadResources();
    }

    static Map<String, String[]> pokemonDetailsMap = new HashMap<>();


    /**
     * load all the csv data from the file here
     */
    private void loadResources() {
        
        return;
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
