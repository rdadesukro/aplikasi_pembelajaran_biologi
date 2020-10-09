package goid.kotajambi.aplikasi_pembelajaran_biologi.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import goid.kotajambi.aplikasi_pembelajaran_biologi.R;

public class menu_quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_quiz);
        getSupportActionBar().hide();
    }
}