package com.example.eureka.contactosdiarios.Pojo;

/**
 * Created by Eureka on 20/1/2021.
 */

public class Contacto {

    Integer id;
    private String nombre;
    private String telefono;
    private String dia;
    private String mes;
    private String año;

    public Contacto( Integer id, String nombre, String telefono, String dia, String mes, String año){
        this.id= id;
        this.nombre= nombre;
        this.telefono= telefono;
        this.dia= dia;
        this.mes= mes;
        this.año= año;
    }

    public Contacto( String nombre, String dia, String mes, String año){

        this.nombre= nombre;
        this.dia=dia;
        this.mes= mes;
        this.año= año;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}
