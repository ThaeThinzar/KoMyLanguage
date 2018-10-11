package com.thaethinzarkhaingsoe.myngapaw.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.adapter.GrammarRcAdapter;
import com.thaethinzarkhaingsoe.myngapaw.database.DbController;
import com.thaethinzarkhaingsoe.myngapaw.models.GrammarModel;

import java.util.ArrayList;

/**
 * Created by Dell on 12/27/2017.
 */

public class GrammarActivity extends AppCompatActivity {

    RecyclerView grammarRcView;
    GrammarRcAdapter grammarRcAdapter;
    ArrayList<GrammarModel> grammarList= new ArrayList<>();
    DbController dbController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
        getSupportActionBar().setTitle("Grammar");
        grammarRcView = findViewById(R.id.grammarRcView);
        dbController = new DbController(GrammarActivity.this);
        dbController.openDb();
        grammarList = dbController.queryGramData();
        Log.e("grammarList", "onCreate: "+grammarList.size() );
        RecyclerView.LayoutManager manager = new LinearLayoutManager(GrammarActivity.this,LinearLayoutManager.VERTICAL,false);
        grammarRcView.setLayoutManager(manager);

        grammarRcAdapter = new GrammarRcAdapter(GrammarActivity.this,grammarList);
        grammarRcView.setAdapter(grammarRcAdapter);

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
