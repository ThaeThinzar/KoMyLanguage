package com.thaethinzarkhaingsoe.myngapaw.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.adapter.ConversationAdapter;
import com.thaethinzarkhaingsoe.myngapaw.adapter.GrammarRcAdapter;
import com.thaethinzarkhaingsoe.myngapaw.database.DbController;
import com.thaethinzarkhaingsoe.myngapaw.models.ConversationModel;
import com.thaethinzarkhaingsoe.myngapaw.models.GrammarModel;

import java.util.ArrayList;

/**
 * Created by Dell on 12/27/2017.
 */

public class ConversationActivity extends AppCompatActivity {
    RecyclerView conversationRecycler;
    ConversationAdapter conversationRcAdapter;
    ArrayList<ConversationModel> conversationList= new ArrayList<>();
    DbController dbController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        getSupportActionBar().setTitle("Conversation");
        conversationRecycler=(RecyclerView)findViewById(R.id.converRcView);
        dbController = new DbController(ConversationActivity.this);
        dbController.openDb();
        conversationList= dbController.queryConverData();
        Log.e("grammarList", "onCreate: "+conversationList.size() );
        RecyclerView.LayoutManager manager=new LinearLayoutManager(ConversationActivity.this,LinearLayout.VERTICAL,false);
        conversationRecycler.setLayoutManager(manager);


        conversationRcAdapter = new ConversationAdapter(ConversationActivity.this,conversationList);
        conversationRecycler.setAdapter(conversationRcAdapter);
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
