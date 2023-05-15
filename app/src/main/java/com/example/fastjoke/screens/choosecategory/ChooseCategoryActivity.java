package com.example.fastjoke.screens.choosecategory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fastjoke.databinding.ActivityChooseCategoryBinding;
import com.example.fastjoke.model.Category;
import com.example.fastjoke.screens.MainActivity;
import com.example.fastjoke.screens.showjokes.ShowJokesActivity;

public class ChooseCategoryActivity extends AppCompatActivity {

    private ActivityChooseCategoryBinding binding;
    private Button chooseCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(l -> {
            startActivity(new Intent(this, MainActivity.class));
        });

    }

    public void choose(View view) {
        chooseCategory = (Button) view;

        Intent intent = new Intent(this, ShowJokesActivity.class);
        intent.putExtra(Category.key, chooseCategory.getText().toString());
        startActivity(intent);
    }
}
