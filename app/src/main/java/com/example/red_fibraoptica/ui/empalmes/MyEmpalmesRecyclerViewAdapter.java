package com.example.red_fibraoptica.ui.empalmes;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.red_fibraoptica.R;
import com.example.red_fibraoptica.db.entidades.Empalmes_fibraOptica;

import java.util.List;


public class MyEmpalmesRecyclerViewAdapter extends RecyclerView.Adapter<MyEmpalmesRecyclerViewAdapter.ViewHolder> {

    private List<Empalmes_fibraOptica> mValues;
    private  NuevoEmpalmeViewModel mEmpalmeViewModel;
    private Context ctx;



    public MyEmpalmesRecyclerViewAdapter(List<Empalmes_fibraOptica> items,Context ctx) {
        mValues = items;
        this.ctx = ctx;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_empalmes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNombEmpalme.setText(holder.mItem.getNombre_e());
        holder.mDistanciaEmpalme.setText(String.valueOf(holder.mItem.getDistancia_e())+" Km.");
        holder.mNumPoste.setText(holder.mItem.getNum_poste());
        holder.mCordenada.setText(holder.mItem.getCordenada());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mEmpalmeViewModel) {

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setNuevoEmpalme(List<Empalmes_fibraOptica> nuevoEmpalme) {
        this.mValues = nuevoEmpalme;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNombEmpalme;
        public final TextView mDistanciaEmpalme;
        public final TextView mNumPoste;
        public final TextView mCordenada;
        public Empalmes_fibraOptica mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNombEmpalme = view.findViewById(R.id.txtNombreEmpalme);
            mDistanciaEmpalme = view.findViewById(R.id.txtdistancia_empalme);
            mNumPoste = view.findViewById(R.id.txtNumeroPoste);
            mCordenada = view.findViewById(R.id.txtCordenadaEmpalme);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNombEmpalme.getText() + "'";
        }
    }
}
