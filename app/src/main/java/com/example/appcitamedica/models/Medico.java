package com.example.appcitamedica.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Medico implements Serializable {
    private String nombre;
    private ArrayList<Horario> horarios;

    public Medico(String nombre) {
        this.nombre = nombre;
        this.horarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void addHorario(Horario horario) {
        this.horarios.add(horario);
    }
    @Override
    public String toString() {
        return nombre;
    }
}
