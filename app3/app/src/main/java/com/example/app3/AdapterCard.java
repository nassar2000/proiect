package com.example.app3;


import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import db.Database;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ViewHolder> {

    private List<Database> databases;
    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


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
        viewHolder.textView.setText("Numarul operatii: " + databases.get(index).getUid() + " \n" +
                "Tipul: " + databases.get(index).getTipulConsumat() + "\n" +
                "Pretul: " + databases.get(index).getPretul());
    }

    @Override
    public int getItemCount() {
        return databases.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imgDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);
            imgDelete = itemView.findViewById(R.id.deleteicon);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onDeleteClick(position);
                        }
                    }
                }
            });
        }

    }
}