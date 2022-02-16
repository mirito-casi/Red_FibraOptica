package com.example.red_fibraoptica.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.red_fibraoptica.db.entidades.Grupo_mantenimiento;

import java.util.List;

@Dao
public interface GrupoMttoDao {
    @Insert
    void insertGM(Grupo_mantenimiento grupoMantenimiento);

    @Update
    void updatGM(Grupo_mantenimiento grupoMantenimiento);

    @Delete
    void deletGM(Grupo_mantenimiento grupoMantenimiento);

    @Query("SELECT *FROM Grupo_mantenimiento ORDER BY nombre_grupo_mtto ASC")
    LiveData<List<Grupo_mantenimiento>> getAllGM();
}
