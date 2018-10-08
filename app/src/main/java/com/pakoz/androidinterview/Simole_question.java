package com.pakoz.androidinterview;


import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Zahid on 12/6/2015.
 */
public class Simole_question extends AppCompatActivity implements View.OnClickListener {

    TextView tvquestion, tvanswer, tvtotallenght_yy, tvpresentindex_xx;
    Button bleft, bshow, bright;
    ScrollView scrollView;


    String[] simple_question, simple_answers;

    int index;

    //variable & object of TTS
    TextToSpeech ttsobject;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Log.i("mzo", "jumping to simple questions");

        setContentView(R.layout.questions);

        Log.i("mzo", "jumped to simple questions");

        //code to add title of question

        LinearLayout question = (LinearLayout)findViewById(R.id.question_page_title);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.questions_title_bar);

        TextView tv = (TextView)findViewById(R.id.tvquestionpage_titlebar);
        tv.setText("Simple Question");


     // Initialization of TextView

        tvquestion = (TextView)findViewById(R.id.tvquestion);
        tvanswer = (TextView)findViewById(R.id.tvanswer);
        tvtotallenght_yy = (TextView)findViewById(R.id.tvyy);
        tvpresentindex_xx = (TextView)findViewById(R.id.tvxx);

        // Initialization of Buttons

        bleft = (Button)findViewById(R.id.bleft);
        bright = (Button)findViewById(R.id.bright);
        bshow= (Button)findViewById(R.id.bshowanswer);

        //Importing  the string array from values folder


        simple_question = getResources().getStringArray(R.array.simple_ques);
        simple_answers = getResources().getStringArray(R.array.simple_ans);

        bleft.setOnClickListener(this);
        bshow.setOnClickListener(this);
        bright.setOnClickListener(this);
       tvanswer.setOnClickListener(this);

        Log .i("mzo", "yess");


        //TTS object & Listener Initialization
        ttsobject = new TextToSpeech(Simole_question.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS){

                    result = ttsobject.setLanguage(Locale.US);

                } else  {
                    Toast.makeText(getApplicationContext(),"Not suppored in your Mobile",Toast.LENGTH_LONG).show();
                }

            }
        });

        //setting values to our variable and 4 textviews

        index = 0;

        tvquestion.setText(simple_question[index]);
        tvanswer.setText("Press \"A\" Button for Answer");
        tvpresentindex_xx.setText(String.valueOf(index + 1));
        tvtotallenght_yy.setText("/"+String.valueOf(simple_question.length));
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.bleft:
                tvanswer.setText("Press \"A\" Button for Answer");
                index--;

                if (index==-1)
                {
                    index = simple_question.length - 1 ;

                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));

                }

                else
                {
                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));
                }

                if (ttsobject !=null){
                    ttsobject.stop();

                }

                break;

            case R.id.bright:
                tvanswer.setText("Press \"A\" Button for Answer");
                index++;

                if (index== simple_question.length)
                {
                    index = 0;

                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));

                }

                else
                {
                    tvquestion.setText(simple_question[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));

                }

                if (ttsobject !=null){
                    ttsobject.stop();

                }
                    break;


            case  R.id.bshowanswer:
                tvanswer.setText(simple_answers[index]);

                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result ==TextToSpeech.LANG_MISSING_DATA){

                    Toast.makeText(getApplicationContext(),"Not suppored in your Mobile",Toast.LENGTH_LONG).show();
                } else {
                    ttsobject.speak(simple_answers[index] , TextToSpeech.QUEUE_FLUSH, null);
                }
                break;

                 case  R.id. tvanswer:
                tvanswer.setText(simple_answers[index]);
                break;

        }

    }

}
