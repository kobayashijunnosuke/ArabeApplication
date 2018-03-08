package com.example.lnrn.meriem.arabeapplication.act;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnrn.meriem.arabeapplication.R;
import com.example.lnrn.meriem.arabeapplication.Secondchoices;

import static com.example.lnrn.meriem.arabeapplication.Accueil.progbar;
import static com.example.lnrn.meriem.arabeapplication.act.act1.prg;

public class act_obj6 extends Fragment {

    private static String i="0";
    private Button setfl,prev,next,menu;
    AlertDialog a;
    TextView consigne;
    private MediaPlayer mp;
    private FrameLayout fl,fl2,fl3,fl4;
    Spinner spinner;
    private Integer essay=0;

    public act_obj6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview= inflater.inflate(R.layout.fragment_act_obj6, container, false);
        //

        fl= (FrameLayout) rootview.findViewById(R.id.quest1);
        fl2 = (FrameLayout) rootview.findViewById(R.id.quest2);
        fl3=(FrameLayout) rootview.findViewById(R.id.quest3);
        fl4=(FrameLayout) rootview.findViewById(R.id.quest4);
        //

        setfl=(Button)rootview.findViewById(R.id.setfl);
        setfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i.equals("7") && fl.isShown() ) {

                    fl2.setVisibility(View.VISIBLE);
                    fl.setVisibility(View.INVISIBLE);
                    checkanswer();

                }   else if (i.equals("7") && fl2.isShown()){
                    fl2.setVisibility(View.INVISIBLE);
                    fl3.setVisibility(View.VISIBLE);
                    checkanswer();

                } else if (i.equals("8") && fl3.isShown()){
                    fl3.setVisibility(View.INVISIBLE);
                    fl4.setVisibility(View.VISIBLE);
                    checkanswer();
                } else if (i.equals("8") && fl4.isShown()){
                    checkanswer();
                    Fragment fg = new act_obj7();
                    FragmentManager fm= getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.accueil, fg);
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
                        i="0";
                        spinner.setSelection(0);
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

                        } else if (fl3.isShown()){
                            essay=0;
                            fl3.setVisibility(View.INVISIBLE);
                            fl4.setVisibility(View.VISIBLE);
                        } else if (fl4.isShown()){
                            essay=0;
                            Fragment fg = new act_obj7();
                            FragmentManager fm= getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.add(R.id.accueil, fg);
                            // ft.addToBackStack(null);
                            ft.commit();

                        }
                    }

                }
            }
        });



        spinner = (Spinner) rootview.findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootview.getContext(),
                R.array.nb, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(onItemSelectedListener1);

        //check();

        //sound consigne :
        consigne=(TextView) rootview.findViewById(R.id.textView3);
        consigne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(),R.raw.quest_obj6);
                mp.start();
            }
        });

        prev=(Button) rootview.findViewById(R.id.prev);
        next=(Button) rootview.findViewById(R.id.next);
        menu=(Button) rootview.findViewById(R.id.menu);

//prev
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg=new act2_obj5();
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
                Fragment fg=new act_obj7();
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


    AdapterView.OnItemSelectedListener onItemSelectedListener1 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    i=parent.getItemAtPosition(position).toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {}

            };


    private void check(){



    }

    public void checkanswer() {
        essay=0;
        spinner.setSelection(0);
        mp = MediaPlayer.create(getView().getContext(),R.raw.good);
        mp.start();
        prg=prg+4;
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

