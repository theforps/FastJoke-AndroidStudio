package com.example.fastjoke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fastjoke.Database.AppDb;

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
            startActivity(new Intent(MainActivity.this, ChooseCategory.class));
        });
        createButton.setOnClickListener(y -> {
            startActivity(new Intent(MainActivity.this, ChooseCategory.class));
        });
        exitButton.setOnClickListener(y -> {
            finish();
            System.exit(0);
        });
    }
}