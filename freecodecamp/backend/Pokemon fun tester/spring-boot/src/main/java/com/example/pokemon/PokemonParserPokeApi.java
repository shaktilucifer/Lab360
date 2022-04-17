import java.util.List;
import java.util.Map;

import com.example.Pokemon;
import com.example.pokemon.interfaces.PokemonDataParser;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class PokemonParserPokeApi implements PokemonDataParser{

    @Override
    public List<Pokemon> getPokemonList() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
          = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<String> response
          = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        return null;
    }

    @Override
    public Map<String, String> getPokemonAbilities() {
        // TODO Auto-generated method stub
        return null;
    }



}