package ies.juanbosco;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String titulo;

    List<Alumno> alumnos = new ArrayList<>();


    public Curso() {

    }
public Curso(String codigo , String titulo, List<Alumno> alumno){
        this.codigo = codigo;
        this.titulo = titulo;
        this.alumnos = alumno;
}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
