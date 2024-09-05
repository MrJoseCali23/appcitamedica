package com.example.appcitamedica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcitamedica.models.Especialidad;
import com.example.appcitamedica.models.Horario;
import com.example.appcitamedica.models.Medico;

import java.util.ArrayList;

public class SeleccionarHorario extends AppCompatActivity {

    private Medico medico;
    private Especialidad especialidad;
    private TextView txtdoc, txtespe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_horario);

        // Inicializar los TextViews
        txtdoc = findViewById(R.id.txtdoc);
        txtespe = findViewById(R.id.txtespe);

        // Obtener los datos del Intent
        medico = (Medico) getIntent().getSerializableExtra("medico");
        especialidad = (Especialidad) getIntent().getSerializableExtra("especialidad");

        // Configurar los TextViews con los datos recibidos
        txtespe.setText(" "+(especialidad));
        txtdoc.setText("Médico: " + (medico ));

        // Configurar el ListView con los horarios
        ListView listaHorarios = findViewById(R.id.listaHorarios);
        ArrayAdapter<Horario> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medico != null ? medico.getHorarios() : new ArrayList<Horario>());
        listaHorarios.setAdapter(adapter);

        // Configurar el listener para la selección de horarios
        listaHorarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Horario horarioSeleccionado = medico != null ? medico.getHorarios().get(position) : null;
                Intent intent = new Intent(SeleccionarHorario.this, ConfirmarCita.class);

                // Pasar los datos seleccionados a la siguiente actividad
                intent.putExtra("especialidad", especialidad);
                intent.putExtra("medico", medico);
                intent.putExtra("horario", horarioSeleccionado);

                startActivity(intent);
            }
        });
    }
}
