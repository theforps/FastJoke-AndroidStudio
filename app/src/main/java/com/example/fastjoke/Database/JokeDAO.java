package com.example.fastjoke.Database;

import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fastjoke.Models.History;
import com.example.fastjoke.Models.Jokes;
import com.example.fastjoke.Models.VM.VMJoke;

@Dao
public interface JokeDAO {
    @Query("SELECT * FROM Jokes WHERE id = :id AND category = :category")
    Jokes getById(long id, String category);

    @Insert(onConflict = REPLACE)
    void insert(Jokes entity);

    @Delete
    void delete(Jokes entity);

}
