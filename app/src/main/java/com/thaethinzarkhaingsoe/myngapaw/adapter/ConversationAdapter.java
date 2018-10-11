package com.thaethinzarkhaingsoe.myngapaw.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.activity.ConversationViewActivity;
import com.thaethinzarkhaingsoe.myngapaw.activity.GrammarViewActivity;
import com.thaethinzarkhaingsoe.myngapaw.models.ConversationModel;
import com.thaethinzarkhaingsoe.myngapaw.models.GrammarModel;

import java.util.ArrayList;

/**
 * Created by Khaing on 3/15/2018.
 */

public class ConversationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ConversationModel> converModel = new ArrayList<>();
    Context context;

    public ConversationAdapter(Context context, ArrayList<ConversationModel> converModel) {
        this.context = context;
        this.converModel = converModel;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_conversation, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ConversationAdapter.MyHolderItem(view);

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((MyHolderItem) holder).tvTitle.setText(converModel.get(position).getConverTitle());
        Log.e("Conversation", "onBindViewHolder: "+converModel.get(position).getConverTitle() );

        ((MyHolderItem) holder).tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(context, ConversationViewActivity.class);
                i.putExtra("Convermodel", converModel.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return converModel.size();
    }


    class MyHolderItem extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public MyHolderItem(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvConverTitle);
        }

    }
}
