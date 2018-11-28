package com.example.reijn.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String Title = (String) intent.getSerializableExtra("Title");
        String Mood = (String) intent.getSerializableExtra("Mood");
        String Content = (String) intent.getSerializableExtra("Content");
        String Timestamp = (String) intent.getSerializableExtra("Timestamp");
        TextView title  = (TextView) findViewById(R.id.textView4);
        TextView mood = (TextView) findViewById(R.id.textView7);
        TextView content = (TextView) findViewById(R.id.textView6);
        TextView timestamp = (TextView) findViewById(R.id.textView8);

        title.setText(Title);
        mood.setText(" " + Mood);
        content.setText(Content);
        timestamp.setText(Timestamp);
    }
}
