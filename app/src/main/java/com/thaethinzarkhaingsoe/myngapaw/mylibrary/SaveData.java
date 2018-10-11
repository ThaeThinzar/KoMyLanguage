package com.thaethinzarkhaingsoe.myngapaw.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dell on 1/15/2018.
 */

public class SaveData {
    private static SaveData saveData;
    private SharedPreferences sharedPreferences;

    public static SaveData getInstance(Context context) {
        if (saveData == null) {
            saveData = new SaveData(context);
        }
        return saveData;
    }
    private SaveData(Context context) {
        sharedPreferences = context.getSharedPreferences("SaveData",Context.MODE_PRIVATE);
    }
    public void add(String key,String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public void remove(String key){
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.remove(key);
        prefsEditor.commit();
    }

    public String get(String key) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }

    public void removeAll(){
        sharedPreferences.edit().clear().commit();
    }

}
