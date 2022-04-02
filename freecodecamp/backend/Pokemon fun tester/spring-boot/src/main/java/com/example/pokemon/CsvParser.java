package com.example.pokemon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

class CsvParser {
    // do some parsing on Pokemon Data next
    public static void test() {
        // fix is
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
Iterable<CSVRecord> csvRecords = csvParser.getRecords();
    }
}