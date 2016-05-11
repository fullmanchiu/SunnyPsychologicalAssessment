package com.colofans.sunnypsychologicalassessment.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Castor on 2016/5/9.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "test.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "create table IF NOT EXISTS SCALE(sid integer primary key autoincrement,name TEXT,description TEXT,length INTEGER)";
    private Context mContext; //text shiyihui
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
        Log.i("Lance", "DBHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("Lance", "onCreate");
        createTables(db);
        initData(db);
    }

    private void initData(SQLiteDatabase db) {
        Log.i("Lance", "initData");
        String[] sqlList = readSqlFromAssets("initdata.txt").split(";");
        for (int i = 0; i < sqlList.length; i++) {
            Log.i("Lance", "sql:" + sqlList[i]);
            db.execSQL(sqlList[i]);
        }
    }

    private void createTables(SQLiteDatabase db) {
        Log.i("Lance", "111");
        String wholeSql = "";
        String fileName = "create_table.txt";

        wholeSql = readSqlFromAssets(fileName);
        String[] sqlList = wholeSql.split(";");
        for (int i = 0; i < sqlList.length; i++) {
            Log.i("Lance", "sql:" + sqlList[i]);
            db.execSQL(sqlList[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String readSqlFromAssets(String fileName) {
        try {
            InputStream is = mContext.getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
