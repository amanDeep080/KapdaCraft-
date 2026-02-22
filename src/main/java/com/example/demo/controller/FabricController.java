package com.example.demo.controller;


import com.example.demo.model.FabricRequest;
import com.example.demo.repository.FabricRepository;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabric")
@RequiredArgsConstructor
@CrossOrigin
public class FabricController {

    private final FabricRepository fabricRepository;
    private final SuggestionService suggestionService;

    @PostMapping("/ask")
    public FabricRequest askSuggestion(@RequestBody FabricRequest request) {
        String suggestion = suggestionService.generateSuggestion(request.getFabricDescription());
        request.setSuggestion(suggestion);
        return fabricRepository.save(request);
    }

    @GetMapping("/history")
    public List<FabricRequest> history() {
        return fabricRepository.findAll();
    }
}