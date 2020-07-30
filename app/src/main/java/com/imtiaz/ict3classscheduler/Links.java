package com.imtiaz.ict3classscheduler;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Links extends AppCompatActivity {

    ConstraintLayout linklayoutvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        linklayoutvar = findViewById(R.id.linklayout);

        //swipe action
        linklayoutvar.setOnTouchListener(new OnSwipeTouchListener(Links.this) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                startActivity(new Intent(getApplicationContext()
                        , Routine.class));
                overridePendingTransition(0,0);
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                startActivity(new Intent(getApplicationContext()
                        , Contacts.class));
                overridePendingTransition(0, 0);
            }
        });

        //Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.links);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.links:
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
                    case R.id.routine:
                        startActivity(new Intent(getApplicationContext()
                                , Routine.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }




//Links
        public void ucam(View view){
            Intent ucamintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ucam.bup.edu.bd"));
            startActivity(ucamintent);
        }

        public void files(View view){
            Intent filesintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/172NOuiBFpyxZgJzzHUdqtCtTbX5wAWRM?usp=sharing"));
            startActivity(filesintent);
        }

        public void notes(View view){
            Intent notesintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1eU1kdEOBCDKLBbXaPy8oNKTYECut9LRf?usp=sharing"));
            startActivity(notesintent);
        }
    }

