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

import java.util.List;

public class ShowJokesActivity extends AppCompatActivity {

    private ActivityShowJokesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowJokesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String category = getIntent().getStringExtra(Category.key);
        FastJokeDao dao = FastJokeAppDatabase.getInstance(this).jokeDao();
        List<Joke> jokes = dao.getJokesByCategory(category);

        binding.rvJokeList.setAdapter(new JokeAdapter(this, jokes));
    }

}