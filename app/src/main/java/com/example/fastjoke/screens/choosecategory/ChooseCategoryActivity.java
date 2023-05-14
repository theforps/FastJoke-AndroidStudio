package com.example.fastjoke.screens.choosecategory;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fastjoke.databinding.ActivityChooseCategoryBinding;

public class ChooseCategoryActivity extends AppCompatActivity {

    private ActivityChooseCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}
