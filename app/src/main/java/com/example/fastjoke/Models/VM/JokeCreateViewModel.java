package com.example.fastjoke.Models.VM;

import androidx.lifecycle.ViewModel;

import com.example.fastjoke.Database.JokeDAO;
import com.example.fastjoke.Models.Jokes;

public class JokeCreateViewModel extends ViewModel {
    private JokeDAO dao;

    public JokeCreateViewModel(JokeDAO dao) {
        this.dao = dao;
    }

    public void createJoke(String Context,
                           String Category,
                           String Username) {
        Jokes joke = new Jokes(0, Context, Category, Username);
        dao.insert(joke);
    }

}
