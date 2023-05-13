package com.example.fastjoke.screens.createjoke;

import androidx.lifecycle.ViewModel;

import com.example.fastjoke.model.Joke;
import com.example.fastjoke.repository.FastJokeDao;

public class CreateJokeViewModel extends ViewModel {

    private FastJokeDao dao;

    public CreateJokeViewModel(FastJokeDao dao) {
        this.dao = dao;
    }

    public void createJoke(String context, String category, boolean isBase, String username) {
        Joke joke = new Joke(0, context, isBase, category, username);
        dao.insertJoke(joke);
    }

}
