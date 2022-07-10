package com.example.izzycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @SuppressLint("SetTextI18n")
    public void Mundobtn(View view) {
        TextView layout = findViewById(R.id.layout1);
        layout.setText("Rojo");
    }

    @SuppressLint("SetTextI18n")
    public void Holabtn(View view) {
        TextView layout = findViewById(R.id.layout1);
        layout.setText("Azul");
    }
    @SuppressLint("SetTextI18n")
    public void teclaAC(View view){
        TextView layout = findViewById(R.id.layout1);
        layout.setText("0");
    }

}