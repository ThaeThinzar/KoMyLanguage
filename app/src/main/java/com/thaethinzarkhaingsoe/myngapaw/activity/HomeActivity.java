package com.thaethinzarkhaingsoe.myngapaw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.thaethinzarkhaingsoe.myngapaw.Excel.Excel_Thread;
import com.thaethinzarkhaingsoe.myngapaw.R;

/**
 * Created by Dell on 12/27/2017.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout layoutVocal,layoutGrammar,layoutConver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        layoutVocal = findViewById(R.id.layoutVocal);
        layoutGrammar = findViewById(R.id.layoutGrammar);
        layoutConver = findViewById(R.id.layoutConver);

        layoutGrammar.setOnClickListener(this);
        layoutVocal.setOnClickListener(this);
        layoutConver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.layoutVocal:
                Intent intent=new Intent(HomeActivity.this,VolcabularyActivity.class);
                startActivity(intent);
                break;
            case R.id.layoutGrammar:
                Intent gram_intent=new Intent(HomeActivity.this,GrammarActivity.class);
                startActivity(gram_intent);
                break;
            case R.id.layoutConver:
                Intent conver_intent=new Intent(HomeActivity.this,ConversationActivity.class);
               startActivity(conver_intent);
                break;
        }
    }
}
