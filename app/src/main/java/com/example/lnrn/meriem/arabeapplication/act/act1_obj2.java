package com.example.lnrn.meriem.arabeapplication.act;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.DragEvent;
import android.view.View;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnrn.meriem.arabeapplication.R;
import com.example.lnrn.meriem.arabeapplication.Secondchoices;

import static com.example.lnrn.meriem.arabeapplication.Accueil.progbar;
import static com.example.lnrn.meriem.arabeapplication.act.act1.prg;

public class act1_obj2 extends Fragment {

    public act1_obj2() {
        // Required empty public constructor
    }
    AlertDialog a;
    TextView txt1,txt2,txt3,txtTarget,txtTarget2,txtTarget3,consigne;
    Button setfl,prev,next,menu;
    private FrameLayout fl,fl2,fl3;
    private MediaPlayer mp;
    private Integer essay=0;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootview=inflater.inflate(R.layout.fragment_act1_obj2, container, false);

        txt1=(TextView)rootview.findViewById(R.id.rim1);
        txt2=(TextView)rootview.findViewById(R.id.rim2);
        txt3=(TextView)rootview.findViewById(R.id.rim3);


        //sound consigne :
        consigne=(TextView) rootview.findViewById(R.id.textView3);
        consigne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(),R.raw.quest1_obj2);
                mp.start();
            }
        });

        txtTarget=(TextView)rootview.findViewById(R.id.mots1);
        txtTarget2=(TextView)rootview.findViewById(R.id.mots2);
        txtTarget3=(TextView)rootview.findViewById(R.id.mots3);

        setfl=(Button)rootview.findViewById(R.id.setfl);
        setfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((txtTarget.getText()=="أُصُـولٌ") && fl.isShown() ) {

                    fl2.setVisibility(View.VISIBLE);
                    fl.setVisibility(View.INVISIBLE);
                    checkanswer();

                }   else if ((txtTarget2.getText()=="فُضُـولٌ") && fl2.isShown()){
                    fl2.setVisibility(View.INVISIBLE);
                    fl3.setVisibility(View.VISIBLE);
                    checkanswer();

                }   else if ((txtTarget3.getText()=="قَبُـولٌ") && fl3.isShown()){
                    checkanswer();
                    Fragment fg = new act2_obj2();
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
                        essay=essay+1;
                    }
                    else{
                        if(fl.isShown() ) {
                            essay=0;
                            fl2.setVisibility(View.VISIBLE);
                            fl.setVisibility(View.INVISIBLE);

                        }   else if (fl2.isShown()){
                            essay=0;
                            fl2.setVisibility(View.INVISIBLE);
                            fl3.setVisibility(View.VISIBLE);

                        }   else if (fl3.isShown()){
                            essay=0;
                            Fragment fg = new act2_obj2();
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

        fl=(FrameLayout)rootview.findViewById(R.id.quest1);
        fl2=(FrameLayout)rootview.findViewById(R.id.quest2);
        fl3=(FrameLayout)rootview.findViewById(R.id.quest3);


        txt1.setOnLongClickListener(longclick);
        txt2.setOnLongClickListener(longclick);
        txt3.setOnLongClickListener(longclick);

        txtTarget.setOnDragListener(drag);
        txtTarget2.setOnDragListener(drag2);
        txtTarget3.setOnDragListener(drag3);

        prev=(Button) rootview.findViewById(R.id.prev);
        next=(Button) rootview.findViewById(R.id.next);
        menu=(Button) rootview.findViewById(R.id.menu);

//prev
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg=new act2();
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
                Fragment fg=new act2_obj2();
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


                    if(view.getId()== R.id.rim1){

                        txtTarget.setText("أَصْلٌ");

                    } else if(view.getId()== R.id.rim2){

                        txtTarget.setText("أَصِيحُ");

                    }else if(view.getId()== R.id.rim3){

                        txtTarget.setText("أُصُـولٌ");

                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    if(view.getId()== R.id.rim1){

                        txtTarget.setText("أُصُـ  _ _");

                    } else if(view.getId()== R.id.rim2){

                        txtTarget.setText("أُصُـ  _ _");

                    }else if(view.getId()== R.id.rim3){

                        txtTarget.setText("أُصُـ  _ _");

                    }
                    break;
                case DragEvent.ACTION_DROP:
                    if(view.getId()== R.id.rim1){

                        txtTarget.setText("أَصْلٌ");

                    } else if(view.getId()== R.id.rim2){

                        txtTarget.setText("أَصِيحُ");

                    }else if(view.getId()== R.id.rim3){

                        txtTarget.setText("أُصُـولٌ");

                    }
                    break;

            }

            return true;
        }
    };

    View.OnDragListener drag2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent =event.getAction();
            final View view=(View) event.getLocalState();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:


                    if(view.getId()== R.id.rim1){

                        txtTarget2.setText("فَضَّلَ");

                    } else if(view.getId()== R.id.rim2){

                        txtTarget2.setText("فَصِيحُ");

                    }else if(view.getId()== R.id.rim3){

                        txtTarget2.setText("فُضُـولٌ");

                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    if(view.getId()== R.id.rim1){

                        txtTarget2.setText("فُضُـ  _ _");

                    } else if(view.getId()== R.id.rim2){

                        txtTarget2.setText("فُضُـ  _ _");

                    }else if(view.getId()== R.id.rim3){

                        txtTarget2.setText("فُضُـ  _ _");

                    }
                    break;
                case DragEvent.ACTION_DROP:
                    if(view.getId()== R.id.rim1){

                        txtTarget2.setText("فَضَّلَ");

                    } else if(view.getId()== R.id.rim2){

                        txtTarget2.setText("فَصِيحُ");

                    }else if(view.getId()== R.id.rim3){

                        txtTarget2.setText("فُضُـولٌ");

                    }
                    break;

            }

            return true;
        }
    };

    View.OnDragListener drag3 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent =event.getAction();
            final View view=(View) event.getLocalState();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:


                    if(view.getId()== R.id.rim1){

                        txtTarget3.setText("قَبْلَ");

                    } else if(view.getId()== R.id.rim2){

                        txtTarget3.setText("قَبِيحُ");

                    }else if(view.getId()== R.id.rim3){

                        txtTarget3.setText("قَبُـولٌ");

                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    if(view.getId()== R.id.rim1){

                        txtTarget3.setText("قَبُـ  _ _");

                    } else if(view.getId()== R.id.rim2){

                        txtTarget3.setText("قَبُـ  _ _");

                    }else if(view.getId()== R.id.rim3){

                        txtTarget3.setText("قَبُـ  _ _");

                    }
                    break;
                case DragEvent.ACTION_DROP:
                    if(view.getId()== R.id.rim1){

                        txtTarget3.setText("قَبْلَ");

                    } else if(view.getId()== R.id.rim2){

                        txtTarget3.setText("قَبِيحُ");

                    }else if(view.getId()== R.id.rim3){

                        txtTarget3.setText("قَبُـولٌ");

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