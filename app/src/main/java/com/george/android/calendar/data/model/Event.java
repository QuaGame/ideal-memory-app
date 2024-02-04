package com.george.android.calendar.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events")
public class Event {

    @PrimaryKey(autoGenerate = true)
    public long eventId;

    public long calendarId;

    public String nameEvent;

    public Event(long calendarId, String nameEvent) {
        this.calendarId = calendarId;
        this.nameEvent = nameEvent;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getEventId() {
        return eventId;
    }

    public long getCalendarId() {
        return calendarId;
    }

    public String getNameEvent() {
        return nameEvent;
    }
}
