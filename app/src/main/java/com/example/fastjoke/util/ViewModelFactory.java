package com.example.fastjoke.util;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.fastjoke.repository.FastJokeDao;
import com.example.fastjoke.screens.createjoke.CreateJokeViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final FastJokeDao dao;

    public ViewModelFactory(FastJokeDao dao) {
        this.dao = dao;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CreateJokeViewModel(dao);
    }
}
