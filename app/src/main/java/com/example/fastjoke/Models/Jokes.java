package com.example.fastjoke.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "jokes")
public class Jokes {

    public Jokes(Integer Id,
                 String Context,
                 String Category,
                 String Username) {
        this.Id = Id;
        this.Context = Context;
        this.Category = Category;
        this.Username = Username;
    }

    @PrimaryKey(autoGenerate = true)
    public int Id;
    @ColumnInfo(name = "context")
    public String Context;
    @ColumnInfo(name = "isBase")
    public boolean IsBase;
    @ColumnInfo(name = "category")
    public String Category;
    public String Username;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public boolean isBase() {
        return IsBase;
    }

    public void setBase(boolean base) {
        IsBase = base;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
