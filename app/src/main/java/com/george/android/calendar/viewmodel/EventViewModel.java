package com.george.android.calendar.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.george.android.calendar.data.model.Event;
import com.george.android.calendar.data.repository.EventRepository;

import java.util.List;

public class EventViewModel extends AndroidViewModel {

    private final EventRepository eventRepository;

    public EventViewModel(@NonNull Application application) {
        super(application);
        eventRepository = new EventRepository(application);
    }

    public long insert(Event event) {
        return eventRepository.insert(event);
    }

    public LiveData<List<Event>> getEventsByCalendarId(long calendarId) {
        return eventRepository.getEventsByCalendarId(calendarId);
    }

}
