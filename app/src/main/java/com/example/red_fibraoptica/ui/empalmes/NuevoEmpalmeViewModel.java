package com.example.red_fibraoptica.ui.empalmes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.red_fibraoptica.db.entidades.Empalmes_fibraOptica;
import com.example.red_fibraoptica.repositorios.EmpalmesRepositorio;

import java.util.List;

public class NuevoEmpalmeViewModel extends AndroidViewModel {


    private LiveData<List<Empalmes_fibraOptica>> allEmpalmes;
    private EmpalmesRepositorio empalmesRepositorio;

    public NuevoEmpalmeViewModel(@NonNull Application application) {

        super(application);
        empalmesRepositorio = new EmpalmesRepositorio(application);
        allEmpalmes = empalmesRepositorio.getAllEmpalmess();
    }
    //el fragmento que necisita recibir el nuevo empalme
    public LiveData<List<Empalmes_fibraOptica>> getAllEmpalmes(){
        return allEmpalmes;
    }
    //implementamos el metodo para insertar empalmes
    public void insertarEmpalmes(Empalmes_fibraOptica nuevoEmpalmefo){
        empalmesRepositorio.insertEmpalmes(nuevoEmpalmefo);
    }
}