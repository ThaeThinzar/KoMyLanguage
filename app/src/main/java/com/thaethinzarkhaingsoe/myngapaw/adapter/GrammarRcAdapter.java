package com.thaethinzarkhaingsoe.myngapaw.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.activity.GrammarActivity;
import com.thaethinzarkhaingsoe.myngapaw.activity.GrammarViewActivity;
import com.thaethinzarkhaingsoe.myngapaw.activity.VocabularyViewActivity;
import com.thaethinzarkhaingsoe.myngapaw.models.GrammarModel;
import com.thaethinzarkhaingsoe.myngapaw.models.VocalModel;

import java.util.ArrayList;

/**
 * Created by Dell on 1/14/2018.
 */

public class GrammarRcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<GrammarModel> grammarModel = new ArrayList<>();
    Context context;

    public GrammarRcAdapter(Context context, ArrayList<GrammarModel> grammarModel) {
        this.context = context;
        this.grammarModel = grammarModel;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_grammar, null ,false );
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new MyHolderItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((MyHolderItem)holder).tvPattern.setText(grammarModel.get(position).getPattern());

        ((MyHolderItem) holder).tvPattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(context, GrammarViewActivity.class);
                i.putExtra("GrammarModel" , grammarModel.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return grammarModel.size();
    }

    static class MyHolderItem extends RecyclerView.ViewHolder {
        TextView tvPattern;

        public MyHolderItem(View itemView) {
            super(itemView);
            tvPattern = (TextView) itemView.findViewById(R.id.tvPattern);
        }
    }
}
