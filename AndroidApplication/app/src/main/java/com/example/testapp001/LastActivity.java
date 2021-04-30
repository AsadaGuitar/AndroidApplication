package com.example.testapp001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LastActivity extends AppCompatActivity {

    private static TextView Header;
    private static TextView Main;
    private static Button Btn;
    private static Button Send;

    private static ArrayList<Integer> Incorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Intent intent = getIntent();
        int count = intent.getIntExtra("count", 0);
        Incorrect = intent.getIntegerArrayListExtra("list");

        Header = findViewById(R.id.header);
        Main = findViewById(R.id.main);
        Btn = findViewById(R.id.returnBtn);
        Send = findViewById(R.id.send);

        Header.setText("お疲れ様です");
        Main.setText("あなたの得点は" + count + "/10点です");
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<Incorrect.size(); i++){
                    System.out.println("LastActivity: " + Incorrect.get(i));
                }
                System.out.println("LastActivity Incorrect.Size() : " + Incorrect.size());
                finish();
            }
        });

    }

    public void BtnClick(View v){
        Incorrect.clear();
        finish();
    }

    public void SendClick(View v){
        Intent intent = new Intent(getApplication(), ReviewActivity.class);
        intent.putExtra("incorrect", Incorrect);
        startActivity(intent);
        finish();
    }
}
