package com.example.gestion_citas;

import java.util.ArrayList;

public class ModeloMedico extends ModeloPersona {
    private String especialidad;
    private String consultorio;
    private ArrayList agenda;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public ArrayList getAgenda() {
        return agenda;
    }

    public void setAgenda(ArrayList agenda) {
        this.agenda = agenda;
    }

}
