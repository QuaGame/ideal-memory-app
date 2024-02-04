package com.george.android.calendar.data.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.george.android.calendar.data.database.CalendarDatabase;
import com.george.android.calendar.data.database.dao.EventDao;
import com.george.android.calendar.data.model.Event;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EventRepository {

    private final EventDao eventDao;
    final ExecutorService service = Executors.newSingleThreadExecutor();

    public static final String TAG = EventRepository.class.getName();

    public EventRepository(Application application) {
        CalendarDatabase calendarDatabase = CalendarDatabase.getInstance(application.getApplicationContext());
        eventDao = calendarDatabase.eventDao();
    }

    public long insert(Event event) {
        Callable<Long> insertCallable = () -> eventDao.insert(event);
        long eventId;

        Future<Long> longFuture = service.submit(insertCallable);
        try {
            eventId = longFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return eventId;
    }

    public LiveData<List<Event>> getEventsByCalendarId(long calendarId) {
        MutableLiveData<List<Event>> eventLiveData = new MutableLiveData<>();

        service.execute(() -> eventLiveData.postValue(eventDao.getEventsByCalendarId(calendarId)));

        return eventLiveData;
    }


}
