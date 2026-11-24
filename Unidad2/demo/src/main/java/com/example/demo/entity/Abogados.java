package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="abogado")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Abogados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Jueces juez;


}
