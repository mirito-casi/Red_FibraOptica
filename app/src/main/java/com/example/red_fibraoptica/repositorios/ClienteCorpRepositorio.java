package com.example.red_fibraoptica.repositorios;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.red_fibraoptica.db.Database_F_O;
import com.example.red_fibraoptica.db.daos.ClientesCorpDao;
import com.example.red_fibraoptica.db.entidades.Clientes_Corporativos;


import java.util.List;

public class ClienteCorpRepositorio {
    private ClientesCorpDao clientesCorpDao;
    private LiveData<List<Clientes_Corporativos>> allClienteCorpo;


    public ClienteCorpRepositorio(Application application) {
        Database_F_O db = Database_F_O.getDataBase(application);
        clientesCorpDao = db.clientesCorpDao();
        allClienteCorpo = clientesCorpDao.getAllClienteC();
        // allgrupoMttoById = grupoMttoDao.();

    }

    public LiveData<List<Clientes_Corporativos>> getAllClienteCorpo() {
        return allClienteCorpo;
    }

    //METODO PARA INSERTAR DATOS DE LOS CLIENTES CORPORATIVOS
    public void insertClienteCorpo(Clientes_Corporativos clientes_corporativos) {
        new ClienteCorpRepositorio.insertClienteCorpAsyntask(clientesCorpDao).execute(clientes_corporativos);
    }

    private static class insertClienteCorpAsyntask extends AsyncTask<Clientes_Corporativos, Void, Void> {
        private ClientesCorpDao clientesCorpDaoAsynctask;

        insertClienteCorpAsyntask(ClientesCorpDao dao) {
            clientesCorpDaoAsynctask = dao;
        }
        @Override
        protected Void doInBackground(Clientes_Corporativos... clientes_corporativos) {
            clientesCorpDaoAsynctask.insertClienteC(clientes_corporativos[0]);
            return null;
        }
    }
}
