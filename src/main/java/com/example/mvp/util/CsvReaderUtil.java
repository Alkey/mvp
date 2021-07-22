package com.example.mvp.util;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReaderUtil {
    private static final CSVParser parser = new CSVParserBuilder()
            .withSeparator(';')
            .build();

    public static List<String[]> read(String fileName) {
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName));
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withCSVParser(parser)
                     .build()) {
            return csvReader.readAll();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
