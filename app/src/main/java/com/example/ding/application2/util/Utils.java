package com.example.ding.application2.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

    private static Utils u;

    public static Utils intence() {
        if (u == null) {
            u = new Utils();
        }
        return u;
    }

    public  String getWordJsonStr(Context context) {
        String res = null;
        try {
            AssetManager am = context.getAssets();
            InputStream is = am.open("words.json");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int count = 0;
            while ((count = is.read(data)) != -1) {
                bos.write(data, 0, count);
            }
            res = new String(bos.toByteArray(), "UTF-8");
            is.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
