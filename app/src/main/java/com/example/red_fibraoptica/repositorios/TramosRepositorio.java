package com.example.red_fibraoptica.repositorios;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.red_fibraoptica.db.Database_F_O;
import com.example.red_fibraoptica.db.daos.RadioBasesDao;
import com.example.red_fibraoptica.db.daos.TramosDao;
import com.example.red_fibraoptica.db.entidades.Radio_Bases;
import com.example.red_fibraoptica.db.entidades.Tramo_fo;

import java.util.List;

public class TramosRepositorio {
    private TramosDao tramosDao;
    private LiveData<List<Tramo_fo>> allTramos;

    public TramosRepositorio(Application application){
        Database_F_O db = Database_F_O.getDataBase(application);
        tramosDao = db.tramosDao();
        allTramos = tramosDao.getAllTramo();
    }
    public LiveData<List<Tramo_fo>> getAllTramos() {
        return allTramos;
    }
    //METODO PARA INSERTAR DATOS de los tramos
    public void insertTramos(Tramo_fo tramo_fo) {
        new TramosRepositorio.insertTramosAsyntask(tramosDao).execute(tramo_fo);
    }

    private static class insertTramosAsyntask extends AsyncTask<Tramo_fo, Void, Void> {
        private TramosDao tramosDaoAsynctask;

        insertTramosAsyntask(TramosDao dao) {
            tramosDaoAsynctask = dao;
        }

        @Override
        protected Void doInBackground(Tramo_fo... tramo_fos) {
            tramosDaoAsynctask.insertTramo(tramo_fos[0]);
            return null;
        }
    }
}
