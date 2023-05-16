package com.example.fastjoke.screens;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastjoke.databinding.ActivityMainBinding;
import com.example.fastjoke.screens.choosecategory.ChooseCategoryActivity;
import com.example.fastjoke.screens.createjoke.CreateJokeActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnChoose.setOnClickListener(l ->
                startActivity(new Intent(this, ChooseCategoryActivity.class))
        );

        binding.btnCreate.setOnClickListener(l ->
                startActivity(new Intent(this, CreateJokeActivity.class))
        );

        binding.btnExit.setOnClickListener(y -> {
            finish();
            System.exit(0);
        });
    }
}