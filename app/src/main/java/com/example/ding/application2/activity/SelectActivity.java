package com.example.ding.application2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.ding.application2.R;
import com.example.ding.application2.bean.JsonData;
import com.example.ding.application2.bean.WordInfo;
import com.example.ding.application2.util.Utils;
import com.google.gson.Gson;

public class SelectActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_01;
    private Button btn_02;
    private Button btn_03;
    private Button btn_04;
    private Button btn_05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        btn_01 = (Button) findViewById(R.id.btn_select_01);
        btn_02 = (Button) findViewById(R.id.btn_select_02);
        btn_03 = (Button) findViewById(R.id.btn_select_03);
        btn_04 = (Button) findViewById(R.id.btn_select_04);
        btn_05 = (Button) findViewById(R.id.btn_select_05);

        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
        btn_04.setOnClickListener(this);
        btn_05.setOnClickListener(this);

        String result = Utils.intence().getWordJsonStr(this);
        JsonData data = new Gson().fromJson(result, JsonData.class);
        Log.d("TAG", "onCreate: ==============="+data.getData().length);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, WordsActivity.class);
        switch (view.getId()) {
            case R.id.btn_select_01:
                intent.putExtra("select", 1);
                startActivity(intent);
                break;
            case R.id.btn_select_02:
                intent.putExtra("select", 2);
                startActivity(intent);
                break;
            case R.id.btn_select_03:
                intent.putExtra("select", 3);
                startActivity(intent);
                break;
            case R.id.btn_select_04:
                intent.putExtra("select", 4);
                startActivity(intent);
                break;
            case R.id.btn_select_05:
                intent.putExtra("select", 5);
                startActivity(intent);
                break;

        }
    }
}
