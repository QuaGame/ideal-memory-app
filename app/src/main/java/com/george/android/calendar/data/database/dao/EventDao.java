package com.george.android.calendar.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.george.android.calendar.data.model.Event;

import java.util.List;

@Dao
public interface EventDao {

    @Insert
    long insert(Event event);

    @Update
    void updateEvent(Event event);

    @Query("DELETE FROM events WHERE events.eventId = :eventId")
    void deleteEventById(long eventId);

    @Query("SELECT * FROM events WHERE events.eventId = :eventId")
    LiveData<Event> getEventById(long eventId);

    @Query("SELECT * FROM events WHERE events.calendarId = :calendarId")
    LiveData<List<Event>> getEventsByCalendarId(long calendarId);

}
