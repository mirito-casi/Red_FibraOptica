package com.example.red_fibraoptica.db.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Radio_Bases.class,
        parentColumns = "idR",
        childColumns = "id_r_f",onDelete = CASCADE))
public class Clientes_Corporativos {
    @PrimaryKey(autoGenerate = true)
    public int idC;
    @ColumnInfo(name = "id_r_f")
    public int id_R_F;
    private String cliente;
    private String odf;
    private int hilo_transmision;
    private int hilo_recepcion;
    private double longitud;
    private String detalle;

    public Clientes_Corporativos() {
    }

    public Clientes_Corporativos(int id_R_F, String cliente, String odf, int hilo_transmision, int hilo_recepcion, double longitud, String detalle) {
        this.id_R_F = id_R_F;
        this.cliente = cliente;
        this.odf = odf;
        this.hilo_transmision = hilo_transmision;
        this.hilo_recepcion = hilo_recepcion;
        this.longitud = longitud;
        this.detalle = detalle;
    }

    public int getId_R_F() {
        return id_R_F;
    }

    public void setId_R_F(int id_R_F) {
        this.id_R_F = id_R_F;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getOdf() {
        return odf;
    }

    public void setOdf(String odf) {
        this.odf = odf;
    }

    public int getHilo_transmision() {
        return hilo_transmision;
    }

    public void setHilo_transmision(int hilo_transmision) {
        this.hilo_transmision = hilo_transmision;
    }

    public int getHilo_recepcion() {
        return hilo_recepcion;
    }

    public void setHilo_recepcion(int hilo_recepcion) {
        this.hilo_recepcion = hilo_recepcion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
