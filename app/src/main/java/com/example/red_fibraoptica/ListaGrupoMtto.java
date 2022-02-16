package com.example.red_fibraoptica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.red_fibraoptica.db.entidades.Grupo_mantenimiento;
import com.example.red_fibraoptica.ui.grupo_mantenimiento_f_o.GrupoMttoFragment;
import com.example.red_fibraoptica.ui.grupo_mantenimiento_f_o.GrupoMttoRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaGrupoMtto extends AppCompatActivity {
private RecyclerView recyclerViewGrupoMtto;
    private List<Grupo_mantenimiento> grupo_mantenimientoList;
    private GrupoMttoRecyclerViewAdapter adapterGM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_grupo_mtto);
        recyclerViewGrupoMtto = findViewById(R.id.rvListaGrupoMtto);

        grupo_mantenimientoList = new ArrayList<>();
      adapterGM = new GrupoMttoRecyclerViewAdapter(grupo_mantenimientoList,getApplicationContext());
      recyclerViewGrupoMtto.setAdapter(adapterGM);
    }
}
