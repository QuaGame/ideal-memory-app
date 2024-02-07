package com.george.android.calendar.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.george.android.calendar.data.model.Calendar;


import java.util.List;

@Dao
public interface CalendarDao {

    @Insert
    long insert(Calendar calendar);

    @Query("UPDATE calendars SET nameCalendar = :nameCalendar WHERE calendars.calendarId = :calendarId")
    void updateCalendarById(String nameCalendar, long calendarId);

    @Query("DELETE FROM calendars WHERE calendars.calendarId = :calendarId")
    void deleteCalendarById(long calendarId);

    @Query("DELETE FROM events WHERE events.calendarId = :calendarId")
    void deleteAllEventsInCalendar(long calendarId);

    @Query("SELECT * FROM calendars WHERE calendars.calendarId = :calendarId")
    LiveData<Calendar> getCalendarById(long calendarId);

    @Query("SELECT * FROM calendars")
    LiveData<List<Calendar>> getAllCalendars();

}
