package com.example.red_fibraoptica.repositorios;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import com.example.red_fibraoptica.db.Database_F_O;
import com.example.red_fibraoptica.db.daos.GrupoMttoDao;
import com.example.red_fibraoptica.db.entidades.Grupo_mantenimiento;

import java.util.List;

public class GrupoMttoRepositorio {
    private GrupoMttoDao grupoMttoDao;
    private LiveData<List<Grupo_mantenimiento>> allGrupoMtto;
    private List<Grupo_mantenimiento> allgrupoMttoById;


    public GrupoMttoRepositorio(Application application) {
        Database_F_O db = Database_F_O.getDataBase(application);
        grupoMttoDao = db.grupoMttoDao();
        allGrupoMtto = grupoMttoDao.getAllGM();
       // allgrupoMttoById = grupoMttoDao.();

    }

    public LiveData<List<Grupo_mantenimiento>> getAllGrupoMtto() {
        return allGrupoMtto;
    }

//METODO PARA INSERTAR DATOS al Grupo Mantenimiento
    public void insertGMantenimiento(Grupo_mantenimiento grupoMantenimiento) {
        new insertGMantenimientoAsyntask(grupoMttoDao).execute(grupoMantenimiento);
    }

    private static class insertGMantenimientoAsyntask extends AsyncTask<Grupo_mantenimiento, Void, Void> {
        private GrupoMttoDao grupoMttoDaoAsynctask;

        insertGMantenimientoAsyntask(GrupoMttoDao dao) {
            grupoMttoDaoAsynctask = dao;
        }
        @Override
        protected Void doInBackground(Grupo_mantenimiento... grupo_mantenimientos) {
          grupoMttoDaoAsynctask.insertGM(grupo_mantenimientos[0]);
          return null;
        }
    }
  /*  //METODO PARA ACTUALIZAR DATOS
    public void updateEmpalme(EmpalmeEntity empalmeEntity){
      new updateEmpalmeAsyntask(empalmeDao).execute(empalmeEntity);
    }
    private static class updateEmpalmeAsyntask extends AsyncTask<EmpalmeEntity,Void,Void>{
        private EmpalmeDao empalmeDaoAsynctask;

        updateEmpalmeAsyntask(EmpalmeDao dao){
            empalmeDaoAsynctask=dao;
        }

        @Override
        protected Void doInBackground(EmpalmeEntity... empalmeEntities) {
           empalmeDaoAsynctask.updateEmpalme(empalmeEntities[0]);
            return null;
        }
    }
    //METODO PARA ELIMINAR EMPALMES POR ID
    public void deletEmpalme(EmpalmeEntity empalmeEntity){
        new deletEmpalmeAsyncTask(empalmeDao).execute(empalmeEntity);

    }
    private static  class deletEmpalmeAsyncTask extends AsyncTask<EmpalmeEntity,Void,Void>{
        private EmpalmeDao empalmeDaoDeletAsynctask;
        deletEmpalmeAsyncTask(EmpalmeDao dao){
            empalmeDaoDeletAsynctask = dao;
        }

        @Override
        protected Void doInBackground(EmpalmeEntity... empalmeEntities) {
            empalmeDaoDeletAsynctask.deleteEmpalme(empalmeEntities[0]);
            return null;
        }
    }*/

}
