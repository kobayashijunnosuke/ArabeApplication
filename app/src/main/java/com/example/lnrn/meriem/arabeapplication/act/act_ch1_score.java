package com.example.lnrn.meriem.arabeapplication.act;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lnrn.meriem.arabeapplication.R;
import com.example.lnrn.meriem.arabeapplication.Secondchoices;

import static com.example.lnrn.meriem.arabeapplication.Accueil.progbar;
import static com.example.lnrn.meriem.arabeapplication.MainActivity.nom;
import static com.example.lnrn.meriem.arabeapplication.act.act1.prg;

public class act_ch1_score extends Fragment {
private TextView txtnom,txtscore;
    private Button rtr;
    public act_ch1_score() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview=inflater.inflate(R.layout.fragment_act_ch1_score, container, false);

        txtnom=(TextView)rootview.findViewById(R.id.txtnum);
        txtscore=(TextView)rootview.findViewById(R.id.txtscore);

        txtnom.setText(nom+" "+txtnom.getText().toString());
        txtscore.setText((prg/10)+txtscore.getText().toString());

        rtr=(Button)rootview.findViewById(R.id.rtr);

       rtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prg=0;
                progbar.setProgress(prg);

                    Fragment fg = new Secondchoices();
                    FragmentManager fm= getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.accueil, fg);
                    //ft.addToBackStack(null);
                    ft.commit();

                     }
        });
                return rootview;
    }


}
