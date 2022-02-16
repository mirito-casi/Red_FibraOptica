package com.example.red_fibraoptica.ui.empalmes;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.red_fibraoptica.R;
import com.example.red_fibraoptica.db.entidades.Empalmes_fibraOptica;

import java.util.ArrayList;
import java.util.List;


public class EmpalmesFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private List<Empalmes_fibraOptica> empalmesFibraOpticaList;
    private MyEmpalmesRecyclerViewAdapter adapterEmpalme;
    private NuevoEmpalmeViewModel mViewModel;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EmpalmesFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EmpalmesFragment newInstance(int columnCount) {
        EmpalmesFragment fragment = new EmpalmesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        //indicamos que el fragmento tiene su propio menu
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_empalmes_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            empalmesFibraOpticaList = new ArrayList<>();
            adapterEmpalme = new MyEmpalmesRecyclerViewAdapter(empalmesFibraOpticaList,getActivity());
            recyclerView.setAdapter(adapterEmpalme);
            lanzarViewModel();
        }
        return view;
    }

    private void lanzarViewModel() {
        mViewModel = ViewModelProviders.of(getActivity()).get(NuevoEmpalmeViewModel.class);
        mViewModel.getAllEmpalmes().observe(getActivity(), new Observer<List<Empalmes_fibraOptica>>() {
            @Override
            public void onChanged(List<Empalmes_fibraOptica> empalmes_fibraOpticas) {
                adapterEmpalme.setNuevoEmpalme(empalmes_fibraOpticas);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu_empalme_fragment,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_add_empalme){
            mostrarDialogoNuevoEmpalme();
        }
        return super.onOptionsItemSelected(item);
    }

    private void mostrarDialogoNuevoEmpalme() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        NuevoEmpalmeFragment nuevoEmpalmeFragment = new NuevoEmpalmeFragment();
        nuevoEmpalmeFragment.show(fm,"NuevoEmpalmeFragment");
    }
}
