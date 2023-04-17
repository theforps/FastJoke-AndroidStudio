package com.example.fastjoke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button exitButton;
    private Button startButton;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.choose);
        exitButton = (Button) findViewById(R.id.exit);
        createButton = (Button) findViewById(R.id.create);

        startButton.setOnClickListener(y -> {
            setContentView(R.layout.activity_choose_category);
        });
        createButton.setOnClickListener(y -> {
            setContentView(R.layout.activity_create_joke);
        });
        exitButton.setOnClickListener(y -> {
            finish();
            System.exit(0);
        });
    }
}