package com.daniel.wordit_pro.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "statistics")
public class Statistics implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "games_played")
    private int games_played = 0;

    @ColumnInfo(name = "is_new")
    private boolean is_new = false;

    @ColumnInfo(name = "games_won")
    private int games_won = 0;

    @ColumnInfo(name = "row_num1")
    private int row_num1 = 0;

    @ColumnInfo(name = "row_num2")
    private int row_num2 = 0;

    @ColumnInfo(name = "row_num3")
    private int row_num3 = 0;

    @ColumnInfo(name = "row_num4")
    private int row_num4 = 0;

    @ColumnInfo(name = "row_num5")
    private int row_num5 = 0;

    @ColumnInfo(name = "row_num6")
    private int row_num6 = 0;

    @ColumnInfo(name = "row_num7")
    private int row_num7 = 0;

    public int getGames_won() {
        return games_won;
    }

    public void setGames_won(int games_won) {
        this.games_won = games_won;
    }

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public int getRow_num1() {
        return row_num1;
    }

    public int getRow_num2() {
        return row_num2;
    }

    public int getRow_num3() {
        return row_num3;
    }

    public int getRow_num4() {
        return row_num4;
    }

    public int getRow_num5() {
        return row_num5;
    }

    public int getRow_num6() {
        return row_num6;
    }

    public int getRow_num7() {
        return row_num7;
    }

    public void setRow_num1(int row_num1) {
        this.row_num1 = row_num1;
    }

    public void setRow_num2(int row_num2) {
        this.row_num2 = row_num2;
    }

    public void setRow_num3(int row_num3) {
        this.row_num3 = row_num3;
    }

    public void setRow_num4(int row_num4) {
        this.row_num4 = row_num4;
    }

    public void setRow_num5(int row_num5) {
        this.row_num5 = row_num5;
    }

    public void setRow_num6(int row_num6) {
        this.row_num6 = row_num6;
    }

    public void setRow_num7(int row_num7) {
        this.row_num7 = row_num7;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_new() {
        return is_new;
    }

    public void setIs_new(boolean is_new) {
        this.is_new = is_new;
    }
}
