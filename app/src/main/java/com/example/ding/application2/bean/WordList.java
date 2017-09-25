package com.example.ding.application2.bean;

import android.content.Context;
import com.example.ding.application2.util.Utils;
import com.google.gson.Gson;

import java.util.ArrayList;

public class WordList {
    private static WordList w;
    private static WordInfo[] dataList;

    public static WordList intence(Context context) {
        if (w == null) {
            w = new WordList();
        }
        String result = Utils.intence().getWordJsonStr(context);
        JsonData jsonData = new Gson().fromJson(result, JsonData.class);
        dataList = jsonData.getData();
        return w;
    }

    public ArrayList<WordInfo> getGrade(int grade) {
        String g = String.valueOf(grade);
        ArrayList<WordInfo> list = new ArrayList<WordInfo>();
        for (int i = 0; i < dataList.length; i++) {
            WordInfo wordInfo = dataList[i];
            if (wordInfo.getGrade().equals(g)) {
                list.add(wordInfo);
            }
        }
        return list;
    }


}
