package com.george.android.calendar.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "calendars")
public class Calendar {

    @PrimaryKey(autoGenerate = true)
    public long calendarId;

    public String nameCalendar;

    public Calendar(String nameCalendar) {
        this.nameCalendar = nameCalendar;
    }

    public void setCalendarId(long calendarId) {
        this.calendarId = calendarId;
    }

    public long getCalendarId() {
        return calendarId;
    }

    public String getNameCalendar() {
        return nameCalendar;
    }
}