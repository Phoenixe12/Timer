package com.Timer.myprojet_timer;

public class Event {
    private String title;
    private String description;
    private String coverImage;

    public Event(){}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Event(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
