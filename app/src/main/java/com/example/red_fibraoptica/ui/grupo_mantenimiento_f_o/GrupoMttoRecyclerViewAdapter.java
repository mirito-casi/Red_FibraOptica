package com.example.red_fibraoptica.ui.grupo_mantenimiento_f_o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.red_fibraoptica.R;
import com.example.red_fibraoptica.db.entidades.Grupo_mantenimiento;

import java.util.List;

public class GrupoMttoRecyclerViewAdapter extends RecyclerView.Adapter<GrupoMttoRecyclerViewAdapter.MyViewHolder> {

    private List<Grupo_mantenimiento> mValues;
    private Context ctx;

    public GrupoMttoRecyclerViewAdapter(List<Grupo_mantenimiento> grupo_mantenimientoList, Context ctx) {
        mValues = grupo_mantenimientoList;
       this.ctx= ctx;

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public View mView;
        public final TextView mTxtNombreGM;
        public final TextView mTxtProyecto;
        public Grupo_mantenimiento mItem;

        public MyViewHolder(@NonNull View view) {
            super(view);
          mView = view;
          mTxtNombreGM = view.findViewById(R.id.txtGrupoMtto);
          mTxtProyecto = view.findViewById(R.id.txtProyecto);
        }
    }

    @NonNull
    @Override
    public GrupoMttoRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grupomtto,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrupoMttoRecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        holder.mTxtNombreGM.setText(holder.mItem.getNombre_grupo_mtto());
        holder.mTxtProyecto.setText(holder.mItem.getProyecto());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "isisteclick a qui", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
