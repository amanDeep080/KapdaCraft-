package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FabricRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fabricDescription;
    private String fabricImageUrl;
    private String suggestion;

    @ManyToOne
    private User user;
}