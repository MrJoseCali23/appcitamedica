package com.example.appcitamedica.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Especialidad implements Serializable {
    private String nombre;
    private ArrayList<Medico> medicos;

    public Especialidad(String nombre) {
        this.nombre = nombre;
        this.medicos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void addMedico(Medico medico) {
        this.medicos.add(medico);
    }
    @Override
    public String toString() {
        return nombre;
    }
}

