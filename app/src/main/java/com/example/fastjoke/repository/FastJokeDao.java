package com.example.fastjoke.repository;

import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fastjoke.model.Joke;

import java.util.List;

@Dao
public interface FastJokeDao {

    @Query("SELECT * FROM joke WHERE id = :id AND category = :category")
    Joke getJokeById(long id, String category);

    @Query("SELECT * FROM joke WHERE category = :category")
    List<Joke> getJokesByCategory(String category);

    @Insert(onConflict = REPLACE)
    void insertJoke(Joke joke);

    @Delete
    void deleteJoke(Joke joke);

}
