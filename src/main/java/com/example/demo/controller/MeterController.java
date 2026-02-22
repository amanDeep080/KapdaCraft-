package com.example.demo.controller;


import com.example.demo.model.MeterRequest;
import com.example.demo.service.MeterCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meter")
@RequiredArgsConstructor
@CrossOrigin
public class MeterController {

    private final MeterCalculatorService meterCalculatorService;

    @PostMapping("/calculate")
    public String calculate(@RequestBody MeterRequest request) {
        int h = Integer.parseInt(request.getHeightCm());
        return meterCalculatorService.calculate(request.getOutfitType(), h);
    }
}