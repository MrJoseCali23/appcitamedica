package com.example.appcitamedica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearUsuario extends AppCompatActivity {
    private EditText editNombre, editApellido, editUsuario, editContrasena, editDireccion;
    private Button btnCrearUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);

        editNombre = findViewById(R.id.editNombre);
        editApellido = findViewById(R.id.editApellido);
        editUsuario = findViewById(R.id.editUsuario);
        editContrasena = findViewById(R.id.editContrasena);
        editDireccion = findViewById(R.id.editDireccion);
        btnCrearUsuario = findViewById(R.id.btnCrearUsuario);


        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editNombre.getText().toString();
                String apellido = editApellido.getText().toString();
                String usuario = editUsuario.getText().toString();
                String contrasena = editContrasena.getText().toString();
                String direccion = editDireccion.getText().toString();

                if (nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || contrasena.isEmpty() || direccion.isEmpty()) {
                    Toast.makeText(CrearUsuario.this, "Por favor ingrese todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Usuario nuevoUsuario = new Usuario(usuario, contrasena);
                    nuevoUsuario.setNombre(nombre);
                    nuevoUsuario.setApellido(apellido);
                    nuevoUsuario.setDireccion(direccion);
                    nuevoUsuario.guardarUsuario(CrearUsuario.this);

                    Toast.makeText(CrearUsuario.this, "Usuario creado con éxito", Toast.LENGTH_SHORT).show();

                    // Redirigir a la actividad de login
                    Intent intent = new Intent(CrearUsuario.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}