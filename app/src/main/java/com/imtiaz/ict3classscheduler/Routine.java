package com.imtiaz.ict3classscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Routine extends AppCompatActivity {
    ConstraintLayout routinelayoutvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

//swipe action
        routinelayoutvar= findViewById(R.id.routinelayout);
        routinelayoutvar.setOnTouchListener(new OnSwipeTouchListener(Routine.this) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                startActivity(new Intent(getApplicationContext()
                        , Notice.class));
                overridePendingTransition(0,0);
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                startActivity(new Intent(getApplicationContext()
                        , Links.class));
                overridePendingTransition(0, 0);
            }
        });


//navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.routine  );
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.routine:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.contacts:
                        startActivity(new Intent(getApplicationContext()
                                , Contacts.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.notice:
                        startActivity(new Intent(getApplicationContext()
                                , Notice.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.links:
                        startActivity(new Intent(getApplicationContext()
                                , Links.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}