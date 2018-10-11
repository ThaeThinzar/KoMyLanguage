package com.thaethinzarkhaingsoe.myngapaw.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.models.VocalModel;
import com.thaethinzarkhaingsoe.myngapaw.mylibrary.TextViewPlus;

/**
 * Created by Dell on 1/15/2018.
 */

public class VocabularyViewActivity extends AppCompatActivity {

    TextViewPlus tvKorea, tvMyanmar, tvEnglish , tvCategory;
    VocalModel model;
    Dialog myDialog;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocablulary_view);
        getSupportActionBar().setTitle("Vocabulary Explanation");
        tvKorea = findViewById(R.id.tvKorea);
        tvEnglish = findViewById(R.id.tvEnglish);
        tvMyanmar = findViewById(R.id.tvMyanmar);
        tvCategory = findViewById(R.id.tvCategory);


        if (getIntent().hasExtra("VocaModel")) {
            model = getIntent().getParcelableExtra("VocaModel");
        }
        tvKorea.setText(model.getKoera());
        tvEnglish.setText(model.getEnglish());
        tvMyanmar.setText(model.getMyanmar());
        tvCategory.setText(model.getCategory());
        Log.e("Myanmar", "onCreate: "+model.getMyanmar() );
    }

}
