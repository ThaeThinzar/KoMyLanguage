package com.thaethinzarkhaingsoe.myngapaw.Excel;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.thaethinzarkhaingsoe.myngapaw.database.DbController;
import com.thaethinzarkhaingsoe.myngapaw.models.ConversationModel;
import com.thaethinzarkhaingsoe.myngapaw.models.GrammarModel;
import com.thaethinzarkhaingsoe.myngapaw.models.VocalModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelHandler {

    public static boolean readExcelFile(Context context) {
        InputStream is = null;
        if (!isExternalStorageAvailable()) {
            Log.d("Excel", "External Storage  is Full.....");
            return false;
        }

        try {
            AssetManager assetManager = context.getResources().getAssets();
            InputStream file = assetManager.open("KoreaDb.xlsx");
            InsertDataBase(file, context);

//            is = assetManager.open("KoreaDatabase.xls");
//            dbController.openDb();
//            dbController.clearkoreaDb();
//            String id = null;
//            String[] varCell=new String[4] ; int a=0;
//            ArrayList<VocalModel> vList = new ArrayList<>();
//            switch (ext) {
//                case XLS:
//                    boolean isFirstRowXLS = false;
//                    POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);
//                    HSSFWorkbook workbookXLS = new HSSFWorkbook(poifsFileSystem);
//                    Log.e("ExcelFilePUtting", "sheets"+ workbookXLS.getNumberOfSheets() );
//                    for (int k = 0; k<workbookXLS.getNumberOfSheets(); k++) {
//                        HSSFSheet sheetXSF = (HSSFSheet) workbookXLS.getSheetAt(k);
//                        Iterator iterator = sheetXSF.rowIterator();
//                        while (iterator.hasNext()) {
//                            HSSFRow row = (HSSFRow) iterator.next();
//                            if (!isFirstRowXLS) {
//                                isFirstRowXLS = true;
//                                continue;
//                            }
//                            Iterator cell = row.cellIterator();
//                            while (cell.hasNext()) {
//                                HSSFCell myCell = (HSSFCell) cell.next();
//                                Log.e("Cell ", "Sheet"+k+"  /  Cell " + myCell.toString());
//                                varCell[a]=myCell.toString();
//                                a++;
//                            }
//                            id = varCell[0];
//                            float floatId = Float.parseFloat(id);
//                            int intId = (int) floatId;
//                            VocalModel vModel=new VocalModel(intId,varCell[1],varCell[2],varCell[3]);
//                            varCell = new String[4];
//                            dbController.insertVolData(vModel);
//                            a=0;
//
//                        }
//                        Log.e("Sheet", "Sheet " + k + "Successfully");
//                    }
//                    dbController.closeDb();
//                    break;
//                case XLSX:
//                    boolean isFirstRowXLSX = false;
//                    XSSFWorkbook workbookXLSX = new XSSFWorkbook(file);
//                    for (int k = 0; k < workbookXLSX.getNumberOfSheets(); k++) {
//                        XSSFSheet sheetXSFX = (XSSFSheet) workbookXLSX.getSheetAt(k);
//                        Iterator iterator1 = sheetXSFX.rowIterator();
//                        while (iterator1.hasNext()) {
//                            XSSFRow row = (XSSFRow) iterator1.next();
//                            if (!isFirstRowXLSX) {
//                                isFirstRowXLSX = true;
//                                continue;
//                            }
//                            Iterator cell = row.cellIterator();
//                            while (cell.hasNext()) {
//                                XSSFCell myCell = (XSSFCell) cell.next();
//                                Log.d("Cell ", "Sheet"+k+"  /  Cell " + myCell.toString());
//                                varCell[a]=myCell.toString();
//                                a++;
//                            }
//                            id = varCell[0];
//                            float floatId = Float.parseFloat(id);
//                            int intId = (int) floatId;
//                            VocalModel vModel=new VocalModel(intId,varCell[1],varCell[2],varCell[3]);
//                            varCell = new String[4];
//                            dbController.insertVolData(vModel);
//                            a=0;
//                        }
//                        Log.d("Sheet", "Sheet " + k + "Successfully");
//                    }
//                    dbController.closeDb();
//                    break;
//            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    private static void InsertDataBase(InputStream file, Context context) {
        DbController dbController = new DbController(context);
        dbController.openDb();
        dbController.clearkoreaDb();
        String id = null;
        int a = 0;
        boolean isFirstRowXLSX = false;
        XSSFWorkbook workbookXLSX = null;
        try {
            workbookXLSX = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int k = 0; k < workbookXLSX.getNumberOfSheets(); k++) {
            XSSFSheet sheetXSFX = (XSSFSheet) workbookXLSX.getSheetAt(k);
            Iterator iterator1 = sheetXSFX.rowIterator();
            if (k == 0) {
                while (iterator1.hasNext()) {
                    XSSFRow row = (XSSFRow) iterator1.next();
                    if (!isFirstRowXLSX) {
                        isFirstRowXLSX = true;
                        continue;
                    }
                    String[] varcell = new String[]{"", "", "", "", ""};
                    Iterator cell = row.cellIterator();
                    while (cell.hasNext()) {
                        XSSFCell mycell = (XSSFCell) cell.next();
                        Log.d("cell ", "sheet" + k + "  /  cell " + a + mycell.toString());
                        varcell[a] = mycell.toString();
                        a++;
                    }
                    a = 0;

                    id = varcell[0];
                    Float floatid = Float.parseFloat(id);
                    int intid = 1;
                    VocalModel vmodel = new VocalModel(intid, varcell[1], varcell[2], varcell[3], varcell[4]);
                    dbController.insertVolData(vmodel);
                }isFirstRowXLSX=false;
            } else if (k == 1) {
                while (iterator1.hasNext()) {
                    XSSFRow row = (XSSFRow) iterator1.next();
                    if (!isFirstRowXLSX) {
                        isFirstRowXLSX = true;
                        continue;
                    }
                    String[] varCell = new String[]{"", "", "", "", "", "", "", "", "", "", "",};
                    Iterator cell = row.cellIterator();
                    while (cell.hasNext()) {
                        String cellString = "";
                        XSSFCell myCell = (XSSFCell) cell.next();
                        Log.d("Cell ", "Sheet" + k + "  /  Cell " + a + myCell.toString());
                        if (myCell.toString().equals("nodata")) {
                            varCell[a] = cellString;
                        } else {
                            varCell[a] = myCell.toString();
                        }
                        a++;
                    }
                    a = 0;
//
//                    id = varCell[0];
//                    float floatId = Float.parseFloat(id);
                    int intId = 1;
                    GrammarModel gModel = new GrammarModel(intId, varCell[1], varCell[2], varCell[3], varCell[4], varCell[5], varCell[6], varCell[7], varCell[8],
                            varCell[9], varCell[10]);
                    dbController.insertGramData(gModel);
                }
                isFirstRowXLSX=false;
            }else if(k==2){
                while (iterator1.hasNext()) {
                    XSSFRow row = (XSSFRow) iterator1.next();
                    if (!isFirstRowXLSX) {
                        isFirstRowXLSX = true;
                        continue;
                    }
                    String[] varCell = new String[]{"", "", "", "", ""};
                    Iterator cell = row.cellIterator();
                    while (cell.hasNext()) {
                        String cellString = "";
                        XSSFCell myCell = (XSSFCell) cell.next();
                        Log.d("Cell ", "Sheet" + k + "  /  Cell " + a + myCell.toString());
                        if (myCell.toString().equals("nodata")) {
                            varCell[a] = cellString;
                        } else {
                            varCell[a] = myCell.toString();
                        }
                        a++;
                    }
                    a = 0;
//
//                    id = varCell[0];
//                    float floatId = Float.parseFloat(id);
                    int intId = 1;
                    ConversationModel conversationModel = new ConversationModel(intId, varCell[0], varCell[1], varCell[2], varCell[3]);
                    dbController.insertConversationData(conversationModel);
                }
                isFirstRowXLSX=false;
            }

            Log.d("Sheet", "Sheet " + k + "Successfully");
        }
        dbController.closeDb();
        if (file != null) {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

}
