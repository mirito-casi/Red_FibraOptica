package com.example.red_fibraoptica.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.red_fibraoptica.db.entidades.Clientes_Corporativos;

import java.util.List;

@Dao
public interface ClientesCorpDao {
    @Insert
    void insertClienteC(Clientes_Corporativos clientes_corporativos);

    @Update
    void updatClienteC(Clientes_Corporativos clientes_corporativos);
    @Delete
    void deletClienteC(Clientes_Corporativos clientes_corporativos);

    @Query("SELECT *FROM Clientes_Corporativos ORDER BY cliente ASC")
    LiveData<List<Clientes_Corporativos>> getAllClienteC();

    @Query("SELECT *FROM Clientes_Corporativos WHERE id_r_f = :idrb")
    LiveData<List<Clientes_Corporativos>> allClienteCbyId(int idrb);
}
