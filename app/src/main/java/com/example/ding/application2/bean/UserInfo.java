package com.example.ding.application2.bean;

public class UserInfo {
    private String username;

    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String[] getValues() {
        return new String[]{
                this.username, this.password
        };
    }

    public void setValues(String[] values) {
        if (values == null || values.length < 2) {
            return;
        }
        this.setUsername(values[0]);
        this.setPassword(values[1]);
    }

}
