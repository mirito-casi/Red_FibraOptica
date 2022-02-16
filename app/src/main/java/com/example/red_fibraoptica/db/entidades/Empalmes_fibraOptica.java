package com.example.red_fibraoptica.db.entidades;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Tramo_fo.class,
        parentColumns = "idT",childColumns = "id_tramo",onDelete = CASCADE))
public class Empalmes_fibraOptica {

    @PrimaryKey(autoGenerate = true)
    public int idE;
    public int id_tramo;
    private String nombre_e;
    private double distancia_e;
    private String num_poste;
    private String tipo_caja;
    private String cordenada;
    private String detalle;

    public Empalmes_fibraOptica() {
    }

    public Empalmes_fibraOptica(int id_tramo, String nombre_e, double distancia_e, String num_poste, String tipo_caja, String cordenada, String detalle) {
        this.id_tramo = id_tramo;
        this.nombre_e = nombre_e;
        this.distancia_e = distancia_e;
        this.num_poste = num_poste;
        this.tipo_caja = tipo_caja;
        this.cordenada = cordenada;
        this.detalle = detalle;
    }

    public int getId_tramo() {
        return id_tramo;
    }

    public void setId_tramo(int id_tramo) {
        this.id_tramo = id_tramo;
    }

    public String getNombre_e() {
        return nombre_e;
    }

    public void setNombre_e(String nombre_e) {
        this.nombre_e = nombre_e;
    }

    public double getDistancia_e() {
        return distancia_e;
    }

    public void setDistancia_e(double distancia_e) {
        this.distancia_e = distancia_e;
    }

    public String getNum_poste() {
        return num_poste;
    }

    public void setNum_poste(String num_poste) {
        this.num_poste = num_poste;
    }

    public String getTipo_caja() {
        return tipo_caja;
    }

    public void setTipo_caja(String tipo_caja) {
        this.tipo_caja = tipo_caja;
    }

    public String getCordenada() {
        return cordenada;
    }

    public void setCordenada(String cordenada) {
        this.cordenada = cordenada;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
