package com.russia.app_sqlite_demo_2.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VLADIMIR PUTIN on 3/1/2018.
 */

public class DataSqlite extends SQLiteOpenHelper {

    Context context;
    String name;
    SQLiteDatabase.CursorFactory factory;

    public DataSqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
        this.name = name;
        this.factory = factory;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /*excute update, insert data to table*/
    public void requestNonGetData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    /*use cursor to get data from table*/
    public Cursor rquestGetData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery(sql, null);
    }
}
