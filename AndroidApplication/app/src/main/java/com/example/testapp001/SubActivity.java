package com.example.testapp001;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.graphics.Color.*;


public class SubActivity extends AppCompatActivity{

    private static TextView countLabel;
    private static TextView questionLabel;
    private static ImageView quizImage;
    private static TypedArray typedArray;
    private static Drawable drawable;
    private static Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;

    private static ArrayList<Integer> Array;
    private static ArrayList<Integer> Incorrect = new ArrayList<Integer>();

    private static int LastQuiz = 9;
    private static int rightAnswerCount;
    private static int QuizCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.questionLabel);
        quizImage = findViewById(R.id.quizImage);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);

        typedArray = getResources().obtainTypedArray(R.array.noteImages);
        Array = setList(typedArray);

        setQuizImage();
        setNextQuiz();
    }

    public ArrayList<Integer> setList(TypedArray typedArray){
        Shuffle shuffle = new Shuffle(typedArray);
        ArrayList<Integer> list = shuffle.getList();
        return list;
    }

    public void setQuizImage(){
        int ary = Array.get(QuizCount);
        drawable = typedArray.getDrawable(ary);
        quizImage.setImageDrawable(drawable);
    }

    public void setNextQuiz(){
        int ary = Array.get(QuizCount);
        TextBox textBox = new TextBox(ary) {
            @Override
            public void setQuiz() {
                super.setQuiz();
            }

            @Override
            public void setAnswers() {
                super.setAnswers();
            }

            @Override
            public void setCorrect() {
                super.setCorrect();
            }
        };
        String QuizTxt  = textBox.getQuiz();
        String[] AnswerTxt = textBox.getAnswers();

        countLabel.setText("Q : " + (QuizCount+1));
        questionLabel.setText(QuizTxt);
        answerBtn1.setText(AnswerTxt[0]);
        answerBtn2.setText(AnswerTxt[1]);
        answerBtn3.setText(AnswerTxt[2]);
        answerBtn4.setText(AnswerTxt[3]);
    }

    public void checkAnswer(View v){

        Button answerBtn = findViewById(v.getId());
        String answerBtnTxt = answerBtn.getText().toString();

        int ary = Array.get(QuizCount);
        TextBox textBox = new TextBox(ary) {
            @Override
            public void setQuiz() {
                super.setQuiz();
            }

            @Override
            public void setAnswers() {
                super.setAnswers();
            }

            @Override
            public void setCorrect() {
                super.setCorrect();
            }
        };
        String Correct = textBox.getCorrect();

        if(answerBtnTxt.equals(Correct)){
            System.out.println("correct :" + ary);
            rightAnswerCount++;
        }else{
            System.out.println("incorrect : " + ary);
            Incorrect.add(ary);
        }
        if(QuizCount == LastQuiz){
            finishQuiz(rightAnswerCount);
            return;
        }
        QuizCount++;
        setNextQuiz();
        setQuizImage();
    }
    private void finishQuiz(int count){
        QuizCount = 0;
        rightAnswerCount = 0;

        finish();
        Intent intent = new Intent(getApplication(),LastActivity.class);
        intent.putExtra("count", count);
        intent.putExtra("list", Incorrect);
        startActivity(intent);
    }
}
