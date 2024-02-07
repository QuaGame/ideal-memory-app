package com.george.android.calendar.ui.fragments.calendars;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.george.android.calendar.data.model.Calendar;
import com.george.android.calendar.databinding.FragmentCalendarsBinding;
import com.george.android.calendar.viewmodel.CalendarViewModel;

import java.util.List;

public class CalendarsFragment extends Fragment {

    private FragmentCalendarsBinding binding;
    public static final String TAG = CalendarsFragment.class.getName();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CalendarViewModel calendarViewModel = new ViewModelProvider(this).get(CalendarViewModel.class);

        binding = FragmentCalendarsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();





        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

