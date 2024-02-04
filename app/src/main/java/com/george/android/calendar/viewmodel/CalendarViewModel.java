package com.george.android.calendar.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.george.android.calendar.data.model.Calendar;
import com.george.android.calendar.data.repository.CalendarRepository;

public class CalendarViewModel extends AndroidViewModel {

    private final CalendarRepository calendarRepository;

    public CalendarViewModel(@NonNull Application application) {
        super(application);
        calendarRepository = new CalendarRepository(application);
    }

    public long insert(Calendar calendar) {
        return calendarRepository.insert(calendar);
    }



}
