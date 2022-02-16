package com.example.red_fibraoptica.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.red_fibraoptica.db.daos.ClientesCorpDao;
import com.example.red_fibraoptica.db.daos.EmpalmeFODao;
import com.example.red_fibraoptica.db.daos.GrupoMttoDao;
import com.example.red_fibraoptica.db.daos.RadioBasesDao;
import com.example.red_fibraoptica.db.daos.TramosDao;
import com.example.red_fibraoptica.db.daos.UsuariosDao;
import com.example.red_fibraoptica.db.entidades.Clientes_Corporativos;
import com.example.red_fibraoptica.db.entidades.Empalmes_fibraOptica;
import com.example.red_fibraoptica.db.entidades.Grupo_mantenimiento;
import com.example.red_fibraoptica.db.entidades.Radio_Bases;
import com.example.red_fibraoptica.db.entidades.Tramo_fo;
import com.example.red_fibraoptica.db.entidades.Usuarios_CasMag;

@Database(entities = {Grupo_mantenimiento.class, Radio_Bases.class,
        Clientes_Corporativos.class,
        Tramo_fo.class, Empalmes_fibraOptica.class,
        Usuarios_CasMag.class}, version = 1,exportSchema = false)
public abstract class Database_F_O extends RoomDatabase {
    public abstract GrupoMttoDao grupoMttoDao();

    public abstract RadioBasesDao radioBasesDao();

    public abstract ClientesCorpDao clientesCorpDao();

    public abstract TramosDao tramosDao();

    public abstract EmpalmeFODao empalmeFODao();

    public abstract UsuariosDao usuariosDao();

    private static volatile Database_F_O INSTANCE;

    public static Database_F_O getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database_F_O.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database_F_O.class, "database_f_o")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    public static void destroyInstance(){INSTANCE = null;}
}
