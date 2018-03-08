package com.example.lnrn.meriem.arabeapplication;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Firstchoices extends Fragment {

    public Firstchoices() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview=inflater.inflate(R.layout.fragment_firstchoices, container, false);
        //passer au page suivante:
        ImageView img=(ImageView)rootview.findViewById(R.id.ecole);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fg=new Secondchoices();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.accueil, fg);
               // ft.addToBackStack(null);
                ft.commit();
            }
        });
        ImageView env=(ImageView) rootview.findViewById(R.id.environnement);
        env.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new Secondchoices();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.accueil,fragment);
                fragmentTransaction.commit();
            }
        });
        return rootview;


    }

}