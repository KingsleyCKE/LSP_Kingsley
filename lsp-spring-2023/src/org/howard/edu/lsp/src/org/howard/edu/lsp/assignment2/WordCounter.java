package org.howard.edu.lsp.assignment2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class WordCounter {
    private static final Path INPUT_FILE = Paths.get("src/main/resources/words.txt");

    public static void main(String[] args) {
        HashMap<String, Integer> wordCounts = new HashMap<>();

        try (Stream<String> lines = Files.lines(INPUT_FILE, StandardCharsets.UTF_8)) {
            lines.forEach(line -> {
                String[] words = line.split("[\\s\\d\\p{Punct}]+");
                for (String word : words) {
                    String lowerWord = word.toLowerCase();
                    if (lowerWord.length() > 3) {
                        wordCounts.put(lowerWord, wordCounts.getOrDefault(lowerWord, 0) + 1);
                    }
                }
            });
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        for (Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + "    " + entry.getValue());
        }
    }
}
