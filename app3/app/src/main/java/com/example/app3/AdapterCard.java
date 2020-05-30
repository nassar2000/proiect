package com.example.app3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import db.Database;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ViewHolder> {

    private List<Database> databases;




    public AdapterCard(List<Database> databases) {
        this.databases = databases;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int index) {
        viewHolder.textView.setText("Numarul operatii: "+databases.get(index).getUid() + " \n" +
                "Tipul: "+databases.get(index).getTipulConsumat()+"\n"+
                "Pretul: "+databases.get(index).getPretul());
    }

    @Override
    public int getItemCount() {
        return databases.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);

        }
    }
}