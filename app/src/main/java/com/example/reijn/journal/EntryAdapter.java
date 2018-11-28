package com.example.reijn.journal;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.Switch;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {

    public EntryAdapter(Context context, Cursor cursor){
        super(context,R.layout.entry_row,cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String title = cursor.getString(cursor.getColumnIndex("title"));
        String date = cursor.getString(cursor.getColumnIndex("timestamp"));
        String mood = cursor.getString(cursor.getColumnIndex("mood"));
        if(mood == null){
            mood = "sad";
        }
        ImageView mood1 = view.findViewById(R.id.imageView);
        System.out.println(mood);
        TextView titlevak = (TextView) view.findViewById(R.id.textView3);
        TextView datevak = (TextView) view.findViewById(R.id.textView5);
        TextView moodvak = (TextView) view.findViewById(R.id.textView9);

        switch (mood){
            case "sad": mood1.setImageResource(R.drawable.sad);
                break;
            case "sadder": mood1.setImageResource(R.drawable.sadder);
                break;
            case "smile": mood1.setImageResource(R.drawable.smile);
                break;
            case "dead": mood1.setImageResource(R.drawable.dead);
                break;
        }

        titlevak.setText(title);
        datevak.setText(date);
        moodvak.setText(mood);

    }
}
