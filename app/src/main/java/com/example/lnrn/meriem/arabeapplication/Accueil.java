package com.example.lnrn.meriem.arabeapplication;


import android.app.FragmentTransaction;
import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import static com.example.lnrn.meriem.arabeapplication.MainActivity.nom;


public class Accueil extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mactDrawer;
    private NavigationView navigationView;
    private TextView nomEtud;
    public static ProgressBar progbar;
    int bck=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        progbar= (ProgressBar) findViewById(R.id.progbar);
        replaceFragement(0);
        nomEtud=(TextView) findViewById(R.id.nomEtud);

     //remplacer le nom :

        if(nom==null){
            nomEtud.setText("");
        }
        else{
            nomEtud.setText(nom);
        }

     //menu creation

        mDrawer=(DrawerLayout)findViewById(R.id.menu_app);
        mactDrawer=new ActionBarDrawerToggle(this,mDrawer,R.string.open,R.string.close);

        mDrawer.addDrawerListener(mactDrawer);
        mactDrawer.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView = (NavigationView) findViewById(R.id.nav_layout);
        navigationView.setNavigationItemSelectedListener(this);

       }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mactDrawer.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //fragement set :

    public void replaceFragement(int i) {

        Fragment fg=null;
        switch (i){
            case 0:
                fg=new Firstchoices();
                break;
        }

        if(fg!=null){
            FragmentManager fm= getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.div, fg);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    //btn retour :

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu_app);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(bck==0){
                Toast.makeText(this,"إِضْغَطْ مَرَّةً أُخْرَى لِلْخُرُوجِ نِهَائِيّاً مِنَ التَّطْبِيقِ",Toast.LENGTH_SHORT).show();bck=bck+1;}
            else if(bck!=0){
                finish();
            }
            //super.onBackPressed();
        }
    }

    //menu suite :

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the home action
            replaceFragement(0);
        } else if (id == R.id.nav_info) {
            // Handle the info action
            AlertDialog.Builder mBuilder=new AlertDialog.Builder(this);
            View v=getLayoutInflater().inflate(R.layout.info_layout,null);
            mBuilder.setView(v);
            final AlertDialog a=mBuilder.create();
            a.show();

            Button bk=(Button)v.findViewById(R.id.bk);
            bk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a.hide();
                }
            });
        } else if (id == R.id.nav_help) {
            // Handle the help action
            AlertDialog.Builder mBuilder=new AlertDialog.Builder(this);
            View v=getLayoutInflater().inflate(R.layout.helplayout,null);

            final VideoView helpvd = (VideoView)v.findViewById(R.id.helpvd);
            MediaController mediaC = new MediaController(v.getContext());

            String videopath="android.resource://"+v.getContext().getPackageName()+"/"+R.raw.vdhelp;
            //Uri uri=Uri.parse(videopath);
            helpvd.setVideoURI(Uri.parse(videopath));
            helpvd.setMediaController(mediaC);
            mediaC.setAnchorView(helpvd);
            helpvd.start();

            mBuilder.setView(v);

            final AlertDialog a=mBuilder.create();

            a.show();

            Button bk2=(Button)v.findViewById(R.id.bk2);
            bk2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helpvd.stopPlayback();
                    a.hide();
                }
            });

        } else if (id == R.id.nav_exit) {
            // Handle the exit action
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu_app);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}