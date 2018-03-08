package com.example.lnrn.meriem.arabeapplication;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lnrn.meriem.arabeapplication.CH2.histo;
import com.example.lnrn.meriem.arabeapplication.act.act1;

public class Secondchoices extends Fragment {

    public Secondchoices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview=inflater.inflate(R.layout.fragment_secondchoices, container, false);
        //passer au page suivante:
        ImageView img=(ImageView)rootview.findViewById(R.id.ch1);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fg=new act1();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.choix, fg);
                // ft.addToBackStack(null);
                ft.commit();
            }
        });
        ImageView img2=(ImageView)rootview.findViewById(R.id.ch2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fg=new histo();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.choix, fg);
                // ft.addToBackStack(null);
                ft.commit();
            }
        });

        return rootview;

    }
}

