package com.example.fastjoke.screens.showjokes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.fastjoke.R;
import com.example.fastjoke.databinding.ActivityShowJokesBinding;
import com.example.fastjoke.model.Category;
import com.example.fastjoke.model.Joke;
import com.example.fastjoke.repository.FastJokeAppDatabase;
import com.example.fastjoke.repository.FastJokeDao;
import com.example.fastjoke.screens.MainActivity;
import com.example.fastjoke.screens.choosecategory.ChooseCategoryActivity;

import java.util.List;

public class ShowJokesActivity extends AppCompatActivity {

    private ActivityShowJokesBinding binding;
    private JokeAdapter jokeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowJokesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String category = getIntent().getStringExtra(Category.key);
        FastJokeDao dao = FastJokeAppDatabase.getInstance(this).jokeDao();
        List<Joke> jokes = dao.getJokesByCategory(category);

        jokeAdapter = new JokeAdapter(this, jokes, dao);
        binding.rvJokeList.setAdapter(jokeAdapter);

        binding.btnBack.setOnClickListener(l -> {
            startActivity(new Intent(this, ChooseCategoryActivity.class));
        });
    }
}