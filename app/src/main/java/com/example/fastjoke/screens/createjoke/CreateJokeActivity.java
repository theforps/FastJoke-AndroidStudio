package com.example.fastjoke.screens.createjoke;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.fastjoke.R;
import com.example.fastjoke.databinding.ActivityCreateJokeBinding;
import com.example.fastjoke.repository.FastJokeAppDatabase;
import com.example.fastjoke.repository.FastJokeDao;
import com.example.fastjoke.screens.MainActivity;
import com.example.fastjoke.util.ViewModelFactory;

import java.util.Objects;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CreateJokeActivity extends AppCompatActivity {

    private ActivityCreateJokeBinding binding;
    private CreateJokeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateJokeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpAutoCompleteTextView();

        FastJokeDao dao = FastJokeAppDatabase.getInstance(this).jokeDao();
        viewModel = new ViewModelProvider(this, new ViewModelFactory(dao)).get(CreateJokeViewModel.class);

        binding.btnCreateJoke.setOnClickListener(l -> {
            if(createJoke()) {
                Toast.makeText(this, R.string.joke_created, Toast.LENGTH_SHORT).show();

                startActivity(new Intent(this, MainActivity.class));
            }
            else {
                Toast.makeText(this, "Неправильные данные", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnBack.setOnClickListener(l -> {
            startActivity(new Intent(this, MainActivity.class));
        });

    }

    private boolean createJoke() {
        String context = binding.etContext.getText().toString();
        String category = binding.actCategory.getText().toString();
        String username = binding.etUsername.getText().toString();

        if (context.trim().equals("") || category.trim().equals("") || username.trim().equals(""))
        {
            return false;
        }

        viewModel.createJoke(context, category, false, username);
        return true;
    }

    private void setUpAutoCompleteTextView() {
        // TODO
        String[] categories = {"Дружба", "Время", "Имена", "Космос", "Магия", "Люди", "Погода", "Будущее"};
        ArrayAdapter<String> adapterItems = new ArrayAdapter<>(this, R.layout.category_item, categories);
        binding.actCategory.setAdapter(adapterItems);
        binding.actCategory.setOnItemClickListener((parent, view, position, id) -> {
            String item = adapterItems.getItem(position);
            Objects.requireNonNull(binding.tilCategory.getEditText()).setText(item);
        });
    }
}