package com.george.android.calendar.ui.fragments.calendars;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CallendarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CallendarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calendars fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}