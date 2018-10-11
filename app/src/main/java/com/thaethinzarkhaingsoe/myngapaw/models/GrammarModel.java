package com.thaethinzarkhaingsoe.myngapaw.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dell on 1/15/2018.
 */

public class GrammarModel implements Parcelable {
    int id;
    String pattern,mmMeaning,engMeaning,mmExample,engExample,koreaExample,form_1,form_2,form_3,form_4;

    public GrammarModel(int id, String pattern, String mmMeaning, String engMeaning, String mmExample, String engExample, String koreaExample, String form_1, String form_2, String form_3, String form_4) {
        this.id = id;
        this.pattern = pattern;
        this.mmMeaning = mmMeaning;
        this.engMeaning = engMeaning;
        this.mmExample = mmExample;
        this.engExample = engExample;
        this.koreaExample = koreaExample;
        this.form_1 = form_1;
        this.form_2 = form_2;
        this.form_3 = form_3;
        this.form_4 = form_4;
    }

    protected GrammarModel(Parcel in) {
        id = in.readInt();
        pattern = in.readString();
        mmMeaning = in.readString();
        engMeaning = in.readString();
        mmExample = in.readString();
        engExample = in.readString();
        koreaExample = in.readString();
        form_1 = in.readString();
        form_2 = in.readString();
        form_3 = in.readString();
        form_4 = in.readString();
    }

    public static final Creator<GrammarModel> CREATOR = new Creator<GrammarModel>() {
        @Override
        public GrammarModel createFromParcel(Parcel in) {
            return new GrammarModel(in);
        }

        @Override
        public GrammarModel[] newArray(int size) {
            return new GrammarModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getMmMeaning() {
        return mmMeaning;
    }

    public void setMmMeaning(String mmMeaning) {
        this.mmMeaning = mmMeaning;
    }

    public String getEngMeaning() {
        return engMeaning;
    }

    public void setEngMeaning(String engMeaning) {
        this.engMeaning = engMeaning;
    }

    public String getMmExample() {
        return mmExample;
    }

    public void setMmExample(String mmExample) {
        this.mmExample = mmExample;
    }

    public String getEngExample() {
        return engExample;
    }

    public void setEngExample(String engExample) {
        this.engExample = engExample;
    }

    public String getKoreaExample() {
        return koreaExample;
    }

    public void setKoreaExample(String koreaExample) {
        this.koreaExample = koreaExample;
    }

    public String getForm_1() {
        return form_1;
    }

    public void setForm_1(String form_1) {
        this.form_1 = form_1;
    }

    public String getForm_2() {
        return form_2;
    }

    public void setForm_2(String form_2) {
        this.form_2 = form_2;
    }

    public String getForm_3() {
        return form_3;
    }

    public void setForm_3(String form_3) {
        this.form_3 = form_3;
    }

    public String getForm_4() {
        return form_4;
    }

    public void setForm_4(String form_4) {
        this.form_4 = form_4;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(pattern);
        dest.writeString(mmMeaning);
        dest.writeString(engMeaning);
        dest.writeString(mmExample);
        dest.writeString(engExample);
        dest.writeString(koreaExample);
        dest.writeString(form_1);
        dest.writeString(form_2);
        dest.writeString(form_3);
        dest.writeString(form_4);
    }
}
