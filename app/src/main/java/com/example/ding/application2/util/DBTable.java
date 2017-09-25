package com.example.ding.application2.util;

public interface DBTable {


    class TableUserInfo {
        static final String TableName = "userInfo";
        //此处column顺序必须与RegistDeviceInfo类成员变量一致，如有修改，则需要同时修改
        static final String[] TableColumns = new String[]{
                "username",
                "password"
        };
    }

    class TableWordInfo {
        static final String TableName = "wordInfo";
        //此处column顺序必须与RegistProjectInfo类成员变量一致，如有修改，则需要同时修改
        static final String[] TableColumns = new String[]{
                "wordName",
                "wordNotice",
                "grade",
                "imageA",
                "imageB",
                "imageC",
                "imageD",
                "answer"
        };
    }

}
