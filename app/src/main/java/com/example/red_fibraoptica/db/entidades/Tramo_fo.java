package com.example.red_fibraoptica.db.entidades;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Grupo_mantenimiento.class,
        parentColumns = "idGM",
        childColumns = "id_gm_t",
        onDelete = CASCADE))
public class Tramo_fo {
    @PrimaryKey(autoGenerate = true)
    public int idT;
    @ColumnInfo(name = "id_gm_t")
    public int id_gmT;
    public String tramo;
    public double distancia_tramo;
    public int punto_a;
    public int punto_b;

    public Tramo_fo() {
    }

    public Tramo_fo(int id_gmT, String tramo, double distancia_tramo, int punto_a, int punto_b) {
        this.id_gmT = id_gmT;
        this.tramo = tramo;
        this.distancia_tramo = distancia_tramo;
        this.punto_a = punto_a;
        this.punto_b = punto_b;
    }

    public int getId_gmT() {
        return id_gmT;
    }

    public void setId_gmT(int id_gmT) {
        this.id_gmT = id_gmT;
    }

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public double getDistancia_tramo() {
        return distancia_tramo;
    }

    public void setDistancia_tramo(double distancia_tramo) {
        this.distancia_tramo = distancia_tramo;
    }

    public int getPunto_a() {
        return punto_a;
    }

    public void setPunto_a(int punto_a) {
        this.punto_a = punto_a;
    }

    public int getPunto_b() {
        return punto_b;
    }

    public void setPunto_b(int punto_b) {
        this.punto_b = punto_b;
    }
}
