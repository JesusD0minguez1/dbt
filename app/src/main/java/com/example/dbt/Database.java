package com.example.dbt;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper
{
    public Database(Context context){ super(context, DATABASE_NAME, null,1);}
    //Database name and Table Names
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "LeaderBoard.db";
    private static final String LEADERBOARD = "LeaderBoard";
    //Columns names for PlayerInformation
    private static final String LEADER_ID = "LeaderID"; //Primary key
    //column names for Type Table
    private static final String User_Name = "Username";
    private static final String SCORE = "Score";
    private static final String GAME_NAME = "Name of Game";
    @Override
    //creates the user database
    public void onCreate(SQLiteDatabase db) {
        //CREATE PLAYER INFORMATION TABLE
        String CREATE_PLAYER_TABLE = "CREATE TABLE " + LEADERBOARD + "(" + LEADER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ User_Name + " TEXT, " + GAME_NAME  +" TEXT, "+ SCORE + " INTEGER);";
        db.execSQL(CREATE_PLAYER_TABLE);

    }

    @Override
    //Runs when database is changed and updates to newest version
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + LEADERBOARD);
        onCreate(db);
    }

    public int addNewEntry(String userName, String type, int score)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User_Name, userName);
        //Inserts table columns
        long id = 1;
        try { id = db.insertOrThrow(LEADERBOARD, null, values); }
        catch (Exception e) { e.printStackTrace(); }
        //closes database connection
        db.close();
        return (int)id;
    }

    public ArrayList<Status> readData()
    {
        ArrayList<Status> records = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String qString = ("SELECT * FROM " + LEADERBOARD + " order by Username ");
        Cursor cursor = db.rawQuery(qString, null);
        while(cursor.moveToFirst())
        {
            String userName = cursor.getString(1);
            String typeGame = cursor.getString(2);
            int scrScore = cursor.getInt(3);
            String score = String.valueOf(scrScore);
            Status status = new Status(userName,typeGame,score);
            records.add(status);
        }
        db.close();
        cursor.close();
        return records;
    }

}