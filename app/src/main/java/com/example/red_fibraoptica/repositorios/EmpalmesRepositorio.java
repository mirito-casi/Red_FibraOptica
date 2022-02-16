package com.example.red_fibraoptica.repositorios;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.red_fibraoptica.db.Database_F_O;
import com.example.red_fibraoptica.db.daos.EmpalmeFODao;
import com.example.red_fibraoptica.db.entidades.Empalmes_fibraOptica;

import java.util.List;

public class EmpalmesRepositorio {
    private EmpalmeFODao empalmeFODao;
    private LiveData<List<Empalmes_fibraOptica>> allEmpalmes;

    public EmpalmesRepositorio(Application application){
        Database_F_O db = Database_F_O.getDataBase(application);
        empalmeFODao = db.empalmeFODao();
        allEmpalmes = empalmeFODao.getAllEmpalmes();
    }
    public LiveData<List<Empalmes_fibraOptica>> getAllEmpalmess(){return allEmpalmes;}

    //metodo para insertar datos
    public void insertEmpalmes(Empalmes_fibraOptica empalmes_fibraOptica){
        new insertEmpalmeAsyntask(empalmeFODao).execute(empalmes_fibraOptica);
    }

    private static class insertEmpalmeAsyntask extends AsyncTask<Empalmes_fibraOptica,Void,Void>{
        private EmpalmeFODao empalmeFODaoAsyntask;

        insertEmpalmeAsyntask(EmpalmeFODao dao){
            empalmeFODaoAsyntask = dao;
        }
        @Override
        protected Void doInBackground(Empalmes_fibraOptica... empalmes_fibraOpticas) {
            empalmeFODaoAsyntask.insertEmpalm(empalmes_fibraOpticas[0]);
            return null;
        }
    }
}
