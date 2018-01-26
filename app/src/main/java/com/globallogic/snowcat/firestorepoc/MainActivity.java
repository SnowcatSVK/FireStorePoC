package com.globallogic.snowcat.firestorepoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new CreateUserFragment()).commit();
    }
}
