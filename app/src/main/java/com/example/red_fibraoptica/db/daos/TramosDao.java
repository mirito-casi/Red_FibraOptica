package com.example.red_fibraoptica.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.red_fibraoptica.db.entidades.Tramo_fo;

import java.util.List;

@Dao
public interface TramosDao {
    @Insert
    void insertTramo(Tramo_fo tramofo);
    @Update
    void updatTramo(Tramo_fo tramofo);
    @Delete
    void deletTramo(Tramo_fo tramofo);
    @Query("SELECT *FROM Tramo_fo ORDER BY tramo ASC")
    LiveData<List<Tramo_fo>> getAllTramo();

    @Query("SELECT *FROM Tramo_fo WHERE id_gm_t =:idgmt")
    LiveData< List<Tramo_fo>> allTramosById(int idgmt);
}
