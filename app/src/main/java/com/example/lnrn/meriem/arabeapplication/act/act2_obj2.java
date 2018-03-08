package com.example.lnrn.meriem.arabeapplication.act;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnrn.meriem.arabeapplication.R;
import com.example.lnrn.meriem.arabeapplication.Secondchoices;

import static com.example.lnrn.meriem.arabeapplication.Accueil.progbar;
import static com.example.lnrn.meriem.arabeapplication.act.act1.prg;

public class act2_obj2 extends Fragment {

    public act2_obj2() {
        // Required empty public constructor
    }
    CheckBox txt1,txt2,txt3,txt4;
    private Integer essay=0;
    Button setfl,prev,next,menu;
    private TextView consigne;
    MediaPlayer mp;
    AlertDialog a;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview=inflater.inflate(R.layout.fragment_act2_obj2, container, false);

        txt1=(CheckBox) rootview.findViewById(R.id.mots1);
        txt2=(CheckBox)rootview.findViewById(R.id.mots2);
        txt3=(CheckBox)rootview.findViewById(R.id.mots3);
        txt4=(CheckBox)rootview.findViewById(R.id.mots4);

        setfl=(Button)rootview.findViewById(R.id.setfl);
        setfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txt1.isChecked() && txt2.isChecked() && txt3.isChecked()){
                    checkanswer();
                    Fragment fg = new act3_obj2();
                    FragmentManager fm= getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.accueil, fg);
                    // ft.addToBackStack(null);
                    ft.commit();

                }

                else {
                    if(essay<3){
                        AlertDialog.Builder mBuilder=new AlertDialog.Builder(rootview.getContext());
                        v = inflater.inflate(R.layout.tryagain, null);
                        mBuilder.setView(v);
                        a=mBuilder.create();
                        mp = MediaPlayer.create(rootview.getContext(),R.raw.tryagain);
                        mp.start();
                        a.show();
                        txt1.setChecked(false);
                        txt2.setChecked(false);
                        txt3.setChecked(false);
                        txt4.setChecked(false);
                        essay=essay+1;
                    }else {
                        Fragment fg = new act3_obj2();
                        FragmentManager fm= getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.accueil, fg);
                        // ft.addToBackStack(null);
                        ft.commit();
                    }



                }
            }
        });


        //sound consigne :
        consigne=(TextView) rootview.findViewById(R.id.textView3);
        consigne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(),R.raw.quest2_obj2);
                mp.start();
            }
        });

        checkclick(txt1,rootview.getContext(),R.raw.yahrosso);
        checkclick(txt2,rootview.getContext(),R.raw.yaarifo);
        checkclick(txt3,rootview.getContext(),R.raw.yatassil);
        checkclick(txt4,rootview.getContext(),R.raw.yakbisso);

        //check();

        prev=(Button) rootview.findViewById(R.id.prev);
        next=(Button) rootview.findViewById(R.id.next);
        menu=(Button) rootview.findViewById(R.id.menu);

//prev
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg=new act1_obj2();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.accueil, fg);
                // ft.addToBackStack(null);
                ft.commit();
            }
        });

//next
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg=new act3_obj2();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.accueil, fg);
                // ft.addToBackStack(null);
                ft.commit();
            }
        });

        //menu
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(rootview.getContext());
                v=inflater.inflate(R.layout.fragment_all_act_ch1,null);
                Button obj1=(Button)v.findViewById(R.id.obj1);
                Button obj2=(Button)v.findViewById(R.id.obj2);
                Button obj3=(Button)v.findViewById(R.id.obj3);
                Button obj4=(Button)v.findViewById(R.id.obj4);
                Button obj5=(Button)v.findViewById(R.id.obj5);
                Button obj6=(Button)v.findViewById(R.id.obj6);
                Button obj7=(Button)v.findViewById(R.id.obj7);
                Button obj8=(Button)v.findViewById(R.id.obj8);
                Button obj9=(Button)v.findViewById(R.id.obj9);
                Button obj10=(Button)v.findViewById(R.id.obj10);
                Button rtr=(Button)v.findViewById(R.id.rtr);

                checkclick2(rtr, new Secondchoices());
                checkclick2(obj1, new act1());
                checkclick2(obj2, new act1_obj2());
                checkclick2(obj3, new act1_obj3());
                checkclick2(obj4, new act1_obj4());
                checkclick2(obj5, new act1_obj5());
                checkclick2(obj6, new act_obj6());
                checkclick2(obj7, new act_obj7());
                checkclick2(obj8, new act_obj8());
                checkclick2(obj9, new act_obj9());
                checkclick2(obj10, new act_obj10());

                mBuilder.setView(v);
                a=mBuilder.create();
                a.show();
            }
        });

        return rootview;
    }


    public void checkanswer() {
        essay=0;
        mp = MediaPlayer.create(getView().getContext(),R.raw.good);
        mp.start();
        prg=prg+3;
        progbar.setProgress(prg);
    }

    public void checkclick(CheckBox a, final Context sound, final int src){
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(sound,src);
                mp.start();
            }
        });
    }

    public void checkclick2(Button b, final Fragment fragement){
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg;
                fg = fragement;
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.accueil, fg);
                a.hide();
                // ft.addToBackStack(null);
                ft.commit();
            }
        });
    }
}