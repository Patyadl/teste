package com.example.curriculo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "habilidades")
public class Habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int tempo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}