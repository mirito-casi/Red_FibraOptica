package com.example.red_fibraoptica.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.red_fibraoptica.db.entidades.Empalmes_fibraOptica;

import java.util.List;

@Dao
public interface EmpalmeFODao {

    @Insert
    void insertEmpalm(Empalmes_fibraOptica empalmesFibraOptica);

    @Update
    void updateEmpalm(Empalmes_fibraOptica empalmesFibraOptica);

    @Delete
    void deletEmpalm(Empalmes_fibraOptica empalmesFibraOptica);

    @Query("SELECT *FROM empalmes_fibraoptica ORDER BY distancia_e ASC")
    LiveData<List<Empalmes_fibraOptica>> getAllEmpalmes();
}
