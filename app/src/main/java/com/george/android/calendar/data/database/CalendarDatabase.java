package com.george.android.calendar.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.george.android.calendar.data.database.dao.CalendarDao;
import com.george.android.calendar.data.database.dao.EventDao;
import com.george.android.calendar.data.model.Calendar;
import com.george.android.calendar.data.model.Event;
import com.george.android.calendar.utils.DateConverter;

@Database(entities = {Calendar.class, Event.class}, version = 1)
@TypeConverters({DateConverter.class})
public abstract class CalendarDatabase extends RoomDatabase {

    private static CalendarDatabase instance;
    public abstract CalendarDao calendarDao();
    public abstract EventDao eventDao();
    public static synchronized CalendarDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CalendarDatabase.class, "calendar_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
