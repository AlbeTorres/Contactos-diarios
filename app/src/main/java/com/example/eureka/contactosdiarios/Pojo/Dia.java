package com.example.eureka.contactosdiarios.Pojo;

import java.io.Serializable;

/**
 * Created by Eureka on 20/1/2021.
 */

public class Dia implements Serializable {

    private String dia;
    private String mes;
    private String año;

    public Dia ( String dia, String mes, String año){
         this.dia = dia;
         this.mes = mes;
         this.año = año;
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
