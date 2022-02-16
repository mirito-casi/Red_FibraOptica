package com.example.red_fibraoptica.ui.clientes_corporativos;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.red_fibraoptica.R;
import com.example.red_fibraoptica.db.entidades.Clientes_Corporativos;
import com.example.red_fibraoptica.db.entidades.Radio_Bases;

import java.util.ArrayList;
import java.util.List;

public class ClienteCorpoFragment extends Fragment {
    private EditText edtidRBS,edtNobreCliente,edtOdfCliente,edtRX,edtTX,edtLongitudCliente,edtDetalleClient;
    private Button btnRegistrarClienteCorp;
    private Spinner spClientesCorp;
    private List<Radio_Bases> radio_basesList;


    private ClienteCorpoViewModel mViewModel;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState ){

        mViewModel = ViewModelProviders.of(this).get(ClienteCorpoViewModel.class);
        View view = inflater.inflate(R.layout.cliente_corpo_fragment, container, false);
        edtidRBS = view.findViewById(R.id.edtid_rbsCliente);
        edtNobreCliente = view.findViewById(R.id.edtnobrecliente);
        edtOdfCliente = view.findViewById(R.id.edtOdfCliente);
        edtRX = view.findViewById(R.id.edthiloRX);
        edtTX = view.findViewById(R.id.edtTX);
        edtLongitudCliente = view.findViewById(R.id.edtLongitudTramoCliente);
        edtDetalleClient = view.findViewById(R.id.edtDetalleCliente);
        btnRegistrarClienteCorp = view.findViewById(R.id.btnRegClientescorp);
        spClientesCorp = view.findViewById(R.id.spinnerClienteCorporativo);

        btnRegistrarClienteCorp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_rbs = edtidRBS.getText().toString();
                String nombre_cliente = edtNobreCliente.getText().toString();
                String odf = edtOdfCliente.getText().toString();
                String hilo_rx = edtRX.getText().toString();
                String hilo_tx = edtTX.getText().toString();
                String longitud_cliente = edtLongitudCliente.getText().toString();
                String detalle = edtDetalleClient.getText().toString();

                if(id_rbs.isEmpty()){
                    edtidRBS.setError("id radio base");
                    return;
                }

                mViewModel.insertClientesCorp(new Clientes_Corporativos(Integer.parseInt(id_rbs),nombre_cliente,odf,Integer.parseInt(hilo_rx),Integer.parseInt(hilo_tx),Double.parseDouble(longitud_cliente),detalle));
                Toast.makeText(getActivity(), "se guardo correctamente", Toast.LENGTH_SHORT).show();
                limpiarCajasClientes();
            }
        });

        return view;
    }

    private void limpiarCajasClientes() {
        edtidRBS.setText("");
        edtNobreCliente.setText("");
        edtOdfCliente.setText("");
        edtRX.setText("");
        edtTX.setText("");
        edtLongitudCliente.setText("");
        edtDetalleClient.setText("");
        edtidRBS.requestFocus();
    }
}
