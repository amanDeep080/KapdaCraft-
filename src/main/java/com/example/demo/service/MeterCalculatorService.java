package com.example.demo.service;



import org.springframework.stereotype.Service;

@Service
public class MeterCalculatorService {

    public String calculate(String outfitType, int heightCm) {

        outfitType = outfitType.toLowerCase();

        if (outfitType.contains("lehenga")) {
            return (heightCm >= 165) ? "Lehenga: 5 meters" : "Lehenga: 4 meters";
        }
        if (outfitType.contains("suit")) {
            return (heightCm >= 165) ? "Suit: 3 meters" : "Suit: 2.5 meters";
        }
        if (outfitType.contains("sharara")) {
            return (heightCm >= 165) ? "Sharara: 4 meters" : "Sharara: 3.5 meters";
        }
        return (heightCm >= 165) ? "Indo-western: 4 meters" : "Indo-western: 3.5 meters";
    }
}
