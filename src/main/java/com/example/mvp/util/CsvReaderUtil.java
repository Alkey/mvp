package com.example.mvp.util;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReaderUtil {
    public static List<String[]> read(String fileName) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(fileName));
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .build();
        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .build();
        List<String[]> strings = csvReader.readAll();
        reader.close();
        csvReader.close();
        return strings;
    }
}
