package com.example.red_fibraoptica.ui.tramos;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.red_fibraoptica.R;
import com.example.red_fibraoptica.db.entidades.Tramo_fo;
import com.google.android.material.textfield.TextInputLayout;

import java.util.zip.Inflater;

public class TramosFragment extends Fragment {


    private TramosViewModel mViewModel;
    private TextInputLayout edtIdgmT, edtNobretramo, edtdistanciaTramo, edtPuntoA, edtPuntoB;
    private Button btnRegsitrarTramo;

    public static TramosFragment newInstance() {
        return new TramosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tramos_fragment, container, false);
        edtIdgmT = view.findViewById(R.id.edtiIdGMt);
        edtNobretramo = view.findViewById(R.id.edtinombreTramo);
        edtdistanciaTramo = view.findViewById(R.id.edtdistanciatramo);
        edtPuntoA = view.findViewById(R.id.edtiPuntoA);
        edtPuntoB = view.findViewById(R.id.edtiPuntoB);
        btnRegsitrarTramo = view.findViewById(R.id.btnRegsitrarTramo);

        btnRegsitrarTramo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idgmt = edtIdgmT.getEditText().getText().toString();
                String nombre_tramo = edtNobretramo.getEditText().getText().toString();
                String distancia = edtdistanciaTramo.getEditText().getText().toString();
                String punto_a = edtPuntoA.getEditText().getText().toString();
                String punto_b = edtPuntoB.getEditText().getText().toString();
                if(idgmt.isEmpty()){
                    edtIdgmT.setError("ingrese id GM");
                    edtIdgmT.requestFocus();
                    return;
                }

                if(nombre_tramo.isEmpty()){
                    edtNobretramo.setError("nombre tramo");
                    edtNobretramo.requestFocus();
                    return;
                }

                if(distancia.isEmpty()){
                    edtdistanciaTramo.setError("ingrese distancia");
                    edtdistanciaTramo.requestFocus();
                    return;
                }

                if(punto_a.isEmpty()){
                    edtPuntoA.setError("elija rbs");
                    edtPuntoA.requestFocus();
                    return;
                }

                if(punto_b.isEmpty()){
                    edtPuntoB.setError("punto B del tramo");
                    edtPuntoB.requestFocus();
                    return;
                }


                mViewModel.insertTramos(new Tramo_fo(Integer.parseInt(idgmt),nombre_tramo,Double.parseDouble(distancia),Integer.parseInt(punto_a),Integer.parseInt(punto_b)));
                Toast.makeText(getActivity(), "guardado exitoso", Toast.LENGTH_SHORT).show();
                limpiarCajas();
            }
        });
        return view;
    }

    private void limpiarCajas() {
        edtIdgmT.getEditText().setText("");
        edtNobretramo.getEditText().setText("");
        edtdistanciaTramo.getEditText().setText("");
        edtPuntoA.getEditText().setText("");
        edtPuntoB.getEditText().setText("");
        edtIdgmT.requestFocus();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TramosViewModel.class);
        // TODO: Use the ViewModel
    }
}
