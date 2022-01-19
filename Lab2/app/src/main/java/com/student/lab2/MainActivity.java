package com.student.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.student.lab2.ui.input.InputFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, InputFragment.newInstance())
                    .commitNow();
        }
    }
}