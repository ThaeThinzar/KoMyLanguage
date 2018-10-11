package com.thaethinzarkhaingsoe.myngapaw.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.models.GrammarModel;
import com.thaethinzarkhaingsoe.myngapaw.mylibrary.TextViewPlus;

/**
 * Created by Dell on 1/25/2018.
 */

public class GrammarViewActivity extends AppCompatActivity {
    TextViewPlus tvPattern,tvMmMeaning,tvEngMeaning,tvForm1,tvForm2,tvForm3,tvForm4,tvMnEg,tvEngEg,tvKorEg;
    GrammarModel gModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grammar_view_two);
        getSupportActionBar().setTitle("Grammar Explanation");

        tvPattern = findViewById(R.id.tvPattern);
        tvMmMeaning = findViewById(R.id.tvMmMeaning);
        tvEngMeaning = findViewById(R.id.tvEngMeaning);
        tvForm1 = findViewById(R.id.tvForm1);
        tvForm2 = findViewById(R.id.tvForm2);
        tvForm3 = findViewById(R.id.tvForm3);
        tvForm4 = findViewById(R.id.tvForm4);
        tvMnEg = findViewById(R.id.tvMnEg);
        tvEngEg = findViewById(R.id.tvEngEg);
        tvKorEg = findViewById(R.id.tvKorEg);

        tvMmMeaning.setVisibility(View.GONE);
        tvMmMeaning.setVisibility(View.GONE);
        tvEngMeaning.setVisibility(View.GONE);
        tvForm1.setVisibility(View.GONE);
        tvForm2.setVisibility(View.GONE);
        tvForm3.setVisibility(View.GONE);
        tvForm4.setVisibility(View.GONE);
        tvMnEg.setVisibility(View.GONE);
        tvKorEg.setVisibility(View.GONE);
        tvEngEg.setVisibility(View.GONE);

        if(getIntent().hasExtra("GrammarModel")){
            gModel = getIntent().getParcelableExtra("GrammarModel");
        }
        tvPattern.setText(gModel.getPattern());
        if(!gModel.getMmMeaning().equals("")){
            tvMmMeaning.setVisibility(View.VISIBLE);
            tvMmMeaning.setText(gModel.getMmMeaning());
        }
        if(!gModel.getEngMeaning().equals("")){
            tvEngMeaning.setVisibility(View.VISIBLE);
            tvEngMeaning.setText(gModel.getEngMeaning());
        }
        if(!gModel.getMmMeaning().equals("")){
            tvMmMeaning.setVisibility(View.VISIBLE);
            tvMmMeaning.setText(gModel.getMmMeaning());
        }
        if(!gModel.getForm_1().equals("")){
            tvForm1.setVisibility(View.VISIBLE);
            tvForm1.setText(gModel.getForm_1());
        }
        if(!gModel.getForm_2().equals("")){
            tvForm2.setVisibility(View.VISIBLE);
            tvForm2.setText(gModel.getForm_2());
        }
        if(!gModel.getForm_3().equals("")){
            tvForm3.setVisibility(View.VISIBLE);
            tvForm3.setText(gModel.getForm_3());
        }
        if(!gModel.getForm_4().equals("")){
            tvForm4.setVisibility(View.VISIBLE);
            tvForm4.setText(gModel.getForm_4());
        }
        if(!gModel.getMmExample().equals("")){
            tvMnEg.setVisibility(View.VISIBLE);
            tvMnEg.setText(gModel.getMmExample());
        }
        if(!gModel.getEngExample().equals("")){
            tvEngEg.setVisibility(View.VISIBLE);
            tvEngEg.setText(gModel.getEngExample());
        }
        if(!gModel.getKoreaExample().equals("")){
            tvKorEg.setVisibility(View.VISIBLE);
            tvKorEg.setText(gModel.getKoreaExample());
        }




    }
}
