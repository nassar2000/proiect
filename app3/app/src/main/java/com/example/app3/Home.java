package com.example.app3;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Home extends Fragment implements View.OnClickListener {
    private Button add, viewdata;
    private AnimationDrawable animationDrawable;
    private ConstraintLayout constraintLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        constraintLayout = view.findViewById(R.id.llmain);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        add = view.findViewById(R.id.btadd);
        add.setOnClickListener(this);
        viewdata = view.findViewById(R.id.btview);
        viewdata.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btadd:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frameLayoutHome, new AdaugaInCos())
                        .addToBackStack(null).commit();

                break;

            case R.id.btview:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frameLayoutHome, new Consumati())
                        .addToBackStack(null).commit();

                break;
        }
    }
}
