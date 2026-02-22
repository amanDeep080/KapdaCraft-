package com.example.demo.service;



import org.springframework.stereotype.Service;

@Service
public class SuggestionService {

    public String generateSuggestion(String description) {

        description = description.toLowerCase();

        if(description.contains("silk") || description.contains("heavy")) {
            return "Best option: Lehenga (4-5 meters approx)";
        }
        else if(description.contains("cotton")) {
            return "Best option: Suit (2.5-3 meters approx)";
        }
        else if(description.contains("georgette")) {
            return "Best option: Sharara (3-4 meters approx)";
        }

        return "Indo-western outfit (3-4 meters approx)";
    }
}