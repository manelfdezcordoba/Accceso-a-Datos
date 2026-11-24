package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name="juez")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Jueces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int identificacion;
    private LocalDate fecha;

    @JsonIgnore
    @OneToMany (mappedBy = "juez", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Abogados> abogado = new ArrayList<>();
}
