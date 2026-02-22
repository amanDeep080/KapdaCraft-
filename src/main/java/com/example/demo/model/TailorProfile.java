package com.example.demo.model;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TailorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String city;

    // comma separated: Lehenga,Suit,Sharara
    private String skills;

    private String startingPrice; // "500", "800", etc
}