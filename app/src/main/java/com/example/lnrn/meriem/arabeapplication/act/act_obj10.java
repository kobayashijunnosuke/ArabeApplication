package com.example.lnrn.meriem.arabeapplication.act;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnrn.meriem.arabeapplication.R;
import com.example.lnrn.meriem.arabeapplication.Secondchoices;

import static com.example.lnrn.meriem.arabeapplication.Accueil.progbar;
import static com.example.lnrn.meriem.arabeapplication.act.act1.prg;

public class act_obj10 extends Fragment {
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txtTarget1,txtTarget2,txtTarget3,txtTarget4,consigne;
    private Button setfl,prev,menu;
    private MediaPlayer mp;
    AlertDialog a;
    private FrameLayout fl,fl2,fl3,fl4;
    private Integer essay=0;

    public act_obj10() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootview=inflater.inflate(R.layout.fragment_act_obj10, container, false);

        //sound consigne :
        consigne=(TextView) rootview.findViewById(R.id.textView3);
        consigne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(),R.raw.quest_obj10);
                mp.start();
            }
        });

        txt1=(TextView)rootview.findViewById(R.id.rim1);
        txt2=(TextView)rootview.findViewById(R.id.rim2);
        txt3=(TextView)rootview.findViewById(R.id.rim3);
        txt4=(TextView)rootview.findViewById(R.id.rim4);
        txt5=(TextView)rootview.findViewById(R.id.rim5);
        txt6=(TextView)rootview.findViewById(R.id.rim6);
        txt7=(TextView)rootview.findViewById(R.id.rim7);
        txt8=(TextView)rootview.findViewById(R.id.rim8);
        txt9=(TextView)rootview.findViewById(R.id.rim9);
        txt10=(TextView)rootview.findViewById(R.id.rim10);
        txt11=(TextView)rootview.findViewById(R.id.rim11);
        txt12=(TextView)rootview.findViewById(R.id.rim12);
        txt13=(TextView)rootview.findViewById(R.id.rim13);

        txtTarget1=(TextView)rootview.findViewById(R.id.target1);
        txtTarget2=(TextView)rootview.findViewById(R.id.target2);
        txtTarget3=(TextView)rootview.findViewById(R.id.target3);
        txtTarget4=(TextView)rootview.findViewById(R.id.target4);

        setfl=(Button)rootview.findViewById(R.id.setfl);
        setfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((txtTarget1.getText().equals(txt1.getText().toString()+txt7.getText().toString()+txt4.getText().toString()+txt12.getText().toString())) && fl.isShown() ) {

                    fl2.setVisibility(View.VISIBLE);
                    fl.setVisibility(View.INVISIBLE);
                    checkanswer();

                }   else if ((txtTarget2.getText().equals(txt6.getText().toString()+txt9.getText().toString()+txt13.getText().toString())) && fl2.isShown()){
                    fl2.setVisibility(View.INVISIBLE);
                    fl3.setVisibility(View.VISIBLE);
                    checkanswer();

                }   else if ((txtTarget3.getText().equals(txt2.getText().toString()+txt8.getText().toString()+txt11.getText().toString())) && fl3.isShown()){
                    fl3.setVisibility(View.INVISIBLE);
                    fl4.setVisibility(View.VISIBLE);
                    checkanswer();

                } else if ((txtTarget4.getText().equals(txt10.getText().toString()+txt5.getText().toString()+txt3.getText().toString())) && fl4.isShown()){
                    checkanswer();
                    Fragment fg = new act_ch1_score();
                    FragmentManager fm= getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.accueil, fg);
                    //ft.addToBackStack(null);
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
                        txtTarget1.setText("");
                        txtTarget2.setText("");
                        txtTarget3.setText("");
                        txtTarget4.setText("");
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

                        }   else if (fl3.isShown()){
                            essay=0;
                            fl3.setVisibility(View.INVISIBLE);
                            fl4.setVisibility(View.VISIBLE);

                        } else if (fl4.isShown()){
                            essay=0;
                            Fragment fg = new act_ch1_score();
                            FragmentManager fm= getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.add(R.id.accueil, fg);
                            //ft.addToBackStack(null);
                            ft.commit();

                        }
                    }


                }
            }
        });
        //check();

        fl=(FrameLayout)rootview.findViewById(R.id.quest1);
        fl2=(FrameLayout)rootview.findViewById(R.id.quest2);
        fl3=(FrameLayout)rootview.findViewById(R.id.quest3);
        fl4=(FrameLayout)rootview.findViewById(R.id.quest4);


        txt1.setOnLongClickListener(longclick);
        txt2.setOnLongClickListener(longclick);
        txt3.setOnLongClickListener(longclick);
        txt4.setOnLongClickListener(longclick);
        txt5.setOnLongClickListener(longclick);
        txt6.setOnLongClickListener(longclick);
        txt7.setOnLongClickListener(longclick);
        txt8.setOnLongClickListener(longclick);
        txt9.setOnLongClickListener(longclick);
        txt10.setOnLongClickListener(longclick);
        txt11.setOnLongClickListener(longclick);
        txt12.setOnLongClickListener(longclick);
        txt13.setOnLongClickListener(longclick);

        drag(txtTarget1);
        drag(txtTarget2);
        drag(txtTarget3);
        drag(txtTarget4);

        prev=(Button) rootview.findViewById(R.id.prev);
        menu=(Button) rootview.findViewById(R.id.menu);

