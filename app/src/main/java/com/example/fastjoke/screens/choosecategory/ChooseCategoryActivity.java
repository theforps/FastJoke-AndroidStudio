package com.example.fastjoke.screens.choosecategory;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fastjoke.databinding.ActivityChooseCategoryBinding;
import com.example.fastjoke.model.Category;
import com.example.fastjoke.screens.showjokes.ShowJokesActivity;

public class ChooseCategoryActivity extends AppCompatActivity {

    private ActivityChooseCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnFriend.setOnClickListener(l -> {
            onShowJokesActivity();
        });

    }

    private void onShowJokesActivity() {
        Intent intent = new Intent(this, ShowJokesActivity.class);
        intent.putExtra(Category.key, binding.btnFriend.getText().toString());
        startActivity(intent);
    }
}
