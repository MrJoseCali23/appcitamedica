package com.example.appcitamedica;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcitamedica.models.Especialidad;
import com.example.appcitamedica.models.Horario;
import com.example.appcitamedica.models.Medico;

public class ConfirmarCita extends AppCompatActivity {
    private TextView textViewConfirmacion;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_cita);

        textViewConfirmacion = findViewById(R.id.textViewConfirmacion);

        Especialidad especialidad = (Especialidad) getIntent().getSerializableExtra("especialidad");
        Medico medico = (Medico) getIntent().getSerializableExtra("medico");
        Horario horario = (Horario) getIntent().getSerializableExtra("horario");

        String mensajeConfirmacion = "Cita confirmada:\n" +
                "Especialidad: " + especialidad.getNombre() + "\n" +
                "Médico: " + medico.getNombre() + "\n" +
                "Hora: " + horario.getHora();

        textViewConfirmacion.setText(mensajeConfirmacion);
    }
}