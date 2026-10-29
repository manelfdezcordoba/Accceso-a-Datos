package ies.juanbosco;

import java.util.ArrayList;

public class Main  {
    public static void main (String[] args){
        Alumno alumn1 = new Alumno("Manel", "Fernandez", 22);
        Alumno alumn2 = new Alumno("Pilar", "Muñoz", 20);

        Curso curso1 = new Curso("DAM2", "Desarrollo de aplicacioens multiplataforma", new ArrayList<>());
        curso1.getAlumnos().add(alumn1);
        curso1.getAlumnos().add(alumn2);

        System.out.println(curso1.getCodigo() + curso1.getTitulo());


        curso1.getAlumnos().forEach(a-> {
            System.out.println("-" + a.getNombre()+ " " + a.getApellido() + "| Edad: "+ a.getEdad());
        });

    }
}