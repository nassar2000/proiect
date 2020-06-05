package com.example.app3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import db.Database;


public class AdaugaInCos extends Fragment {

    private EditText editNrObreatia, editTipul, editPretul;
    List<Database> databases = null;
    Button btSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_adauga_in_cos, container, false);

        editNrObreatia = view.findViewById(R.id.editNrObreatia);
        editTipul = view.findViewById(R.id.editTipul);
        editPretul = view.findViewById(R.id.editPretul);
        btSave = view.findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editNrObreatia.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Va rog sa completati numarul de obreatia", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editTipul.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Va rog sa completati tipul", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editPretul.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Va rog sa completati pretul", Toast.LENGTH_SHORT).show();
                    return;
                }

                int uid = Integer.parseInt(editNrObreatia.getText().toString());
                String tipulConsumat = editTipul.getText().toString();
                String pretul = editPretul.getText().toString();
                Database database = new Database();

                database.setUid(uid);
                database.setTipulConsumat(tipulConsumat);
                database.setPretul(pretul);

                databases = MainActivity.mydbApp.MyDao().getData();

                for (int i = 0; i < databases.size(); i++) {
                    if (uid == databases.get(i).getUid()) {

                        Toast.makeText(getActivity(), "Adaugati va rog un alt nr de operatii", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }


                MainActivity.mydbApp.MyDao().addInfo(database);
                Toast.makeText(getActivity(), "Consumatile o fost adaugate", Toast.LENGTH_SHORT).show();

                editNrObreatia.setText("");
                editTipul.setText("");
                editPretul.setText("");


            }
        });
        return view;
    }


}
