package com.example.fastjoke.screens.createjoke;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;

import com.example.fastjoke.model.Joke;
import com.example.fastjoke.repository.FastJokeDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CreateJokeViewModel extends ViewModel {

    private FastJokeDao dao;

    public CreateJokeViewModel(FastJokeDao dao) {
        this.dao = dao;
    }

    public void createJoke(String context, String category, boolean isBase, String username) {
        Joke joke = new Joke(0, context, isBase, category, username, getDate());
        dao.insertJoke(joke);
    }

    // return the current date
    private String getDate() {
        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd")
                .format(LocalDate.now());
    }

}
