package com.george.android.calendar.data.repository;

import android.app.Application;

import com.george.android.calendar.data.database.dao.CalendarDao;
import com.george.android.calendar.data.database.CalendarDatabase;
import com.george.android.calendar.data.model.Calendar;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalendarRepository {

    private final CalendarDao calendarDao;
    public static final String TAG = CalendarRepository.class.getName();
    final ExecutorService service = Executors.newCachedThreadPool();

    public CalendarRepository(Application application) {
        CalendarDatabase calendarDatabase = CalendarDatabase.getInstance(application.getApplicationContext());
        calendarDao = calendarDatabase.calendarDao();
    }

    public long insert(Calendar calendar) {
        Callable<Long> insertCallable = () -> calendarDao.insert(calendar);
        long calendarId;

        Future<Long> future = service.submit(insertCallable);
        try {
            calendarId = future.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return calendarId;
    }


}
