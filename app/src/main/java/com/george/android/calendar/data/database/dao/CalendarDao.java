package com.george.android.calendar.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.george.android.calendar.data.model.Calendar;


import java.util.List;

@Dao
public interface CalendarDao {

    @Insert
    long insert(Calendar calendar);



}
