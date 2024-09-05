package com.example.appcitamedica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import com.example.appcitamedica.models.Especialidad;


public class SeleccionarEspecialidad extends AppCompatActivity {
    private ArrayList<Especialidad> especialidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidad);

        ListView listaEspecialidades = findViewById(R.id.listaMedicos);
        especialidades = (ArrayList<Especialidad>) getIntent().getSerializableExtra("especialidades");

        ArrayAdapter<Especialidad> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, especialidades);
        listaEspecialidades.setAdapter(adapter);

        listaEspecialidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Especialidad especialidadSeleccionada = especialidades.get(position);
                Intent intent = new Intent(SeleccionarEspecialidad.this, SeleccionarMedico.class);
                intent.putExtra("especialidad", especialidadSeleccionada);
                startActivity(intent);
            }
        });
    }
}