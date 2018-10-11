package com.thaethinzarkhaingsoe.myngapaw.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.adapter.ConversationAdapter;
import com.thaethinzarkhaingsoe.myngapaw.adapter.GrammarRcAdapter;
import com.thaethinzarkhaingsoe.myngapaw.database.DbController;
import com.thaethinzarkhaingsoe.myngapaw.models.ConversationModel;
import com.thaethinzarkhaingsoe.myngapaw.mylibrary.TextViewPlus;

import java.util.ArrayList;

/**
 * Created by Khaing on 6/15/2018.
 */

public class ConversationViewActivity extends AppCompatActivity {

    TextViewPlus converTitle,converEng,converKorea,converMyan;
    ConversationModel converModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation_view);
        getSupportActionBar().setTitle("Conversation Page");

        converTitle= (TextViewPlus) findViewById(R.id.converTitle);
        converEng=(TextViewPlus)findViewById(R.id.converEng);
        converKorea=(TextViewPlus)findViewById(R.id.converKorea);
        converMyan=(TextViewPlus)findViewById(R.id.converMyan);
        if(getIntent().hasExtra("Convermodel")){
            converModel = getIntent().getParcelableExtra("Convermodel");
        }
//        converTitle.setText(converModel.getConverTitle());
//        converKorea.setText(converModel.getConverKorean());
//        converEng.setText(converModel.getConverEnglish());
//        converMyan.setText(converModel.getConverMyanmar());
//        Log.e("Myanmar", "onCreate: "+converModel.getConverKorean() );
        converTitle.setText("khaing");
        converEng.setText("english");

    }


}
