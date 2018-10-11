package com.thaethinzarkhaingsoe.myngapaw.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dell on 1/13/2018.
 */

public class VocalModel implements Parcelable {

    int id;
    String koera,english,myanmar,category;

    public VocalModel(int id,String koera,String english,String myanmar,String category) {
        this.id = id;
        this.koera = koera;
        this.english = english;
        this.myanmar = myanmar;
        this.category = category;
    }

    protected VocalModel(Parcel in) {
        id = in.readInt();
        koera = in.readString();
        english = in.readString();
        myanmar = in.readString();
        category = in.readString();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static Creator<VocalModel> getCREATOR() {
        return CREATOR;
    }

    public static final Creator<VocalModel> CREATOR = new Creator<VocalModel>() {
        @Override
        public VocalModel createFromParcel(Parcel in) {
            return new VocalModel(in);
        }

        @Override
        public VocalModel[] newArray(int size) {
            return new VocalModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKoera() {
        return koera;
    }

    public void setKoera(String koera) {
        this.koera = koera;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMyanmar() {
        return myanmar;
    }

    public void setMyanmar(String myanmar) {
        this.myanmar = myanmar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(koera);
        dest.writeString(english);
        dest.writeString(myanmar);
        dest.writeString(category);
    }
}
