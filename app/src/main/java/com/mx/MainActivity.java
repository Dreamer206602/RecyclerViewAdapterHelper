package com.mx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jaredrummler.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {

    private MaterialSpinner spinnerFirstOnly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
