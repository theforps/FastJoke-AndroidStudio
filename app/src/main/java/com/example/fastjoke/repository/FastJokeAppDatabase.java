package com.example.fastjoke.repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fastjoke.model.History;
import com.example.fastjoke.model.Joke;

@Database(
        entities = {Joke.class, History.class},
        version = 3,
        exportSchema = false
)
public abstract class FastJokeAppDatabase extends RoomDatabase {
    private static FastJokeAppDatabase database;

    public synchronized static FastJokeAppDatabase getInstance(Context context)
    {
        if (database == null)
        {
            String DATABASE_NAME = "FastJokeApp";
            database = Room.databaseBuilder(context.getApplicationContext(),
                            FastJokeAppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return database;
    }

    public abstract FastJokeDao jokeDao();
}
