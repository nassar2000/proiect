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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import db.Database;

public class Consumati extends Fragment {

    RecyclerView recyclerView=null;
    RecyclerView.LayoutManager layoutManager=null;
    RecyclerView.Adapter adapter=null;
    List<Database> databases= null;
    private EditText etNrOberatia;
    private Button btDelete;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_consumati, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        databases = MainActivity.mydbApp.MyDao().getData();

        recyclerView = view.findViewById(R.id.recyclerView0);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterCard(databases);

        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        etNrOberatia = view.findViewById(R.id.edDelete);
        btDelete = view.findViewById(R.id.btDelete);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(etNrOberatia.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(),"Va rog sa completati numarul operatii",Toast.LENGTH_SHORT).show();
                    return;
                }



                int id = Integer.parseInt(etNrOberatia.getText().toString());
                Database database = new Database();
                database.setUid(id);

                databases = MainActivity.mydbApp.MyDao().getData();
                for(int i=0;i<databases.size();i++){
                    if(id == databases.get(i).getUid()){
                        MainActivity.mydbApp.MyDao().deleteInfo(database);
                        Toast.makeText(getActivity(),"Operatia o fost stearsa cu succes",Toast.LENGTH_SHORT).show();

                        return ;
                    }
                }
                Toast.makeText(getActivity(),"Adaugati va rog un alt nr de operatii",Toast.LENGTH_SHORT).show();

                etNrOberatia.setText("");

            }
        });

    }


}


