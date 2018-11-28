package com.example.reijn.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.DropBoxManager;
import android.support.annotation.Nullable;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    public static EntryDatabase getInstance(Context context){
        if(instance == null){
         return instance = new EntryDatabase(context,"com.example.reijn.journal",null, 1) ;
        }else {
            return instance;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String string = ("create table entries (_id INTEGER PRIMARY KEY, title TEXT, content TEXT, mood TEXT, timestamp TEXT)");
        db.execSQL(string);
        String testdata = ("INSERT INTO entries(_id, title, content, mood, timestamp) VALUES(3,'goededag', 'zeer goeie dag vandaag', 'smile', 'geen idee')");
        db.execSQL(testdata);
        String testdata1 = ("INSERT INTO entries(_id, title, content, mood, timestamp) VALUES(4,'goededag', 'zeer goeie dag vandaag', 'sad', 'geen idee')");
        db.execSQL(testdata1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String string = ("drop table entries");
        db.execSQL(string);
        onCreate(db);
    }
    public Cursor selectAll(){
        return getWritableDatabase().rawQuery("SELECT * FROM entries ",  null);
    }
    public void insert(JournalEntry entry){

        ContentValues values = new ContentValues();

        values.put("title", entry.getTitle());
        values.put("content", entry.getContent());
        values.put("mood", entry.getMood());
        values.put("timestamp", entry.getTimestamp());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert("entries", null, values);
        db.close();

        }

    public void delete(int ID){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from entries where _id='"+ID+"'");
        db.close();

    }
}
