package com.example.fastjoke.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.sql.Date;

@Entity(tableName = "history", foreignKeys = {
        @ForeignKey(entity = Jokes.class,
                parentColumns = "Id",
                childColumns = "jokeId",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        )
})
public class History {

    @PrimaryKey(autoGenerate = true)
    public int Id;
    @ColumnInfo(name = "jokeId")
    public int JokeId;
    @ColumnInfo(name = "date")
    public String Date;
    @ColumnInfo(name = "username")
    public String Username;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getJokeId() {
        return JokeId;
    }

    public void setJokeId(int jokeId) {
        JokeId = jokeId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
