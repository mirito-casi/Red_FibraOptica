package com.example.red_fibraoptica.ui.empalmes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.red_fibraoptica.R;
import com.example.red_fibraoptica.db.entidades.Empalmes_fibraOptica;

import java.util.zip.Inflater;

public class NuevoEmpalmeFragment extends DialogFragment {

    private NuevoEmpalmeViewModel nuevoEmpalmeViewModel;
    private View view;

    private EditText edtIdtramoEmpalme,edtNombreEmpalme,edtDistanciaEmpalme,edtNumeroPoste,edtTipoCaja,edtCordenadEmpalme,edtDetalleEmpalme;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Registrar empalmes");
        builder.setMessage("nuevo empalme")
                .setPositiveButton("guardar emp", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String id_tramo = edtIdtramoEmpalme.getText().toString();
                        String nombre_empalme = edtNombreEmpalme.getText().toString();
                        String distancia = edtDistanciaEmpalme.getText().toString();
                        String numero_poste = edtNumeroPoste.getText().toString();
                        String tipo_caja = edtTipoCaja.getText().toString();
                        String cordenada = edtCordenadEmpalme.getText().toString();
                        String detalle = edtDetalleEmpalme.getText().toString();
                        //comunicar al viewmodel el nuevo dato
                        NuevoEmpalmeViewModel nuevoEmpalmeViewModel = ViewModelProviders.of(getActivity()).get(NuevoEmpalmeViewModel.class);
                        nuevoEmpalmeViewModel.insertarEmpalmes(new Empalmes_fibraOptica(Integer.parseInt(id_tramo),nombre_empalme,
                                Double.parseDouble(distancia),numero_poste,tipo_caja,cordenada,detalle));

                        if(id_tramo.isEmpty()){
                            edtIdtramoEmpalme.setError("falta id");
                            edtIdtramoEmpalme.requestFocus();
                            return;
                        }else {
                            Toast.makeText(getActivity(), "guardado correctamente", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                })
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view =inflater.inflate(R.layout.fragment_nuevo_empalme,null);

        edtIdtramoEmpalme = view.findViewById(R.id.edtIdTramoEmpalme);
        edtNombreEmpalme = view.findViewById(R.id.edtNombreEmpalme);
        edtDistanciaEmpalme = view.findViewById(R.id.edtDistanciaEmpalme);
        edtNumeroPoste = view.findViewById(R.id.edtNumPoste);
        edtTipoCaja = view.findViewById(R.id.edtTipoCajaEmpalme);
        edtCordenadEmpalme = view.findViewById(R.id.edtCordenadaEmpalme);
        edtDetalleEmpalme = view.findViewById(R.id.edtDetalleEmpalme);

        builder.setView(view);

        return builder.create();
    }
}
