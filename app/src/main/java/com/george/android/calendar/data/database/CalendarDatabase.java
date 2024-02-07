package com.george.android.calendar.data.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.george.android.calendar.data.database.dao.CalendarDao;
import com.george.android.calendar.data.database.dao.EventDao;
import com.george.android.calendar.data.model.Calendar;
import com.george.android.calendar.data.model.Event;
import com.george.android.calendar.utils.DateConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kotlinx.coroutines.scheduling.Task;

@Database(entities = {Calendar.class, Event.class}, version = 1)
@TypeConverters({DateConverter.class})
public abstract class CalendarDatabase extends RoomDatabase {

    private static CalendarDatabase instance;

    public abstract CalendarDao calendarDao();

    public abstract EventDao eventDao();

    public static synchronized CalendarDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            CalendarDatabase.class, "calendar_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            ExecutorService service = Executors.newSingleThreadExecutor();
            service.execute(() -> {

                instance.calendarDao().insert(new Calendar("CalendarName1"));
                instance.calendarDao().insert(new Calendar("CalendarName2"));
                instance.calendarDao().insert(new Calendar("CalendarName3"));
                instance.calendarDao().insert(new Calendar("CalendarName4"));
                instance.calendarDao().insert(new Calendar("CalendarName5"));
                instance.calendarDao().insert(new Calendar("CalendarName6"));

            });
        }
    };

}
