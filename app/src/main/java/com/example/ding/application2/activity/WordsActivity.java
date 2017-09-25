package com.example.ding.application2.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.example.ding.application2.R;
import com.example.ding.application2.bean.WordInfo;
import com.example.ding.application2.bean.WordList;

import java.util.ArrayList;

public class WordsActivity extends BaseActivity implements View.OnClickListener {
    private TextView text_title;
    private TextView text_word;
    private TextView text_translation;
    private TextView text_line;

    private Button btn_notice;
    private Button btn_pass;

    private ImageView imageViewA;
    private ImageView imageViewB;
    private ImageView imageViewC;
    private ImageView imageViewD;

    private ImageView check_a_success;
    private ImageView check_b_success;
    private ImageView check_c_success;
    private ImageView check_d_success;


    private String[] selectArray = {"", "初中", "高中", "四级", "六级", "托福"};
    private ArrayList<WordInfo> dataList = new ArrayList<>();
    private int wordIndex = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        this.text_title = (TextView) findViewById(R.id.text_word_title);
        this.text_word = (TextView) findViewById(R.id.text_word);
        this.text_translation = (TextView) findViewById(R.id.text_translation);
        this.text_line = (TextView) findViewById(R.id.text_line);

        imageViewA = (ImageView) findViewById(R.id.image_a);
        imageViewB = (ImageView) findViewById(R.id.image_b);
        imageViewC = (ImageView) findViewById(R.id.image_c);
        imageViewD = (ImageView) findViewById(R.id.image_d);

        check_a_success = (ImageView) findViewById(R.id.image_a_success);
        check_b_success = (ImageView) findViewById(R.id.image_b_success);
        check_c_success = (ImageView) findViewById(R.id.image_c_success);
        check_d_success = (ImageView) findViewById(R.id.image_d_success);


        btn_notice = (Button) findViewById(R.id.btn_notice);
        btn_pass = (Button) findViewById(R.id.btn_pass);

        Intent intent = getIntent();
        int select = intent.getIntExtra("select", 1);
        text_title.setText(selectArray[select]);
        this.text_word.setText("first");

        btn_pass.setOnClickListener(this);
        btn_notice.setOnClickListener(this);
        imageViewA.setOnClickListener(this);
        imageViewB.setOnClickListener(this);
        imageViewC.setOnClickListener(this);
        imageViewD.setOnClickListener(this);

        setData(select);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_notice:
                this.text_line.setVisibility(View.VISIBLE);
                this.text_translation.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_pass:
                wordIndex++;
                hideAllCheckImage();
                setWord();
                break;
            case R.id.image_a:
                checkAnswer("A");
                break;
            case R.id.image_b:
                checkAnswer("B");
                break;
            case R.id.image_c:
                checkAnswer("C");
                break;
            case R.id.image_d:
                checkAnswer("D");
                break;
        }
    }

    private void checkAnswer(String answer) {
        WordInfo info = dataList.get(wordIndex);
        hideAllCheckImage();
        if (answer.equals(info.getAnswer())) {
            showSuccess(answer);
        } else {
            showFail(answer);
        }
    }

    private void showSuccess(String answer) {
        switch (answer) {
            case "A":
                Glide.with(this).load(R.mipmap.success).into(check_a_success);
                check_a_success.setVisibility(View.VISIBLE);
                break;
            case "B":
                Glide.with(this).load(R.mipmap.success).into(check_b_success);
                check_b_success.setVisibility(View.VISIBLE);
                break;
            case "C":
                Glide.with(this).load(R.mipmap.success).into(check_c_success);
                check_c_success.setVisibility(View.VISIBLE);
                break;
            case "D":
                Glide.with(this).load(R.mipmap.success).into(check_d_success);
                check_d_success.setVisibility(View.VISIBLE);
                break;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wordIndex++;
                hideAllCheckImage();
                setWord();
            }
        }, 1000);
    }

    private void showFail(String answer) {
        switch (answer) {
            case "A":
                check_a_success.setVisibility(View.VISIBLE);
                Glide.with(this).load(R.mipmap.failed).into(check_a_success);
                break;
            case "B":
                check_b_success.setVisibility(View.VISIBLE);
                Glide.with(this).load(R.mipmap.failed).into(check_b_success);
                break;
            case "C":
                check_c_success.setVisibility(View.VISIBLE);
                Glide.with(this).load(R.mipmap.failed).into(check_c_success);
                break;
            case "D":
                check_d_success.setVisibility(View.VISIBLE);
                Glide.with(this).load(R.mipmap.failed).into(check_d_success);
                break;
        }
    }


    private void hideAllCheckImage() {
        check_a_success.setVisibility(View.GONE);
        check_b_success.setVisibility(View.GONE);
        check_c_success.setVisibility(View.GONE);
        check_d_success.setVisibility(View.GONE);
    }

    private void setData(int select) {
        dataList = WordList.intence(this).getGrade(select);
        setWord();

    }

    private void setWord() {
        if (dataList.size() <= wordIndex) {
            wordIndex = 0;
        }
        this.text_line.setVisibility(View.GONE);
        this.text_translation.setVisibility(View.GONE);
        WordInfo wordInfo = dataList.get(wordIndex);
        text_word.setText(wordInfo.getWordName());
        text_translation.setText(wordInfo.getWordNotice());
        Glide.with(this).load(wordInfo.getImageA()).into(imageViewA);
        Glide.with(this).load(wordInfo.getImageB()).into(imageViewB);
        Glide.with(this).load(wordInfo.getImageC()).into(imageViewC);
        Glide.with(this).load(wordInfo.getImageD()).into(imageViewD);
    }
}
