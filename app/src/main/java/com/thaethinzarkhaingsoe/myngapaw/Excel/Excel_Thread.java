package com.thaethinzarkhaingsoe.myngapaw.Excel;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Eiron on 3/26/17.
 */

public class Excel_Thread extends AsyncTask<Void, Void, String> {
    private final String CREATE_EXCEL = "create_excel";
    private final String READ_EXCEL = "read_excel";
    private String SuccessMessage = "";
    private String dialogTitle = "";
    private String dialogMessage = "";
    String action;
    Context context;
    ProgressDialog progressDialog = null;

    public Excel_Thread(Context context) {
        this.context = context;
    }

    public void readExcel() {
        action = READ_EXCEL;
        dialogTitle = "Loading Database";
        dialogMessage = "Loading Database...";
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(dialogTitle);
        progressDialog.setMessage(dialogMessage);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
       /* if (action.equals(CREATE_EXCEL)) {
            if (ExcelHandler.writeExcel(context, fileName)) {
                SuccessMessage = "Excel Created SuccessfullY";
            } else {
                SuccessMessage = "Something Wrong";
                return SuccessMessage;
            }
        } else*/ if (action.equals(READ_EXCEL)) {
            if (ExcelHandler.readExcelFile(context)) {
                SuccessMessage = "Load Database successfully";
            } else {
                SuccessMessage = "Something Wrong";
                return SuccessMessage;
            }
        }
        return SuccessMessage;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}
