package ies.juanbosco;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString


public class Alumno {
    private String nombre;
    private String apellido;
    private int edad;
    private int codMatricula;

    public Alumno(){

    }
    public Alumno(String nombre, String apellido , int edad){
        this.apellido =apellido;
        this.nombre = nombre;
        this.edad = edad;
    }



}
