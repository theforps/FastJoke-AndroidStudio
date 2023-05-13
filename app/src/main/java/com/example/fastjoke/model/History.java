package com.example.fastjoke.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "history",
        foreignKeys = {
                @ForeignKey(
                        entity = Joke.class,
                        parentColumns = "id",
                        childColumns = "joke_id",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }
)
public class History {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "joke_id")
    public int jokeId;
    public String date;
    public String username;

}
