package com.example.red_fibraoptica.db.entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.red_fibraoptica.ui.radio_bases.RadioBasesFragment;

@Entity
public class Grupo_mantenimiento {

    @PrimaryKey(autoGenerate = true)
    public int idGM;
    public String regional;
    public String nombre_grupo_mtto;
    public String proyecto;
    public String empresa;
    public Grupo_mantenimiento(RadioBasesFragment radioBasesFragment) {
    }

    public Grupo_mantenimiento(String regional, String nombre_grupo_mtto, String proyecto, String empresa) {
        this.regional = regional;
        this.nombre_grupo_mtto = nombre_grupo_mtto;
        this.proyecto = proyecto;
        this.empresa = empresa;
    }

    public int getIdGM() {
        return idGM;
    }

    public void setIdGM(int idGM) {
        this.idGM = idGM;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getNombre_grupo_mtto() {
        return nombre_grupo_mtto;
    }

    public void setNombre_grupo_mtto(String nombre_grupo_mtto) {
        this.nombre_grupo_mtto = nombre_grupo_mtto;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre_grupo_mtto;
    }
}
