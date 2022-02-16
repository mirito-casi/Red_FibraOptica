package com.example.red_fibraoptica.ui.tramos;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.red_fibraoptica.db.entidades.Radio_Bases;
import com.example.red_fibraoptica.db.entidades.Tramo_fo;
import com.example.red_fibraoptica.repositorios.TramosRepositorio;

import java.util.List;

public class TramosViewModel extends AndroidViewModel {
    private LiveData<List<Tramo_fo>> allTramos;
    private TramosRepositorio tramosRepositorio;

    public TramosViewModel(@NonNull Application application) {
        super(application);
        tramosRepositorio = new TramosRepositorio(application);
        allTramos = tramosRepositorio.getAllTramos();
    }
    // TODO: Implement the ViewModel
    public void insertTramos(Tramo_fo nuevoTramo){
        tramosRepositorio.insertTramos(nuevoTramo);
        if(nuevoTramo!= null){
            Toast.makeText(getApplication(), "se guardo correctamente", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplication(), "erro!! ", Toast.LENGTH_SHORT).show();
        }
    }
}
