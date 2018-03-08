package com.example.lnrn.meriem.arabeapplication.act;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnrn.meriem.arabeapplication.R;
import com.example.lnrn.meriem.arabeapplication.Secondchoices;

import static com.example.lnrn.meriem.arabeapplication.Accueil.progbar;
import static com.example.lnrn.meriem.arabeapplication.act.act1.prg;


public class act2 extends Fragment {

    public act2() {
        // Required empty public constructor
    }
    AlertDialog a;
    private MediaPlayer mp;
    private ImageView mains,mots1,mots2,mots3;
    private FrameLayout fl,fl2,fl3;
    private Button setflact2,prev,next,menu;
    private int i=1,essay=0;
    private TextView consigne;
    private Drawable new_image;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootview=inflater.inflate(R.layout.fragment_act2, container, false);
        //

        fl= (FrameLayout) rootview.findViewById(R.id.quest4);
        fl2 = (FrameLayout) rootview.findViewById(R.id.quest5);
        fl3=(FrameLayout) rootview.findViewById(R.id.quest6);


        //sound consigne :
        consigne=(TextView) rootview.findViewById(R.id.textView3);
        consigne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(),R.raw.quest2_obj1);
                mp.start();
            }
        });

        //sound mots:
        //1
        mots1=(ImageView) rootview.findViewById(R.id.mots4);
        mots1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(),R.raw.far);
                mp.start();
            }
        });

        //2
        mots2=(ImageView) rootview.findViewById(R.id.mots5);
        mots2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(),R.raw.libass);
                mp.start();
            }
        });

        //3
        mots3=(ImageView) rootview.findViewById(R.id.mots6);
        mots3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(),R.raw.falafil);
                mp.start();
            }
        });

        //

        mains=(ImageView) rootview.findViewById(R.id.mains);
        mains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i==1){
                    mp = MediaPlayer.create(rootview.getContext(),R.raw.one);
                    mp.start();
                    new_image = getResources().getDrawable(R.drawable.hand_1);
                    mains.setImageDrawable(new_image);
                    i=i+1;
                }else if(i==2) {
                    mp = MediaPlayer.create(rootview.getContext(),R.raw.two
                    );
                    mp.start();
                    new_image = getResources().getDrawable(R.drawable.hand_2);
                    mains.setImageDrawable(new_image);
                    i=i+1;
                }else if(i==3) {
                    mp = MediaPlayer.create(rootview.getContext(),R.raw.three);
                    mp.start();
                    new_image = getResources().getDrawable(R.drawable.hand_3);
                    mains.setImageDrawable(new_image);
                    i=i+1;
                }else if (i==4) {
                    mp = MediaPlayer.create(rootview.getContext(),R.raw.four);
                    mp.start();
                    new_image = getResources().getDrawable(R.drawable.hand_4);
                    mains.setImageDrawable(new_image);
                    i=i+1;
                }else if (i==5) {
                    mp = MediaPlayer.create(rootview.getContext(),R.raw.five);
                    mp.start();
                    new_image = getResources().getDrawable(R.drawable.hand_5);
                    mains.setImageDrawable(new_image);
                    i = 1;
                }
                }
        });


        //verification:

        setflact2=(Button) rootview.findViewById(R.id.setflact2);


        setflact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((i==5) && fl.isShown() ) {

                    fl2.setVisibility(View.VISIBLE);
                    fl.setVisibility(View.INVISIBLE);
                    checkanswer();


                }   else if ((i==5) && fl2.isShown()){
                    fl2.setVisibility(View.INVISIBLE);
                    fl3.setVisibility(View.VISIBLE);
                    checkanswer();

                }   else if ((i==1) && fl3.isShown()){
                    checkanswer();
                    Fragment fg = new act1_obj2();
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
                        new_image = getResources().getDrawable(R.drawable.hand_0);
                        mains.setImageDrawable(new_image);
                        i=1;
                        essay=essay+1;
                    }else {
                        if(fl.isShown() ) {
                            essay=0;
                            fl2.setVisibility(View.VISIBLE);
                            fl.setVisibility(View.INVISIBLE);


                        }   else if (fl2.isShown()){
                            essay=0;
                            fl2.setVisibility(View.INVISIBLE);
                            fl3.setVisibility(View.VISIBLE);

                        }   else if ( fl3.isShown()){
                            essay=0;
                            Fragment fg = new act1_obj2();
                            FragmentManager fm= getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.accueil, fg);
                            // ft.addToBackStack(null);
                            ft.commit();

                        }
                    }

                }
            }
        });


        prev=(Button) rootview.findViewById(R.id.prev);
        next=(Button) rootview.findViewById(R.id.next);
        menu=(Button) rootview.findViewById(R.id.menu);
//prev
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg=new act1();
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
                Fragment fg=new act1_obj2();
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

                checkclick(rtr, new Secondchoices());
                checkclick(obj1, new act1());
                checkclick(obj2, new act1_obj2());
                checkclick(obj3, new act1_obj3());
                checkclick(obj4, new act1_obj4());
                checkclick(obj5, new act1_obj5());
                checkclick(obj6, new act_obj6());
                checkclick(obj7, new act_obj7());
                checkclick(obj8, new act_obj8());
                checkclick(obj9, new act_obj9());
                checkclick(obj10, new act_obj10());

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
        new_image = getResources().getDrawable(R.drawable.hand_0);
        mains.setImageDrawable(new_image);
        i=1;
    }

    public void checkclick(Button b, final Fragment fragement){
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