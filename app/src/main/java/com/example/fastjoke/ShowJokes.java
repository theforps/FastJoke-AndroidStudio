package com.example.fastjoke;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.fastjoke.Database.AppDb;
import com.example.fastjoke.Models.Jokes;

public class ShowJokes extends AppCompatActivity {

    private AppDb database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jokes);

        Log.d("fr", database.toString());
    }
}