//prev
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg=new act_obj9();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.accueil, fg);
                // ft.addToBackStack(null);
                ft.commit();
            }
        });

//next
       ////////////////////////

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

    private void drag(final TextView target) {

        View.OnDragListener drag1 = new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int dragEvent = event.getAction();
                final View view = (View) event.getLocalState();
                switch (dragEvent) {

                    case DragEvent.ACTION_DROP:
                        if (view.getId() == R.id.rim1) {

                            target.setText(target.getText().toString()+txt1.getText().toString());

                        } else if (view.getId() == R.id.rim2) {

                            target.setText(target.getText().toString()+txt2.getText().toString());

                        } else if (view.getId() == R.id.rim3) {

                            target.setText(target.getText().toString()+txt3.getText().toString());

                        }else if (view.getId() == R.id.rim4) {

                            target.setText(target.getText().toString()+txt4.getText().toString());

                        }else if (view.getId() == R.id.rim5) {

                            target.setText(target.getText().toString()+txt5.getText().toString());

                        }else if (view.getId() == R.id.rim6) {

                            target.setText(target.getText().toString()+txt6.getText().toString());

                        }else if (view.getId() == R.id.rim7) {

                            target.setText(target.getText().toString()+txt7.getText().toString());

                        }else if (view.getId() == R.id.rim8) {

                            target.setText(target.getText().toString()+txt8.getText().toString());

                        }else if (view.getId() == R.id.rim9) {

                            target.setText(target.getText().toString()+txt9.getText().toString());

                        }else if (view.getId() == R.id.rim10) {

                            target.setText(target.getText().toString()+txt10.getText().toString());

                        }else if (view.getId() == R.id.rim11) {

                            target.setText(target.getText().toString()+txt11.getText().toString());

                        }else if (view.getId() == R.id.rim12) {

                            target.setText(target.getText().toString()+txt12.getText().toString());

                        }else if (view.getId() == R.id.rim13) {

                            target.setText(target.getText().toString()+txt13.getText().toString());

                        }
                        break;

                }

                return true;
            }
        };
        target.setOnDragListener(drag1);
    }


    private void check(){

    }

    public void checkanswer() {
        essay=0;
        txtTarget1.setText("");
        txtTarget2.setText("");
        txtTarget3.setText("");
        txtTarget4.setText("");
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
