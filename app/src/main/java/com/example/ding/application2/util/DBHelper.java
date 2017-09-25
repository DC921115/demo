package com.example.ding.application2.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.ding.application2.bean.WordInfo;

public class DBHelper extends SQLiteOpenHelper implements DBTable {
    private static SQLiteDatabase db;
    private static final int version = 1;

    public static SQLiteDatabase getDB(Context context) {
        if (db == null) {
            db = new DBHelper(context).getWritableDatabase();
        }
        return db;
    }

    public DBHelper(Context context) {
        this(context, "word.db", null, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + getWordTable());
        db.execSQL("CREATE TABLE " + getUserTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private String getWordTable() {
        String exTableDevInfoStr = TableWordInfo.TableName + "(id integer NOT NULL PRIMARY KEY AUTOINCREMENT, ";
        for (int i = 0; i < TableWordInfo.TableColumns.length; i++) {
            if (i < TableWordInfo.TableColumns.length - 1) {
                exTableDevInfoStr += TableWordInfo.TableColumns[i] + " TEXT, ";
            } else {
                exTableDevInfoStr += TableWordInfo.TableColumns[i] + " TEXT)";
            }
        }
        return exTableDevInfoStr;
    }


    private String getUserTable() {
        String exTableProjInfoStr = TableUserInfo.TableName + "(id integer NOT NULL PRIMARY KEY AUTOINCREMENT, ";
        for (int i = 0; i < TableUserInfo.TableColumns.length; i++) {
            if (i < TableUserInfo.TableColumns.length - 1) {
                exTableProjInfoStr += TableUserInfo.TableColumns[i] + " TEXT, ";
            } else {
                exTableProjInfoStr += TableUserInfo.TableColumns[i] + " TEXT)";
            }
        }
        return exTableProjInfoStr;
    }


}
