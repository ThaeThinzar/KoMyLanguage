package com.thaethinzarkhaingsoe.myngapaw.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.activity.VocabularyViewActivity;
import com.thaethinzarkhaingsoe.myngapaw.models.VocalModel;
import com.thaethinzarkhaingsoe.myngapaw.mylibrary.TextViewPlus;

import java.util.ArrayList;

/**
 * Created by Dell on 1/14/2018.
 */

public class VolRcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   // Dialog myDialog;
    ArrayList<VocalModel> volcaModel = new ArrayList<>();
    Context context;


    public VolRcAdapter(Context context,ArrayList<VocalModel> volcaModel) {
        this.context = context;
        this.volcaModel = volcaModel;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_volca, null ,false );
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new MyHolderItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((MyHolderItem)holder).tvKoera.setText(volcaModel.get(position).getKoera());

        ((MyHolderItem) holder).tvKoera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(context, VocabularyViewActivity.class);
                i.putExtra("VocaModel" , volcaModel.get(position));
                context.startActivity(i);
            }
        });
    }

   /* public void showPopUp(View v){
        myDialog.setContentView(R.layout.volcab_popup);
        tvKorea = myDialog.findViewById(R.id.tvKorea);
        tvEnglish = myDialog.findViewById(R.id.tvEnglish);
        tvMyanmar = myDialog.findViewById(R.id.tvMyanmar);

        tvKorea.setText(model.getKoera());
        tvEnglish.setText(model.getEnglish());
        tvMyanmar.setText(model.getMyanmar());
        tvCategory.setText(model.getCategory());
        Log.e("Myanmar", "onCreate: "+model.getMyanmar() );
        myDialog.show();
    }*/
    @Override
    public int getItemCount() {
        return volcaModel.size();
    }

    private class MyHolderItem extends RecyclerView.ViewHolder {
        TextView tvKoera;

        public MyHolderItem(View itemView) {
            super(itemView);
            tvKoera = (TextView) itemView.findViewById(R.id.tvKorea);
        }
    }
}
