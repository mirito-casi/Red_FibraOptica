package com.example.red_fibraoptica.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.red_fibraoptica.db.entidades.Radio_Bases;

import java.util.List;

@Dao
public interface RadioBasesDao {
    @Insert
    void insertRadioB(Radio_Bases radio_bases);
    @Update
    void updatRadioB(Radio_Bases radio_bases);
    @Delete
    void deletRadioB(Radio_Bases radio_bases);

    @Query("SELECT *FROM Radio_Bases ORDER BY nombre_rbs ASC")
    LiveData<List<Radio_Bases>> getAllRadioB();
    @Query("SELECT *FROM Radio_Bases WHERE id_gm_r = :idgmr")
    LiveData<List<Radio_Bases>> allRadioBbyId(int idgmr);
}
