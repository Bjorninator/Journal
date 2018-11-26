package com.example.reijn.journal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    public static EntryDatabase getInstance(Context context){
        if(instance == null){
         return instance = new EntryDatabase(context,"db",null, 1) ;
        }else {
            return instance;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String string = ("create table entries (_id INTEGER PRIMARY KEY, title TEXT, content TEXT, mood TEXT, timestamp TEXT)");
        db.execSQL(string);
        String testdata = ("INSERT INTO entries(_id, title, content, mood, timestamp) VALUES(1,'goededag', 'zeer goeie dag vandaag', 'super blij', 'geen idee')");
        db.execSQL(testdata);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String string = ("drop table entries");
        db.execSQL(string);
        onCreate(db);
    }

}
