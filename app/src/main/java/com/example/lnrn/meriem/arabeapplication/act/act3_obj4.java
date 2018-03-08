package com.example.lnrn.meriem.arabeapplication.act;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnrn.meriem.arabeapplication.R;
import com.example.lnrn.meriem.arabeapplication.Secondchoices;

import static com.example.lnrn.meriem.arabeapplication.Accueil.progbar;
import static com.example.lnrn.meriem.arabeapplication.act.act1.prg;

public class act3_obj4 extends Fragment {
    TextView txt1,txt2,txt3,consigne;
    private MediaPlayer mp;
    ImageView target;
    private Button setfl,prev,next,menu;
    AlertDialog a;
    private Drawable new_image;
    private int i=0,essay=0;
    public act3_obj4() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootview = inflater.inflate(R.layout.fragment_act3_obj4, container, false);

        txt1=(TextView)rootview.findViewById(R.id.mots1);
        txt2=(TextView)rootview.findViewById(R.id.mots2);
        txt3=(TextView)rootview.findViewById(R.id.mots3);

        target=(ImageView)rootview.findViewById(R.id.bag);

        //sound consigne :
        consigne=(TextView) rootview.findViewById(R.id.textView3);
        consigne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(),R.raw.quest3_obj4);
                mp.start();
            }
        });

        setfl=(Button)rootview.findViewById(R.id.setfl);
        setfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i==1) {

                    checkanswer();
                    Fragment fg = new act1_obj5();
                    FragmentManager fm= getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.accueil, fg);
                    // ft.addToBackStack(null);
                    ft.commit();

                } else {
                    if(essay<3){
                        AlertDialog.Builder mBuilder=new AlertDialog.Builder(rootview.getContext());
                        v = inflater.inflate(R.layout.tryagain, null);
                        mBuilder.setView(v);
                        a=mBuilder.create();
                        mp = MediaPlayer.create(rootview.getContext(),R.raw.tryagain);
                        mp.start();
                        a.show();
                        new_image = getResources().getDrawable(R.drawable.bag);
                        target.setImageDrawable(new_image);
                        i=0;
                        essay=essay+1;
                    }else {
                        Fragment fg = new act1_obj5();
                        FragmentManager fm= getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.add(R.id.accueil, fg);
                        // ft.addToBackStack(null);
                        ft.commit();
                    }

                }
            }
        });
        //check();

        txt1.setOnLongClickListener(longclick);
        txt2.setOnLongClickListener(longclick);
        txt3.setOnLongClickListener(longclick);

        target.setOnDragListener(drag);


        prev=(Button) rootview.findViewById(R.id.prev);
        next=(Button) rootview.findViewById(R.id.next);
        menu=(Button) rootview.findViewById(R.id.menu);

//prev
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg=new act2_obj4();
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
                Fragment fg=new act1_obj5();
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

    View.OnLongClickListener longclick=new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData cd =ClipData.newPlainText("","");
            View.DragShadowBuilder shdow=new View.DragShadowBuilder(v);

            v.startDrag(cd, shdow,v,0);
            return true;

        }
    };

    View.OnDragListener drag = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent =event.getAction();
            final View view=(View) event.getLocalState();
            switch (dragEvent){

                case DragEvent.ACTION_DRAG_ENTERED:


                    if(view.getId()== R.id.mots1){
                        new_image = getResources().getDrawable(R.drawable.bag_open);
                        target.setImageDrawable(new_image);

                    } else if(view.getId()== R.id.mots2){

                        new_image = getResources().getDrawable(R.drawable.bag_open);
                        target.setImageDrawable(new_image);

                    }else if(view.getId()== R.id.mots3){

                        new_image = getResources().getDrawable(R.drawable.bag_open);
                        target.setImageDrawable(new_image);

                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    if(view.getId()== R.id.rim1){

                        new_image = getResources().getDrawable(R.drawable.bag);
                        target.setImageDrawable(new_image);

                    } else if(view.getId()== R.id.rim2){

                        new_image = getResources().getDrawable(R.drawable.bag);
                        target.setImageDrawable(new_image);


                    }else if(view.getId()== R.id.rim3){

                        new_image = getResources().getDrawable(R.drawable.bag);
                        target.setImageDrawable(new_image);


                    }
                    break;
                case DragEvent.ACTION_DROP:
                    if(view.getId()== R.id.mots1){
                        new_image = getResources().getDrawable(R.drawable.bag_full);
                        target.setImageDrawable(new_image);
                        i=0;

                    } else if(view.getId()== R.id.mots2){

                        new_image = getResources().getDrawable(R.drawable.bag_full);
                        target.setImageDrawable(new_image);
                        i=1;

                    }else if(view.getId()== R.id.mots3){

                        new_image = getResources().getDrawable(R.drawable.bag_full);
                        target.setImageDrawable(new_image);
                        i=0;
                    }
                    break;

            }

            return true;
        }
    };

    private void check(){

    }
    public void checkanswer() {
        essay=0;
        mp = MediaPlayer.create(getView().getContext(),R.raw.good);
        mp.start();
        prg=prg+3;
        progbar.setProgress(prg);
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

