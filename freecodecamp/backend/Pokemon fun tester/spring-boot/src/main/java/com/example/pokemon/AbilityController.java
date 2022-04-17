package com.example.pokemon;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbilityController {

  private PokemonParserOpenCsv parser;

  @PostConstruct
  private void buildPokemonData() {
    parser = PokemonParserOpenCsv.getInstance();
  }

  @GetMapping("/abilities")
  public Map<String, String> getAbilities() {
    return parser.getPokemonAbilities();
  }

}
