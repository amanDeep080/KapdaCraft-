package com.example.demo.controller;



import com.example.demo.model.TailorProfile;
import com.example.demo.repository.TailorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tailors")
@RequiredArgsConstructor
@CrossOrigin
public class TailorController {

    private final TailorRepository tailorRepository;

    @PostMapping
    public TailorProfile addTailor(@RequestBody TailorProfile tailor) {
        return tailorRepository.save(tailor);
    }

    @GetMapping
    public List<TailorProfile> allTailors() {
        return tailorRepository.findAll();
    }

    @GetMapping("/city/{city}")
    public List<TailorProfile> byCity(@PathVariable String city) {
        return tailorRepository.findByCityIgnoreCase(city);
    }
}
