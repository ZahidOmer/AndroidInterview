package com.pakoz.androidinterview;


import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class FirstActivity extends ActionBarActivity implements View.OnClickListener{

    Button bsimple ,btough, bseeotherapps, brateapp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //code to add title of frontpage

        LinearLayout front = (LinearLayout)findViewById(R.id.front_page_title);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.frontpage_title_bar);


        Log.i("mzo", "main is create");

        bsimple = (Button)findViewById(R.id.bsq);
        btough = (Button)findViewById(R.id.btq);
        bseeotherapps = (Button)findViewById(R.id.bseeotherapp);
        brateapp = (Button)findViewById(R.id.brateapp);

        bsimple.setOnClickListener(this);
        btough.setOnClickListener(this);
        bseeotherapps.setOnClickListener(this);
        brateapp.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.bsq:

                Intent i = new Intent(FirstActivity.this, Simole_question.class);
                Log.i("mzo","new intent is create");
                startActivity(i);
                Log.i("mzo", "new intent is created");


                break;
            case R.id.btq:

                Intent j = new Intent(FirstActivity.this, Tough_question.class);
                startActivity(j);

                break;
            case R.id.bseeotherapp:
                Uri uri1 = Uri.parse("market://search?q=Sriyank");
                Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(goToMarket1);
                break;
            case R.id.brateapp:
                Uri uri2 = Uri.parse("market://details?com.pakoz.androidinterview");
                Intent goToMarket2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(goToMarket2);
                break;
        }

    }
}
