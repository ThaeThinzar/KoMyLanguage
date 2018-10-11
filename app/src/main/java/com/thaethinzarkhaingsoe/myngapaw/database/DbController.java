package com.thaethinzarkhaingsoe.myngapaw.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.thaethinzarkhaingsoe.myngapaw.models.ConversationModel;
import com.thaethinzarkhaingsoe.myngapaw.models.GrammarModel;
import com.thaethinzarkhaingsoe.myngapaw.models.VocalModel;

import java.util.ArrayList;

/**
 * Created by Dell on 1/13/2018.
 */

public class DbController {
    KoreaDB koreaDB;
    SQLiteDatabase db;
    Context context;

    public DbController(Context context) {
        this.context = context;
        koreaDB = new KoreaDB(context);

    }

    public void openDb(){
        db= koreaDB.getWritableDatabase();
    }

    public void closeDb(){
        db.close();
    }

    public void clearkoreaDb(){
        koreaDB.onUpgrade(db,1,1);
    }

    private class KoreaDB extends SQLiteOpenHelper {
        private static final String DB_NAME = "korea_db";
        private static final String TB_VOCABULARY = "volca_tb";
        private static final String TB_GRAMMAR = "gram_tb";
        private static final String TB_CONVER="conver_tb";
        private static final String VOL_ID = "id";
        private static final String VOL_KOERA = "koera";
        private static final String VOL_ENGLISH = "english";
        private static final String VOL_MYANMAR = "myanmar";
        private static final String VOL_CATEGORY = "category";
        private static final String GRA_ID = "gram_id";
        private static final String GRA_PATTERN = "pattern";
        private static final String GRA_MMMEANING = "mm_meaning";
        private static final String GRA_ENGEANING = "eng_meaning";
        private static final String GRA_MMEXAMPLE = "mm_example";
        private static final String GRA_ENGEXAMPLE = "eng_example";
        private static final String GRA_KOREXAMPLE = "kor_example";
        private static final String GRA_FORM1 = "form_1";
        private static final String GRA_FORM2 = "form_2";
        private static final String GRA_FORM3 = "form_3";
        private static final String GRA_FORM4 = "from_4";
        private static final String CONVER_ID="conver_id";
        private static final String CONVER_TITLE="conver_title";
        private static final String CONVER_KO="conver_korean";
        private static final String CONVER_ENG="conver_englilsh";
        private static final String CONVER_MYAN="conver_myanmar";
        private static final int DB_VERSION = 1;

        private static final String VOCA_TABLE_CREATE = "CREATE TABLE " + TB_VOCABULARY + " (" + VOL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + VOL_KOERA + " VARCHAR(100)," +
                VOL_ENGLISH + " VARCHAR(100) , " + VOL_MYANMAR + " VARCHAR(100) , "+VOL_CATEGORY+" VARCHAR(100))";

        private static final String GRAM_TABLE_CREATE = "CREATE TABLE " + TB_GRAMMAR + " (" + GRA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + GRA_PATTERN + " VARCHAR(100)," +
                GRA_MMMEANING + " VARCHAR(100) , " +GRA_ENGEANING + " VARCHAR(100) , " +GRA_MMEXAMPLE + " VARCHAR(255) , " +
                GRA_ENGEXAMPLE + " VARCHAR(255) , " + GRA_KOREXAMPLE + " VARCHAR(255) , " +GRA_FORM1 + " VARCHAR(255) , " +
                GRA_FORM2 + " VARCHAR(255) , " +GRA_FORM3 + " VARCHAR(255) , " +GRA_FORM4 + " VARCHAR(255))";

        private static final String CONVER_TABLE_CREATE="CREATE TABLE "+TB_CONVER+"("+CONVER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+CONVER_TITLE+" VARCHAR(100),"+
                CONVER_KO+" VARCHAR(100),"+CONVER_ENG+" VARCHAR(100),"+CONVER_MYAN+" VARCHAR(100))";

