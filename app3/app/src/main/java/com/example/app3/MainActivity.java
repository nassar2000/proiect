package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

import db.MydbApp;


public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static MydbApp mydbApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        mydbApp = Room.databaseBuilder(getApplicationContext(), MydbApp.class, "consumati").allowMainThreadQueries().build();
        if (findViewById(R.id.frameLayoutHome) != null) {
            if (savedInstanceState != null) {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.frameLayoutHome, new Home()).commit();

        }

    }
}

