package com.example.fastjoke.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fastjoke.Models.History;
import com.example.fastjoke.Models.Jokes;

@Database(entities = {Jokes.class, History.class}, version = 1, exportSchema = false)
public abstract class AppDb extends RoomDatabase {
    private static AppDb database;
    private static String DATABASE_NAME = "FastJokeApp";

    public synchronized static AppDb getInstance(Context context)
    {
        if (database == null)
        {
            database = Room.databaseBuilder(context.getApplicationContext(),
                            AppDb.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return database;
    }

    public abstract JokeDAO jokeDAO();
}
