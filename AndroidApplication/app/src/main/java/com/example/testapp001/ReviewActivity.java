package com.example.testapp001;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    ArrayList<Integer> Incorrect;
    ArrayList<Button> ButtonList = new ArrayList<Button>();

    private static Drawable drawable;
    private static TypedArray typedArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(scrollView);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        scrollView.addView(linearLayout);

        Intent intent = getIntent();
        Incorrect = intent.getIntegerArrayListExtra("incorrect");

        float dp = getResources().getDisplayMetrics().density;

        int Width = (int)(195 * dp);
        int Height = (int)(130 * dp);
        LinearLayout.LayoutParams Params = new LinearLayout.LayoutParams(
                Width, Height);
        typedArray = getResources().obtainTypedArray(R.array.noteImages);

        for (int i=0; i<Incorrect.size(); i++){

            int ary = Incorrect.get(i);

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(Params);
            drawable = typedArray.getDrawable(ary);
            imageView.setImageDrawable(drawable);

            TextView textView = new TextView(this);
            textView.setLayoutParams(Params);
            int textSize = (int)(8 * dp);
            textView.setTextSize(textSize);
            int margin = (int)(5 * dp);

            textView.setGravity(Gravity.CENTER);
            TextBox textBox = new TextBox(ary);
            String correct = textBox.getCorrect();
            textView.setText("答え : " + correct);

            layout.addView(imageView);
            layout.addView(textView);
            linearLayout.addView(layout);
        }

    }
}
