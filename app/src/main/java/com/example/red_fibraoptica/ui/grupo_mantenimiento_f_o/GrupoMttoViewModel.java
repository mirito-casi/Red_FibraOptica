package com.example.red_fibraoptica.ui.grupo_mantenimiento_f_o;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.red_fibraoptica.repositorios.GrupoMttoRepositorio;
import com.example.red_fibraoptica.db.entidades.Grupo_mantenimiento;

import java.util.List;

public class GrupoMttoViewModel extends AndroidViewModel {
    private LiveData<List<Grupo_mantenimiento>> allGrupoMtto;
    private GrupoMttoRepositorio grupoMttoRepositorio;


   public GrupoMttoViewModel(Application application){
       super(application);
       grupoMttoRepositorio = new GrupoMttoRepositorio(application);
       allGrupoMtto = grupoMttoRepositorio.getAllGrupoMtto();
   }
   //consulta
   public LiveData<List<Grupo_mantenimiento>> getAllGrupoMttos(){return allGrupoMtto;}

   public void insertGrupoMtto(Grupo_mantenimiento nuevoGMtto){
       grupoMttoRepositorio.insertGMantenimiento(nuevoGMtto);
       if(nuevoGMtto!=null){
           Toast.makeText(getApplication(), "se registro correctamente", Toast.LENGTH_LONG).show();
       }
       else {
           Toast.makeText(getApplication(),"erro !!no se registro",Toast.LENGTH_SHORT).show();
       }
   }
}