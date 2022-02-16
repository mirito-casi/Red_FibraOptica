package com.example.red_fibraoptica.ui.clientes_corporativos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.red_fibraoptica.db.entidades.Clientes_Corporativos;
import com.example.red_fibraoptica.db.entidades.Radio_Bases;
import com.example.red_fibraoptica.repositorios.ClienteCorpRepositorio;

import java.util.List;

public class ClienteCorpoViewModel extends AndroidViewModel {
    private ClienteCorpRepositorio clienteCorpRepositorio;
    private LiveData<List<Clientes_Corporativos>> allCleinreCorp;

    public ClienteCorpoViewModel(@NonNull Application application) {
        super(application);
        clienteCorpRepositorio = new ClienteCorpRepositorio(application);
        allCleinreCorp = clienteCorpRepositorio.getAllClienteCorpo();
    }
    //fragmento que necesita el nuevo dato
    public LiveData<List<Clientes_Corporativos>> getAllCleinreCorp(){return allCleinreCorp;}
    //fragmento que inserta los datos
    public void insertClientesCorp(Clientes_Corporativos nuevosClienteCorp){
        clienteCorpRepositorio.insertClienteCorpo(nuevosClienteCorp);
    }
}
