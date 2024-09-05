package com.example.appcitamedica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import com.example.appcitamedica.models.Especialidad;
import com.example.appcitamedica.models.Horario;
import com.example.appcitamedica.models.Medico;

public class perfil extends AppCompatActivity {
    private TextView txthola;
    private ArrayList<Especialidad> especialidades;
    private ImageButton  btnReservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        txthola = findViewById(R.id.txthola);
        btnReservar = findViewById(R.id.btnReservar);

        // Cargar el nombre del usuario desde las preferencias o el intent
        SharedPreferences sharedPref = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE);
        String nombre = sharedPref.getString("nombre", null);
        txthola.setText("Bienvenido, " + nombre);

        // Inicializar datos de ejemplo
        inicializarDatos();

        // Configurar el botón para redirigir a la actividad de selección de especialidad
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(perfil.this, SeleccionarEspecialidad.class);
                intent.putExtra("especialidades", especialidades);
                startActivity(intent);

            }
        });
    }

    private void inicializarDatos() {
        especialidades = new ArrayList<>();

        // Array con nombres de especialidades para simplificar
        String[] nombresEspecialidades = {"Cardiología", "Dermatología", "Neurología", "Pediatría", "Ginecología"};

        // Array con nombres de médicos para simplificar
        String[] nombresMedicos = {"Jose Lopez Quintanilla", "Ana Rojas Peredo", "Enzo Olguin Tamarez", "Patricia Santander", "Oscar Gonzales"};

        // Generar datos de prueba
        for (String nombreEspecialidad : nombresEspecialidades) {
            Especialidad especialidad = new Especialidad(nombreEspecialidad);

            for (String nombreMedico : nombresMedicos) {
                Medico medico = new Medico(nombreMedico);

                // Agregar 8 horarios al médico
                for (int i = 1; i <= 8; i++) {
                    String hora = (i <= 4 ? (8 + i) : (i - 4)) + ":00 " + (i <= 4 ? "AM" : "PM");
                    medico.addHorario(new Horario(hora));
                }

                especialidad.addMedico(medico);
            }

            especialidades.add(especialidad);
        }
    }

}