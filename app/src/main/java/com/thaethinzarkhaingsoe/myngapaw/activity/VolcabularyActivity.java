package com.thaethinzarkhaingsoe.myngapaw.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.adapter.VolRcAdapter;
import com.thaethinzarkhaingsoe.myngapaw.database.DbController;
import com.thaethinzarkhaingsoe.myngapaw.models.VocalModel;
import com.thaethinzarkhaingsoe.myngapaw.mylibrary.TextViewPlus;

import java.util.ArrayList;

/**
 * Created by Dell on 12/27/2017.
 */

public class VolcabularyActivity extends AppCompatActivity {
    RecyclerView volcaRcView;
    VolRcAdapter volAdapter;
    ArrayList<VocalModel> volList = new ArrayList<>();
    DbController dbController;
    TextViewPlus tvKorea, tvMyanmar, tvEnglish , tvCategory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volcabulary);
        getSupportActionBar().setTitle("Vocabulary");
        volcaRcView=findViewById(R.id.volcaRcView);
        dbController = new DbController(VolcabularyActivity.this);
        dbController.openDb();
        volList = dbController.queryVolData();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(VolcabularyActivity.this,LinearLayoutManager.VERTICAL,false);
        volcaRcView.setLayoutManager(manager);

        volAdapter = new VolRcAdapter(VolcabularyActivity.this,volList);
        volcaRcView.setAdapter(volAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dbController!=null){
            dbController.closeDb();
            dbController=null;
        }
    }
}
