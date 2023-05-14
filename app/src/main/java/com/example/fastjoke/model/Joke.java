package com.example.fastjoke.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "joke")
public class Joke {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String context;

    @ColumnInfo(name = "is_base")
    public boolean isBase;

    public String category;

    public String username;

    public String date;

    public Joke(int id, String context, boolean isBase, String category, String username, String date) {
        this.id = id;
        this.context = context;
        this.isBase = isBase;
        this.category = category;
        this.username = username;
        this.date = date;
    }

}
