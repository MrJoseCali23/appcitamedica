package com.example.appcitamedica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcitamedica.models.Especialidad;
import com.example.appcitamedica.models.Medico;


public class SeleccionarMedico extends AppCompatActivity {

    private Especialidad especialidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_medico);

        ListView listaMedicos = findViewById(R.id.listaMedicos);
        especialidad = (Especialidad) getIntent().getSerializableExtra("especialidad");

        ArrayAdapter<Medico> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, especialidad.getMedicos());
        listaMedicos.setAdapter(adapter);

        listaMedicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Medico medicoSeleccionado = especialidad.getMedicos().get(position);
                Intent intent = new Intent(SeleccionarMedico.this, SeleccionarHorario.class);
                intent.putExtra("especialidad", especialidad);
                intent.putExtra("medico", medicoSeleccionado);
                startActivity(intent);
            }

        });
        ImageButton backButton = findViewById(R.id.atras);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}