        public KoreaDB(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        public KoreaDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(VOCA_TABLE_CREATE);
            db.execSQL(GRAM_TABLE_CREATE);
            db.execSQL(CONVER_TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TB_VOCABULARY);
            db.execSQL("DROP TABLE IF EXISTS " + TB_GRAMMAR);
            db.execSQL("DROP TABLE IF EXISTS " + TB_CONVER);
            onCreate(db);
        }
    }

    public ArrayList<VocalModel> queryVolData(){
        ArrayList<VocalModel> volcaList = new ArrayList<>();
        Cursor cursor=db.query(koreaDB.TB_VOCABULARY,null,null,null,null,null,null);
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            int idIndex = cursor.getColumnIndex(koreaDB.VOL_ID);
            int koeraIndex = cursor.getColumnIndex(koreaDB.VOL_KOERA);
            int englishIndex = cursor.getColumnIndex(koreaDB.VOL_ENGLISH);
            int myanmarIndex = cursor.getColumnIndex(koreaDB.VOL_MYANMAR);
            int categoryIndex = cursor.getColumnIndex(koreaDB.VOL_CATEGORY);

            volcaList.add(new VocalModel(cursor.getInt(idIndex),cursor.getString(koeraIndex),cursor.getString(englishIndex),cursor.getString(myanmarIndex),cursor.getString(categoryIndex)));
        }
        return volcaList;
    }

    public ArrayList<GrammarModel> queryGramData(){
        ArrayList<GrammarModel> gramList = new ArrayList<>();
        Cursor cursor=db.query(koreaDB.TB_GRAMMAR,null,null,null,null,null,null);
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            int idIndex = cursor.getColumnIndex(koreaDB.GRA_ID);
            int patternIndex = cursor.getColumnIndex(koreaDB.GRA_PATTERN);
            int mmmeanIndex = cursor.getColumnIndex(koreaDB.GRA_MMMEANING);
            int engmeanIndex = cursor.getColumnIndex(koreaDB.GRA_ENGEANING);
            int mmegIndex = cursor.getColumnIndex(koreaDB.GRA_MMEXAMPLE);
            int engegIndex = cursor.getColumnIndex(koreaDB.GRA_ENGEXAMPLE);
            int koregIndex = cursor.getColumnIndex(koreaDB.GRA_KOREXAMPLE);
            int form1Index = cursor.getColumnIndex(koreaDB.GRA_FORM1);
            int form2Index = cursor.getColumnIndex(koreaDB.GRA_FORM2);
            int form3Index = cursor.getColumnIndex(koreaDB.GRA_FORM3);
            int form4Index = cursor.getColumnIndex(koreaDB.GRA_FORM4);

            gramList.add(new GrammarModel(cursor.getInt(idIndex),cursor.getString(patternIndex),cursor.getString(mmmeanIndex),cursor.getString(engmeanIndex),
                    cursor.getString(mmegIndex), cursor.getString(engegIndex), cursor.getString(koregIndex), cursor.getString(form1Index), cursor.getString(form2Index),
                    cursor.getString(form3Index),cursor.getString(form4Index)));
        }
        return gramList;
    }

    public ArrayList<ConversationModel>queryConverData(){
        ArrayList<ConversationModel> converList=new ArrayList<>();
        Cursor cursor=db.query(koreaDB.TB_CONVER,null,null,null,null,null,null);
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            int idIndex=cursor.getColumnIndex(koreaDB.CONVER_ID);
            int converTitle=cursor.getColumnIndex(koreaDB.CONVER_TITLE);
            int converKorean=cursor.getColumnIndex(koreaDB.CONVER_KO);
            int converEnglish=cursor.getColumnIndex(koreaDB.CONVER_ENG);
            int converMyan=cursor.getColumnIndex(koreaDB.CONVER_MYAN);
            converList.add(new ConversationModel(cursor.getInt(idIndex),cursor.getString(converTitle),cursor.getString(converKorean),cursor.getString(converEnglish),cursor.getString(converMyan)));


        }
    return converList;
    }

    public void insertVolData(VocalModel vocalModel){
        ContentValues cv = new ContentValues();
        // key , vlaue  => column name , value
        cv.put(koreaDB.VOL_KOERA, vocalModel.getKoera());
        cv.put(koreaDB.VOL_ENGLISH, vocalModel.getEnglish());
        cv.put(koreaDB.VOL_MYANMAR, vocalModel.getMyanmar());
        cv.put(koreaDB.VOL_CATEGORY, vocalModel.getCategory());

        long row = db.insert(koreaDB.TB_VOCABULARY, null, cv);
        if (row > 0) {
            Log.e("DbController", "insertVolData: "+"Successful" );
//            Toast.makeText(context, "Insert VolcaData Successful", Toast.LENGTH_SHORT).show();
        } else {
            Log.e("DbController", "insertVolData: "+"Successful" );
//            Toast.makeText(context, "Insert VolcaData Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    public void insertGramData(GrammarModel grammarModel){
        ContentValues cv = new ContentValues();
        // key , vlaue  => column name , value
        cv.put(koreaDB.GRA_PATTERN, grammarModel.getPattern());
        cv.put(koreaDB.GRA_MMMEANING, grammarModel.getMmMeaning());
        cv.put(koreaDB.GRA_ENGEANING, grammarModel.getEngMeaning());
        cv.put(koreaDB.GRA_MMEXAMPLE, grammarModel.getMmExample());
        cv.put(koreaDB.GRA_ENGEXAMPLE, grammarModel.getEngExample());
        cv.put(koreaDB.GRA_KOREXAMPLE, grammarModel.getKoreaExample());
        cv.put(koreaDB.GRA_FORM1, grammarModel.getForm_1());
        cv.put(koreaDB.GRA_FORM2, grammarModel.getForm_2());
        cv.put(koreaDB.GRA_FORM3, grammarModel.getForm_3());
        cv.put(koreaDB.GRA_FORM4, grammarModel.getForm_4());

        long row = db.insert(koreaDB.TB_GRAMMAR, null, cv);
        if (row > 0) {
            Log.e("DbController", "insertGrammerData: "+"Successful" );
//            Toast.makeText(context, "Insert VolcaData Successful", Toast.LENGTH_SHORT).show();
        } else {
            Log.e("DbController", "insertGrammerData: "+"UnSuccessful" );
//            Toast.makeText(context, "Insert VolcaData Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    public void insertConversationData(ConversationModel conversationModel){
        ContentValues cv=new ContentValues();
        cv.put(koreaDB.CONVER_TITLE,conversationModel.getConverTitle());
        cv.put(koreaDB.CONVER_KO,conversationModel.getConverKorean());
        cv.put(koreaDB.CONVER_ENG,conversationModel.getConverEnglish());
        cv.put(koreaDB.CONVER_MYAN,conversationModel.getConverMyanmar());
        long row=db.insert(koreaDB.TB_CONVER,null,cv);
        if (row > 0) {
            Log.e("DbController", "insertConversationData: "+"Successful" );
//            Toast.makeText(context, "Insert conversation data Successful", Toast.LENGTH_SHORT).show();
        } else {
            Log.e("DbController", "insertConversationData: "+"UnSuccessful" );
//            Toast.makeText(context, "Insert conversation data Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteVolData(VocalModel model){
        String selection = koreaDB.VOL_KOERA +"=?";
        String selectionArgs[]={model.getKoera()};
        int rr = db.delete(koreaDB.TB_VOCABULARY,selection,selectionArgs);
        if(rr>0){
            Toast.makeText(context, "Delete Vol Successful", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Delete Vol Fail", Toast.LENGTH_SHORT).show();
        }
    }
}
