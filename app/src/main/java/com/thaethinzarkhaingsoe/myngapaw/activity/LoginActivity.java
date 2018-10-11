package com.thaethinzarkhaingsoe.myngapaw.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.thaethinzarkhaingsoe.myngapaw.Excel.Excel_Thread;
import com.thaethinzarkhaingsoe.myngapaw.R;
import com.thaethinzarkhaingsoe.myngapaw.mylibrary.SaveData;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName,etPass;
    Button btnLogin,btnCancel;
    String loadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

//        etName = findViewById(R.id.etName);
//        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        String loadData = SaveData.getInstance(this).get("LoadData");
        if(loadData.equals("")){
            Excel_Thread thread = new Excel_Thread(LoginActivity.this);
            thread.readExcel();
            thread.execute();
            SaveData.getInstance(this).add("LoadData","Already");
        }

        btnLogin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCancel:
                Excel_Thread thread = new Excel_Thread(LoginActivity.this);
                thread.readExcel();
                thread.execute();
                break;

        }
    }
}
