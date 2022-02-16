package com.example.red_fibraoptica.db.entidades;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Grupo_mantenimiento.class,
        parentColumns = "idGM",childColumns = "id_gm_u",onDelete = CASCADE))
public class Usuarios_CasMag {
    @PrimaryKey
    public int id_U;
    @ColumnInfo(name = "id_gm_u")
    public int id_gm_u;
    public String nombre_u;
    public String apellidos;
    public String email;
    public String password;
    public String cargo;
    public Usuarios_CasMag() {
    }

    public Usuarios_CasMag(int id_U, int id_gm_u, String nombre_u, String apellidos, String email, String password, String cargo) {
        this.id_U = id_U;
        this.id_gm_u = id_gm_u;
        this.nombre_u = nombre_u;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.cargo = cargo;
    }

}
