package com.george.android.calendar.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.george.android.calendar.data.model.Calendar;
import com.george.android.calendar.data.model.Event;
import com.george.android.calendar.data.repository.CalendarRepository;
import com.george.android.calendar.data.repository.EventRepository;
import com.george.android.calendar.databinding.ActivityMainBinding;
import com.george.android.calendar.viewmodel.EventViewModel;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }


}