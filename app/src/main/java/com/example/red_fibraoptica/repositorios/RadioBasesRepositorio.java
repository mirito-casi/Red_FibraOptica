package com.example.red_fibraoptica.repositorios;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.red_fibraoptica.db.Database_F_O;
import com.example.red_fibraoptica.db.daos.RadioBasesDao;
import com.example.red_fibraoptica.db.entidades.Radio_Bases;

import java.util.List;

public class RadioBasesRepositorio {
    private RadioBasesDao radioBasesDao;
    private LiveData<List<Radio_Bases>> allRadioBases;

    public RadioBasesRepositorio(Application application){
        Database_F_O db = Database_F_O.getDataBase(application);
        radioBasesDao = db.radioBasesDao();
        allRadioBases = radioBasesDao.getAllRadioB();
    }
    public LiveData<List<Radio_Bases>> getAllRadioBases() {
        return allRadioBases;
    }
    //METODO PARA INSERTAR DATOS de la radio bases
    public void insertRadioBase(Radio_Bases radio_bases) {
        new RadioBasesRepositorio.insertradioBasesAsyntask(radioBasesDao).execute(radio_bases);
    }

    private static class insertradioBasesAsyntask extends AsyncTask<Radio_Bases, Void, Void> {
        private RadioBasesDao radioBasesDaoAsynctask;

        insertradioBasesAsyntask(RadioBasesDao dao) {
            radioBasesDaoAsynctask = dao;
        }

        @Override
        protected Void doInBackground(Radio_Bases... radio_bases) {
            radioBasesDaoAsynctask.insertRadioB(radio_bases[0]);
            return null;
        }
    }
}
