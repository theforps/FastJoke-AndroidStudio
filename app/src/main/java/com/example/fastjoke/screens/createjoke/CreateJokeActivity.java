package com.example.fastjoke.screens.createjoke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fastjoke.R;
import com.example.fastjoke.databinding.ActivityCreateJokeBinding;
import com.example.fastjoke.repository.FastJokeAppDatabase;
import com.example.fastjoke.repository.FastJokeDao;
import com.example.fastjoke.screens.MainActivity;
import com.example.fastjoke.util.ViewModelFactory;

public class CreateJokeActivity extends AppCompatActivity {

    private ActivityCreateJokeBinding binding;
    private CreateJokeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateJokeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FastJokeDao dao = FastJokeAppDatabase.getInstance(this).jokeDao();
        viewModel = new ViewModelProvider(this, new ViewModelFactory(dao)).get(CreateJokeViewModel.class);


        binding.btnCreateJoke.setOnClickListener(l -> {
            createJoke();
            Toast.makeText(this, R.string.joke_created, Toast.LENGTH_SHORT).show();
            onMainActivity();
        });

    }

    private void createJoke() {
        String context = binding.etContext.getText().toString();
        String category = binding.etCategory.getText().toString();
        String username = binding.etUsername.getText().toString();

        viewModel.createJoke(context, category, false, username);
    }

    private void onMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }
}