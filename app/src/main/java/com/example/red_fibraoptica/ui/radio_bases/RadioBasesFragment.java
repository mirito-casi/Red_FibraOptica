package com.example.red_fibraoptica.ui.radio_bases;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.red_fibraoptica.R;
import com.example.red_fibraoptica.db.Database_F_O;
import com.example.red_fibraoptica.db.daos.GrupoMttoDao;
import com.example.red_fibraoptica.db.entidades.Grupo_mantenimiento;
import com.example.red_fibraoptica.db.entidades.Radio_Bases;
import com.example.red_fibraoptica.repositorios.GrupoMttoRepositorio;
import com.example.red_fibraoptica.ui.grupo_mantenimiento_f_o.GrupoMttoViewModel;

import java.util.ArrayList;
import java.util.List;

public class RadioBasesFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner spGrupoMtto;
    private EditText edtIdGm, edtnombreRBS, edtCitio, edtPropietario, edtUbicicion;
    private Button btnRgtroRBS;
    private Radio_Bases radio_bases;
    private List<Radio_Bases> radio_basesList;
    //adaptadores para el spinner
    SimpleCursorAdapter generarSpinnerAdapter;
    //Nuestro origen de datos
    Grupo_mantenimiento grupo_mantenimiento;
    private GrupoMttoViewModel grupoMttoViewModel;

    private RadioBasesViewModel radioBasesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //iniciando nuestro origen de datos
        grupo_mantenimiento = new Grupo_mantenimiento(this);
        grupoMttoViewModel = ViewModelProviders.of(this).get(GrupoMttoViewModel.class);
        grupoMttoViewModel.getAllGrupoMttos().observe(getActivity(), new Observer<List<Grupo_mantenimiento>>() {
            @Override
            public void onChanged(List<Grupo_mantenimiento> grupo_mantenimientos) {

            }
        });

        radioBasesViewModel =
                ViewModelProviders.of(this).get(RadioBasesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_radio_bases, container, false);

        radio_bases = new Radio_Bases();
        radio_basesList = new ArrayList<>();

        edtIdGm = root.findViewById(R.id.edtIdGM);
        edtnombreRBS = root.findViewById(R.id.edtNombreRBS);
        edtCitio = root.findViewById(R.id.edtCitio);
        edtPropietario = root.findViewById(R.id.edtPropietario);
        edtUbicicion = root.findViewById(R.id.edtUbicacion);
        btnRgtroRBS = root.findViewById(R.id.btnRegistrarRBS);
        //otenemos la instancia del spinner
        spGrupoMtto = root.findViewById(R.id.spinnerGrupoMtto);
        //creando adaptador para el spinner
        generarSpinnerAdapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_spinner_item,
               null,//obtener todos los registros falta poner de donde obtener
                new String[]{grupo_mantenimiento.nombre_grupo_mtto},
                new int[]{android.R.id.edit},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        //seteando adaptador de spGruMtto
        spGrupoMtto.setAdapter(generarSpinnerAdapter);


        spGrupoMtto.setOnItemSelectedListener(this);

        btnRgtroRBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String idGrupoMtto = edtIdGm.getText().toString();
               String nombrerbs = edtnombreRBS.getText().toString();
               String citio = edtCitio.getText().toString();
               String propietario = edtPropietario.getText().toString();
               String ubicacion = edtUbicicion.getText().toString();

               if(idGrupoMtto.isEmpty()){
                   edtIdGm.setError("ingrese el id del grupo mtto");
                   edtIdGm.requestFocus();
                   return;
               }
               if(nombrerbs.isEmpty()){
                   edtnombreRBS.setError("falta nombre rbs");
                   edtnombreRBS.requestFocus();
                   return;
               }
               if(citio.isEmpty()){
                   edtCitio.setError("agregue citio");
                   edtCitio.requestFocus();
                   return;
               }
               if(propietario.isEmpty()){
                   edtPropietario.setError("agregue propietario");
                   edtPropietario.requestFocus();
                   return;
               }
               if(ubicacion.isEmpty()){
                   edtUbicicion.setError("agregue ubicacion");
                   edtUbicicion.requestFocus();
                   return;
               }try {
                    radioBasesViewModel.insertRadioBases(new Radio_Bases(Integer.parseInt(idGrupoMtto),nombrerbs,citio,propietario,ubicacion));
                      limpiarCajasRBS();
                }catch (ArrayIndexOutOfBoundsException e){
                    Toast.makeText(getActivity(), "no se puede guardar"+e, Toast.LENGTH_SHORT).show();
                }
           }
        });
        return root;
    }



    private void limpiarCajasRBS() {
        edtIdGm.setText("");
        edtnombreRBS.setText("");
        edtCitio.setText("");
        edtPropietario.setText("");
        edtUbicicion.setText("");
        edtIdGm.requestFocus();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
