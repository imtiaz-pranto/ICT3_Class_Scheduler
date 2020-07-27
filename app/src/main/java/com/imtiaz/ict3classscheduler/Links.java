package com.imtiaz.ict3classscheduler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Links extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
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

