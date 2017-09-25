package com.example.ding.application2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.*;
import com.example.ding.application2.activity.BaseActivity;
import com.example.ding.application2.activity.SelectActivity;
import com.example.ding.application2.bean.UserInfo;
import com.example.ding.application2.util.DBHelper;
import com.example.ding.application2.util.DBManager;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_signin;
    private Button btn_login;
    private Button btn_submit;

    private EditText edit_login_username;
    private EditText edit_login_password;
    private EditText edit_sign_username;
    private EditText edit_sign_password;
    private LinearLayout layout_login;
    private LinearLayout layout_sign;

    private TextView text_main_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_signin = (Button) findViewById(R.id.btn_signin);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        edit_sign_username = (EditText) findViewById(R.id.edit_sign_username);
        edit_sign_password = (EditText) findViewById(R.id.edit_sign_password);
        edit_login_username = (EditText) findViewById(R.id.edit_login_username);
        edit_login_password = (EditText) findViewById(R.id.edit_login_password);

        layout_login = (LinearLayout) findViewById(R.id.layout_login);
        layout_sign = (LinearLayout) findViewById(R.id.layout_sign);

        text_main_title = (TextView) findViewById(R.id.text_main_title);

        btn_login.setOnClickListener(this);
        btn_signin.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_signin:
                sign();
                break;
            case R.id.btn_submit:
                submit();
                break;
        }
    }

    private void login() {
        UserInfo userInfo;
        if (edit_login_username.getText().length() == 0) {
            Toast.makeText(this, "请输入用户名称", Toast.LENGTH_SHORT).show();
        } else if (edit_login_password.getText().length() == 0) {
            Toast.makeText(this, "请输入用户密码", Toast.LENGTH_SHORT).show();
        } else {
            userInfo = DBManager.queryUserByUsername(this, String.valueOf(edit_login_username.getText()));
            if (userInfo == null) {
                Toast.makeText(this, "该用户不存在", Toast.LENGTH_SHORT).show();
            } else if (!userInfo.getPassword().equals(String.valueOf(edit_login_password.getText()))) {
                Toast.makeText(this, "用户密码错误", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SelectActivity.class));
            }
        }
    }

    private void sign() {
        layout_login.setVisibility(View.GONE);
        layout_sign.setVisibility(View.VISIBLE);
        text_main_title.setText("注册");
    }

    private void submit() {
        UserInfo userInfo = new UserInfo();
        if (edit_sign_username.getText().length() == 0) {
            Toast.makeText(this, "请输入用户名称", Toast.LENGTH_LONG).show();
        } else if (edit_sign_password.getText().length() == 0) {
            Toast.makeText(this, "请输入用户密码", Toast.LENGTH_LONG).show();
        } else {
            userInfo.setUsername(edit_sign_username.getText().toString());
            userInfo.setPassword(edit_sign_password.getText().toString());
            DBManager.insertUser(this, userInfo);
            this.layout_login.setVisibility(View.VISIBLE);
            text_main_title.setText("登陆");
            edit_sign_username.setText("");
            edit_sign_password.setText("");
            this.layout_sign.setVisibility(View.GONE);
        }
    }
}
