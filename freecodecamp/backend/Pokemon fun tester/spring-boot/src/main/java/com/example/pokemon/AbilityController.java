package com.example.pokemon;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.opencsv.exceptions.CsvException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
