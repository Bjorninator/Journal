package com.example.reijn.journal;

import java.io.Serializable;
import java.util.Timer;

public class JournalEntry implements Serializable {

    private  int id;
    private String title, content, mood;
    private Timer timestamp;

    public JournalEntry(int id, String title, String content, String mood, Timer timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getMood() {
        return mood;
    }

    public Timer getTimestamp() {
        return timestamp;
    }
}
