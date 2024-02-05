package com.george.android.calendar.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "events")
public class Event {

    @PrimaryKey(autoGenerate = true)
    public long eventId;
    public long calendarId;
    public String nameEvent;
    public boolean isAllDay;
    public Date dateEvent;
    public Date startTimeEvent;
    public Date endTimeEvent;

    public Event(long calendarId, String nameEvent, boolean isAllDay, Date dateEvent, Date startTimeEvent, Date endTimeEvent) {
        this.calendarId = calendarId;
        this.nameEvent = nameEvent;
        this.isAllDay = isAllDay;
        this.dateEvent = dateEvent;
        if(isAllDay) {
            this.startTimeEvent = null;
            this.endTimeEvent = null;
            return;
        }
        this.startTimeEvent = startTimeEvent;
        this.endTimeEvent = endTimeEvent;
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

    public boolean isAllDay() {
        return isAllDay;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public Date getStartTimeEvent() {
        return startTimeEvent;
    }

    public Date getEndTimeEvent() {
        return endTimeEvent;
    }
}
