package com.example.ding.application2.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.ding.application2.bean.UserInfo;

import static android.content.ContentValues.TAG;

public class DBManager implements DBTable {

    public static void insertUser(Context context, UserInfo info) {
        if (info == null) {
            return;
        }
        String[] devValues = info.getValues();
        SQLiteDatabase database = DBHelper.getDB(context);
        Log.d("TAG", "insertUser: ===1==" + devValues.length);
        Log.d("TAG", "insertUser: ===2==" + TableUserInfo.TableColumns.length);
        if (devValues.length == TableUserInfo.TableColumns.length) {
            ContentValues values = new ContentValues();
            for (int i = 0; i < TableUserInfo.TableColumns.length; i++) {
                values.put(TableUserInfo.TableColumns[i], devValues[i]);
            }
            Log.d("TAG", "insertUser: ======" + values.toString());
            database.insert(TableUserInfo.TableName, null, values);
        }
    }

    public static UserInfo queryUserByUsername(Context context, String username) {
        if (username.length() == 0) {
            return null;
        }
        UserInfo userInfo = null;
        try {
            SQLiteDatabase database = DBHelper.getDB(context);
//            Log.d("TAG", "queryUserByUsername: ========" + TableUserInfo.TableColumns[0]);
//            Log.d("TAG", "queryUserByUsername: ========" + username);
            Cursor cursor = database.rawQuery("select * from " + TableUserInfo.TableName + " where " + TableUserInfo.TableColumns[0] + "=?",  new String[]{username});
//            Cursor cursor = database.rawQuery("select * from " + TableUserInfo.TableName, null);
//            Log.d("TAG", "queryUserByUsername: ======" + cursor.getCount());
            if (cursor != null && cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {
                    String[] columnValues = new String[TableUserInfo.TableColumns.length];
                    for (int i = 0; i < columnValues.length; i++) {
                        int index = cursor.getColumnIndex(TableUserInfo.TableColumns[i]);
                        columnValues[i] = index == -1 ? "" : cursor.getString(index);
                    }
                    userInfo = new UserInfo();
                    userInfo.setValues(columnValues);
                }
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;

    }

    public static void insertWord() {

    }

    public static void queryWord() {

    }
}
