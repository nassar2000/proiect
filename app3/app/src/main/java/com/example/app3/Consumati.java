package com.example.app3;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;


import db.Database;

public class Consumati extends Fragment {

    RecyclerView recyclerView = null;
    RecyclerView.LayoutManager layoutManager = null;
    AdapterCard adapter = null;
    List<Database> databases = null;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_consumati, container, false);

    }

    public void removeItem(int position) {
        MainActivity.mydbApp.MyDao().deleteInfo(databases.get(position));
        databases.remove(position);
        Toast.makeText(getActivity(), "Operatia o fost stearsa cu succes", Toast.LENGTH_SHORT).show();
        adapter.notifyItemRemoved(position);
    }

    public void changeItem(int position) {
        databases.get(position);
        adapter.notifyItemChanged(position);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databases = MainActivity.mydbApp.MyDao().getData();
        recyclerView = view.findViewById(R.id.recyclerView0);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterCard(databases);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new AdapterCard.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position);

            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });


    }


}


