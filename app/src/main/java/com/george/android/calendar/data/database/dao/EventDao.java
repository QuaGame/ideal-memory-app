package com.george.android.calendar.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.george.android.calendar.data.model.Event;

import java.util.List;

@Dao
public interface EventDao {

    @Insert
    long insert(Event event);

    @Query("SELECT * FROM events WHERE events.calendarId = :calendarId")
    List<Event> getEventsByCalendarId(long calendarId);

}
