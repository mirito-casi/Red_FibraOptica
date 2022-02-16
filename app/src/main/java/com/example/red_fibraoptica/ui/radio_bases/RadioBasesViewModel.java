package com.example.red_fibraoptica.ui.radio_bases;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.red_fibraoptica.db.entidades.Radio_Bases;
import com.example.red_fibraoptica.repositorios.RadioBasesRepositorio;

import java.util.List;

public class RadioBasesViewModel extends AndroidViewModel {
    private LiveData<List<Radio_Bases>> allRadioBases;
    private RadioBasesRepositorio radioBasesRepositorio;

    public RadioBasesViewModel(Application application){
        super(application);

        radioBasesRepositorio = new RadioBasesRepositorio(application);
        allRadioBases = radioBasesRepositorio.getAllRadioBases();
    }
    public void insertRadioBases(Radio_Bases nuevoRadioBases){
        radioBasesRepositorio.insertRadioBase(nuevoRadioBases);
        if(nuevoRadioBases!= null){
            Toast.makeText(getApplication(), "se guardo correctamente", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplication(), "erro!! el ID no existe", Toast.LENGTH_SHORT).show();
        }
    }
}