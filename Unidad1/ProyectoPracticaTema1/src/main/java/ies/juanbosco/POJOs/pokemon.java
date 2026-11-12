package ies.juanbosco.POJOs;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor

public class pokemon {
    private int id;
    private String nombre;
    private int numero;
    private String genero;
    private String habilidad;
    private int identrandor;
    private String nombreEnt;
    public pokemon(int id, String nombre, int numero, String genero, String habilidad, int identrandor){
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.genero = genero;
        this.habilidad = habilidad;
        this.identrandor = identrandor;
    }
}
