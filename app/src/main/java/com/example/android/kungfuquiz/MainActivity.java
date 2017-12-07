package com.example.android.kungfuquiz;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void submitScore (View view){
    String finalScore = "";
    int score = calculateScore();
    if (score == 0) {
        finalScore = "\n Your score is : " + score + "/6.Better luck next time!";
    }
    if (score == 1) {
        finalScore = "\n score is : " + score + "/6.That´s an improvement!";
        }
    if (score == 2) {
        finalScore = "\n score is : " + score + "/6.Keep going!Don´t stop.";
    }
    if (score == 3) {
        finalScore = "\n score is : " + score + "/6.Halfway there!";
    }
    if (score == 4) {
        finalScore = "\n score is : " + score + "/6.Almost got it...";
    }
    if (score == 5) {
        finalScore = "\n score is : " + score + "/6.Just one more!";
    }
    if (score == 6) {
        finalScore = "\n score is : " + score + "/6.Yay!You nailed every one!";
    }
    Toast toast = Toast.makeText(getApplicationContext(), finalScore, Toast.LENGTH_SHORT);
    toast.show();
    }



    public int calculateScore() {
        int score = 0;
        RadioButton chineseAnswer = (RadioButton) findViewById(R.id.chinese_answer);
        if (chineseAnswer.isChecked()) {
            score = score + 1;
        }
        CheckBox wushuAnswer = (CheckBox) findViewById(R.id.wushu_answer);
        CheckBox shaolinAnswer = (CheckBox) findViewById(R.id.shaolin_answer);
        if (wushuAnswer.isChecked() && shaolinAnswer.isChecked()) {
            score = score + 1;
        }
        RadioButton youngForestAnswer = (RadioButton) findViewById(R.id.young_forest_answer);
        if (youngForestAnswer.isChecked()) {
            score = score + 1;

        }
        RadioButton fiveAnswer = (RadioButton) findViewById(R.id.five_answer);
        if (fiveAnswer.isChecked()) {
            score = score + 1;

        }
        EditText yinyananswer = (EditText) findViewById(R.id.yinyang_answer);
        String yinanswer = yinyananswer.getText().toString();
        if (yinanswer.contains("Dark") && yinanswer.contains("and") && yinanswer.contains("Bright") | yinanswer.contains("Negative") && yinanswer.contains("and") && yinanswer.contains("Positive")) {
            score = score + 1;
        }
        EditText kungfu = (EditText) findViewById(R.id.kungfumeaning);
        String kungfumeaning = kungfu.getText().toString();
        if (kungfumeaning.contains("Hard") && kungfumeaning.contains("Work")) {
            score = score + 1;
        }
        return score;
    }

    public void resetAnswers(View v) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}