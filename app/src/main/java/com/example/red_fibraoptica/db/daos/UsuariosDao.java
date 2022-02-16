package com.example.red_fibraoptica.db.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.red_fibraoptica.db.entidades.Usuarios_CasMag;

@Dao
public interface UsuariosDao {
    @Insert
    void insertUsuario(Usuarios_CasMag usuariosCasMag);

    @Update
    void updateUsuario(Usuarios_CasMag usuariosCasMag);

    @Delete
    void deletUsuario(Usuarios_CasMag usuariosCasMag);

}
