package com.example.pokemon;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

class CsvParser {
    // do some parsing on Pokemon Data next
    public static List<String[]> test() throws IOException, URISyntaxException, CsvException {
        // fix is
        System.out.println(Paths.get("."));
        System.out.println(ClassLoader.getSystemResource("resources/static/pokemon.csv"));
        Reader reader = Files.newBufferedReader(Paths.get(
            ClassLoader.getSystemResource("pokemon.csv").toURI()));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();
        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }
}