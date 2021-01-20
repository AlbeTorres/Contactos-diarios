package com.example.eureka.contactosdiarios.Pojo;

/**
 * Created by Eureka on 20/1/2021.
 */

public class Contacto {

    private String nombre;
    private String telefono;

    public Contacto( String nombre, String telefono){
        this.nombre= nombre;
        this.telefono= telefono;
    }
    public Contacto( String nombre){
        this.nombre= nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
