package com.example.appcitamedica;

import android.content.Context;
import android.content.SharedPreferences;

public class Usuario{

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    private String usuario;
    private String contrasena;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    private String nombre;
    private String apellido;
    private String direccion;


    // Método para guardar el usuario en SharedPreferences
    public void guardarUsuario(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("usuario", usuario);
        editor.putString("password", contrasena);
        editor.putString("nombre", nombre);
        editor.putString("apellido", apellido);
        editor.putString("direccion", direccion);
        editor.apply();
    }


    // Método estático para autenticar un usuario desde SharedPreferences
    public static boolean autenticar(Context context, String usuarioIngresado, String passwordIngresado) {
        SharedPreferences sharedPref = context.getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE);
        String usuarioGuardado = sharedPref.getString("usuario", "");
        String passwordGuardado = sharedPref.getString("password", "");

        return usuarioIngresado.equals(usuarioGuardado) && passwordIngresado.equals(passwordGuardado);
    }
}


