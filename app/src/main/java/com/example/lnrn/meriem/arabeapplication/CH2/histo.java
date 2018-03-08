package com.example.lnrn.meriem.arabeapplication.CH2;


import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.lnrn.meriem.arabeapplication.R;
import com.example.lnrn.meriem.arabeapplication.Secondchoices;
import com.example.lnrn.meriem.arabeapplication.act.act2;
import com.example.lnrn.meriem.arabeapplication.act.act_ch1_score;

import java.io.File;
import java.io.IOException;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static com.example.lnrn.meriem.arabeapplication.Accueil.progbar;
import static com.example.lnrn.meriem.arabeapplication.act.act1.prg;

public class histo extends Fragment {

    private ImageView histo,exo,rec,son_coq;
    private MediaPlayer mp;
    private FrameLayout fl,fl2,fl3,fl21,fl22,fl23,fl24;
    private Button rtr,startrec,listenrec,dog1,coq1,mouse1,yes,no,cat1,coq2,mouse2,dog2,cat2,coq3,fullSc;
    private File file,file1;
    private MediaRecorder mediarecorder;
    private Integer i=0;
    private Drawable new_image;
    VideoView vd;
    MediaController mediaC;

    public histo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootview=inflater.inflate(R.layout.fragment_histo, container, false);

        /////////////video

        vd = (VideoView)rootview.findViewById(R.id.video_histo);
        mediaC = new MediaController(rootview.getContext());

        String videopath="android.resource://"+rootview.getContext().getPackageName()+"/"+R.raw.histo;
        //Uri uri=Uri.parse(videopath);
        vd.setVideoURI(Uri.parse(videopath));
        vd.setMediaController(mediaC);
        mediaC.setAnchorView(vd);
        vd.start();

        //play with non stop
        vd.setOnPreparedListener (new MediaPlayer.OnPreparedListener(){
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });



        /////////////

        rtr=(Button)rootview.findViewById(R.id.rtr);

        rtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prg=0;
                progbar.setProgress(prg);
                vd.pause();
                Fragment fg = new Secondchoices();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.accueil, fg);
                //ft.addToBackStack(null);
                ft.commit();

            }
        });

        histo=(ImageView)rootview.findViewById(R.id.histo);
        exo=(ImageView)rootview.findViewById(R.id.exo);
        rec=(ImageView)rootview.findViewById(R.id.rec);

        fl=(FrameLayout) rootview.findViewById(R.id.histoire);
        fl2=(FrameLayout) rootview.findViewById(R.id.histo_exo);
        fl3=(FrameLayout) rootview.findViewById(R.id.histo_rec);


        //sous frame

        fl21=(FrameLayout) rootview.findViewById(R.id.exo1);
        fl22=(FrameLayout) rootview.findViewById(R.id.exo2);
        fl23=(FrameLayout) rootview.findViewById(R.id.exo3);
        fl24=(FrameLayout) rootview.findViewById(R.id.exo4);

        son_coq=(ImageView) rootview.findViewById(R.id.son);
        son_coq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(getView().getContext(),R.raw.djaja);
                mp.start();
            }
        });

        dog1=(Button)rootview.findViewById(R.id.dog1);
        coq1=(Button)rootview.findViewById(R.id.coq1);
        mouse1=(Button)rootview.findViewById(R.id.mouse1);

        yes=(Button)rootview.findViewById(R.id.yes);
        no=(Button)rootview.findViewById(R.id.no);

        cat1=(Button)rootview.findViewById(R.id.cat1);
        coq2=(Button)rootview.findViewById(R.id.coq2);
        mouse2=(Button)rootview.findViewById(R.id.mouse2);

        dog2=(Button)rootview.findViewById(R.id.dog2);
        cat2=(Button)rootview.findViewById(R.id.cat2);
        coq3=(Button)rootview.findViewById(R.id.coq3);

       //good answer:
        coq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl22.setVisibility(View.VISIBLE);
                fl21.setVisibility(View.INVISIBLE);
                checkanswer();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl23.setVisibility(View.VISIBLE);
                fl22.setVisibility(View.INVISIBLE);
                checkanswer();
            }
        });

        coq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl24.setVisibility(View.VISIBLE);
                fl23.setVisibility(View.INVISIBLE);
                checkanswer();
            }
        });

        dog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanswer();
                Fragment fg = new act_ch1_score();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.accueil, fg);
                //ft.addToBackStack(null);
                ft.commit();
            }
        });

        //bad answer

        dog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl22.setVisibility(View.VISIBLE);
                fl21.setVisibility(View.INVISIBLE);
            }
        });

        mouse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl22.setVisibility(View.VISIBLE);
                fl21.setVisibility(View.INVISIBLE);
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl23.setVisibility(View.VISIBLE);
                fl22.setVisibility(View.INVISIBLE);
            }
        });

        cat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl24.setVisibility(View.VISIBLE);
                fl23.setVisibility(View.INVISIBLE);
            }
        });

        mouse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl24.setVisibility(View.VISIBLE);
                fl23.setVisibility(View.INVISIBLE);
            }
        });

        coq3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg = new act_ch1_score();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.accueil, fg);
                //ft.addToBackStack(null);
                ft.commit();
            }
        });

        cat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg = new act_ch1_score();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.accueil, fg);
                //ft.addToBackStack(null);
                ft.commit();
            }
        });



