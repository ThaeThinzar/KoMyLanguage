package com.thaethinzarkhaingsoe.myngapaw.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Khaing on 3/15/2018.
 */

public class ConversationModel implements Parcelable {
    int id;
    String converTitle, converKorean,converEnglish,converMyanmar;

    public ConversationModel(int id,String converTitle,String converKorean,String converEnglish,String converMyanmar)
    {
        this.converTitle=converTitle;
        this.converKorean=converKorean;
        this.converEnglish=converEnglish;
        this.converMyanmar=converMyanmar;

    }

    protected ConversationModel(Parcel in) {
        id = in.readInt();
        converTitle=in.readString();
        converKorean = in.readString();
        converEnglish = in.readString();
        converMyanmar = in.readString();
    }

    public static final Creator<ConversationModel> CREATOR = new Creator<ConversationModel>() {
        @Override
        public ConversationModel createFromParcel(Parcel in) {
            return new ConversationModel(in);
        }

        @Override
        public ConversationModel[] newArray(int size) {
            return new ConversationModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getConverTitle() {
        return converTitle;
    }

    public void setConverTitle(String converTitle) {
        this.converTitle = converTitle;
    }


    public String getConverKorean() {
        return converKorean;
    }

    public void setConverKorean(String converKorean) {
        this.converKorean = converKorean;
    }

    public String getConverEnglish() {
        return converEnglish;
    }

    public void setConverEnglish(String converEnglish) {
        this.converEnglish = converEnglish;
    }

    public String getConverMyanmar() {
        return converMyanmar;
    }

    public void setConverMyanmar(String converMyanmar) {
        this.converMyanmar = converMyanmar;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(converTitle);
        dest.writeString(converKorean);
        dest.writeString(converEnglish);
        dest.writeString(converMyanmar);
    }
}
