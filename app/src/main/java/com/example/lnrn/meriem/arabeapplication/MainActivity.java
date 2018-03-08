package com.example.lnrn.meriem.arabeapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Button startapp;
    private EditText nomtxt;
    public static String nom;
    public void init(){
        nomtxt=(EditText)findViewById(R.id.nom);
        startapp=(Button)findViewById(R.id.startapp);
        startapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Accueil.class);
                if(nomtxt==null){
                    nom=null;
                }else{
                    nom=nomtxt.getText().toString();
                }
                startActivity(intent);
                finish();
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
}
