package com.example.red_fibraoptica.db.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Grupo_mantenimiento.class,
                      parentColumns = "idGM",
                      childColumns = "id_gm_r",onDelete = CASCADE))
public class Radio_Bases {
    @PrimaryKey(autoGenerate = true)
    public int idR;
    @ColumnInfo(name = "id_gm_r")
    public int id_gmFR;
    public String nombre_rbs;
    public String citio;
    public String propietario;
    public String ubicacion;

    public Radio_Bases() {
    }

    public Radio_Bases(int id_gmFR, String nombre_rbs, String citio, String propietario, String ubicacion) {
        this.id_gmFR = id_gmFR;
        this.nombre_rbs = nombre_rbs;
        this.citio = citio;
        this.propietario = propietario;
        this.ubicacion = ubicacion;
    }

    public int getId_gmFR() {
        return id_gmFR;
    }

    public void setId_gmFR(int id_gmFR) {
        this.id_gmFR = id_gmFR;
    }

    public String getNombre_rbs() {
        return nombre_rbs;
    }

    public void setNombre_rbs(String nombre_rbs) {
        this.nombre_rbs = nombre_rbs;
    }

    public String getCitio() {
        return citio;
    }

    public void setCitio(String citio) {
        this.citio = citio;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
