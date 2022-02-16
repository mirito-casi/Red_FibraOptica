package com.example.red_fibraoptica.ui.grupo_mantenimiento_f_o;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.red_fibraoptica.ListaGrupoMtto;
import com.example.red_fibraoptica.R;
import com.example.red_fibraoptica.db.entidades.Grupo_mantenimiento;
import com.example.red_fibraoptica.ui.empalmes.MyEmpalmesRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GrupoMttoFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private EditText edtNobreG,edtProyecto,edtEmpresa;
    private Spinner spRegionales;
    private Button btnRegistrar,btnListagm;

    private int mColumnCount = 1;
    private List<Grupo_mantenimiento> grupo_mantenimientoList;
    private RecyclerView recyclerViewGm;
    private GrupoMttoRecyclerViewAdapter adapterGrupoMtto;

    private GrupoMttoViewModel grupoMttoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        grupoMttoViewModel =
                ViewModelProviders.of(this).get(GrupoMttoViewModel.class);
        View view = inflater.inflate(R.layout.fragment_grupo_mtto, container, false);

        spRegionales = view.findViewById(R.id.spinnerRegional);
        edtNobreG = view.findViewById(R.id.edtNombreGrupo);
        edtProyecto = view.findViewById(R.id.edtProyect);
        edtEmpresa = view.findViewById(R.id.edtEmpressa);
        btnRegistrar = view.findViewById(R.id.btnRegistro);
        btnListagm = view.findViewById(R.id.btnListaGm);
        btnListagm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ListaGrupoMtto.class);
                startActivity(i);
            }
        });

       // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.regionales_bolivia, android.R.layout.simple_spinner_item);
       // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // Apply the adapter to the spinner
        spRegionales.setAdapter(adapter);
        spRegionales.setOnItemSelectedListener(this);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regional = spRegionales.getSelectedItem().toString();
                String grupo_mtto = edtNobreG.getText().toString();
                String proyecto = edtProyecto.getText().toString();
                String empresa = edtEmpresa.getText().toString();
                if(grupo_mtto.isEmpty()){
                    edtNobreG.setError("llene datos");
                    edtNobreG.findFocus();
                    return;
                }

                if(proyecto.isEmpty()){
                    edtProyecto.setError("ponga su proyecto");
                    edtProyecto.findFocus();
                    return;
                }

                if(empresa.isEmpty()){
                    edtEmpresa.setError("inserte nombre de empresa");
                    edtEmpresa.findFocus();
                    return;
                }

                grupoMttoViewModel.insertGrupoMtto(new Grupo_mantenimiento(regional,grupo_mtto,proyecto,empresa));
                limpiarCajasGM();
            }
        });


        return view;
    }

    private void limpiarCajasGM() {
        edtNobreG.setText("");
        edtProyecto.setText("");
        edtEmpresa.setText("");
        edtNobreG.requestFocus();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       // Toast.makeText(getActivity(), "estas en item "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
