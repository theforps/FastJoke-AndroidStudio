package com.example.fastjoke.util;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.fastjoke.repository.FastJokeDao;
import com.example.fastjoke.screens.createjoke.CreateJokeViewModel;

@RequiresApi(api = Build.VERSION_CODES.O)
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