package com.example.reijn.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EntryDatabase db;
    EntryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = EntryDatabase.getInstance(getApplicationContext());

        adapter = new EntryAdapter(this, db.selectAll());
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener());
        listview.setOnItemLongClickListener(new OnItemLongClickListener());
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }
    private class OnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);
            String Mood = cursor.getString(cursor.getColumnIndex("mood"));
            String Title = cursor.getString(cursor.getColumnIndex("title"));
            String Content = cursor.getString(cursor.getColumnIndex("content"));
            String Timestamp = cursor.getString(cursor.getColumnIndex("timestamp"));
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("Title", Title);
            intent.putExtra("Mood", Mood);
            intent.putExtra("Content", Content);
            intent.putExtra("Timestamp", Timestamp);
            startActivity(intent);
        }
    }
    public void updateData(){
        Cursor second= db.selectAll();
        adapter.swapCursor(second);
    }

    public void onResume(){
        super.onResume();
    }

    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);
            int ID = cursor.getInt(cursor.getColumnIndex("_id"));
            db.delete(ID);

            updateData();
            return true;
        }
    }
}
