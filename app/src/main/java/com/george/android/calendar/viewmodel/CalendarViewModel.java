package com.george.android.calendar.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.george.android.calendar.data.model.Calendar;
import com.george.android.calendar.data.repository.CalendarRepository;

import java.util.List;

public class CalendarViewModel extends AndroidViewModel {

    private final CalendarRepository calendarRepository;

    public CalendarViewModel(@NonNull Application application) {
        super(application);
        calendarRepository = new CalendarRepository(application);
    }

    public long insert(Calendar calendar) {
        return calendarRepository.insert(calendar);
    }

    public void updateCalendarById(String nameCalendar, long calendarId) {
        calendarRepository.updateCalendarById(nameCalendar, calendarId);
    }

    public void deleteCalendarById(long calendarId) {
        calendarRepository.deleteCalendarById(calendarId);
    }

    public LiveData<Calendar> getCalendarById(long calendarId) {
        return calendarRepository.getCalendarById(calendarId);
    }

    public LiveData<List<Calendar>> getAllCalendars() {
        return calendarRepository.getAllCalendars();
    }

}
