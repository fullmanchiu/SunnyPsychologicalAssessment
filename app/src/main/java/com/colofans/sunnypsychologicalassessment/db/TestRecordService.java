package com.colofans.sunnypsychologicalassessment.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.colofans.sunnypsychologicalassessment.beans.TestRecord;

import java.util.ArrayList;

/**
 * Created by Castor on 2016/5/20.
 */
public class TestRecordService {
    private DBHelper dbHelper;

    public TestRecordService(Context context) {
        dbHelper = new DBHelper(context);
    }

    public boolean addDevice(TestRecord record) {
        Log.i("Lance", "addDevice:" + record.toString());
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "insert into records(name,score,summary) values(?,?,?)";
        Object obj[] = {record.getName(), record.getScore(), record.getSummary()};
        sdb.execSQL(sql, obj);
        sdb.close();
        return true;
    }

    public ArrayList<TestRecord> getRecordList() {
        ArrayList<TestRecord> records = null;
        TestRecord record = null;
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        Cursor cursor = sdb.query("records", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            records = new ArrayList<>();
            record = new TestRecord(cursor.getString(cursor.getColumnIndex(TestRecord.RECORD_NAME))
                    , cursor.getString(cursor.getColumnIndex(TestRecord.RECORD_SCORE))
                    , cursor.getString(cursor.getColumnIndex(TestRecord.RECORD_SUMMARY)));
            record.setId(cursor.getInt(cursor.getColumnIndex(TestRecord.RECORD_ID)));
            records.add(record);
            while (cursor.moveToNext()) {
                record = new TestRecord(cursor.getString(cursor.getColumnIndex(TestRecord.RECORD_NAME))
                        , cursor.getString(cursor.getColumnIndex(TestRecord.RECORD_SCORE))
                        , cursor.getString(cursor.getColumnIndex(TestRecord.RECORD_SUMMARY)));
                record.setId(cursor.getInt(cursor.getColumnIndex(TestRecord.RECORD_ID)));
                records.add(record);
            }
        } else {
            Log.i("Lance", "cursor is empty");
            return null;
        }
        cursor.close();
        sdb.close();
        return records;
    }

    public void delete(int id) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "DELETE FROM records WHERE id = " + id;
        sdb.execSQL(sql);
        sdb.close();
    }
}
