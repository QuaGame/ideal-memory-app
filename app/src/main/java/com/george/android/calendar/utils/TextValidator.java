package com.george.android.calendar.utils;

import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class TextValidator {

    public static boolean validateText(String text, TextInputLayout textInputLayout){

        Objects.requireNonNull(textInputLayout.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textInputLayout.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        if (text.isEmpty()) {
            textInputLayout.setError("Это поле не может быть пустым");
            return false;
        } else {
            textInputLayout.setError(null);
            return true;
        }

    }

}
