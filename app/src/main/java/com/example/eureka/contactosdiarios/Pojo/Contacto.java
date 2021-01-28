package com.example.eureka.contactosdiarios.Pojo;

/**
 * Created by Eureka on 20/1/2021.
 */

public class Contacto {

    Integer id;
    private String nombre;
    private String telefono;
    private Integer dia;
    private Integer mes;
    private Integer año;

    public Contacto( Integer id, String nombre, String telefono, Integer dia, Integer mes, Integer año){
        this.id= id;
        this.nombre= nombre;
        this.telefono= telefono;
        this.dia= dia;
        this.mes= mes;
        this.año= año;
    }

    public Contacto( String nombre, Integer dia, Integer mes, Integer año){

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

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }
}