////////////////////////////////////////////
        histo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fl2.isShown()){
                    replaceFragement(2);

                }else if (fl3.isShown()){
                    replaceFragement(4);
                }
            }
        });

        exo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fl.isShown()){
                    replaceFragement(0);

                }else if (fl3.isShown()){
                    replaceFragement(5);
                }
            }
        });

        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fl2.isShown()){
                    replaceFragement(3);

                }else if (fl.isShown()){
                    replaceFragement(1);
                }
            }
        });


        startrec=(Button)rootview.findViewById(R.id.startrec);
       // stoprec=(Button)rootview.findViewById(R.id.stoprec);
        listenrec=(Button)rootview.findViewById(R.id.listenrec);
        listenrec.setAlpha(0);


        listenrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(rootview.getContext(), Uri.fromFile(file1));
                mp.start();
            }
        });
        /*stoprec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediarecorder.stop();
            }
        });*/

        startrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0) {

                    listenrec.setAlpha(0);
                    new_image = getResources().getDrawable(R.drawable.rec_stp_btn);
                    startrec.setBackgroundDrawable(new_image);
                    i = i + 1;

                    file = Environment.getExternalStorageDirectory().getAbsoluteFile();
                    try {
                        file1 = File.createTempFile("audiofile", ".mp3", file);
                        mediarecorder = new MediaRecorder();
                        mediarecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        mediarecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                        mediarecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                        mediarecorder.setOutputFile(file1.getAbsolutePath());
                        mediarecorder.prepare();
                        mediarecorder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if(i==1){

                    mediarecorder.stop();
                    listenrec.setAlpha(1);
                    new_image = getResources().getDrawable(R.drawable.rec_btn);
                    startrec.setBackgroundDrawable(new_image);
                    i = 0;

                }


            }
        });

        return rootview;
    }



    /*public void videoplay (View v){

        String videopath="android.ressources:/z/com.example.lnrn.meriem.arabeapplication"+R.raw.another;
        Uri uri=Uri.parse(videopath);
        vd.setVideoURI(uri);
        vd.setMediaController(mediaC);
        mediaC.setAnchorView(vd);
        vd.start();

    }*/


    public void replaceFragement(int i) {

        switch (i) {
            case 0:
                fl2.setVisibility(View.VISIBLE);
                fl.setVisibility(View.INVISIBLE);
                vd.pause();
                break;
            case 1:
                fl3.setVisibility(View.VISIBLE);
                fl.setVisibility(View.INVISIBLE);
                vd.pause();
                break;

            case 2:
                fl.setVisibility(View.VISIBLE);
                fl2.setVisibility(View.INVISIBLE);
                vd.pause();
                break;
            case 3:
                fl3.setVisibility(View.VISIBLE);
                fl2.setVisibility(View.INVISIBLE);
                vd.pause();
                break;
            case 4:
                fl.setVisibility(View.VISIBLE);
                fl3.setVisibility(View.INVISIBLE);
                vd.pause();
                break;
            case 5:
                fl2.setVisibility(View.VISIBLE);
                fl3.setVisibility(View.INVISIBLE);
                vd.pause();
                break;
        }

    }

    public void checkanswer() {
        mp = MediaPlayer.create(getView().getContext(),R.raw.good);
        mp.start();
        prg=prg+25;
        progbar.setProgress(prg);
    }

}
