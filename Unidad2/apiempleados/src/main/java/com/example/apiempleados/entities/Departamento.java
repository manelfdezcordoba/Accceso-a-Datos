package com.example.apiempleados.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Table(name= "departamentos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
            private String apellido;
    private LocalDate fechaNacimiento;

@OneToMany(mappedBy = "departamento", cascade = CascadeType.PERSIST, orphanRemoval = false)
    private List<Empleado> empleados = new ArrayList<>();

}
