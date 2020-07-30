package com.imtiaz.ict3classscheduler;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView dayVar, dateVar, courseVar, course2Var, join1var;
    ConstraintLayout mainlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainlayout = findViewById(R.id.main);
        mainlayout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                startActivity(new Intent(getApplicationContext()
                        , Contacts.class));
                overridePendingTransition(0,0);
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                startActivity(new Intent(getApplicationContext()
                        , Notice.class));
                overridePendingTransition(0, 0);
            }
        });





 //Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.routine:
                        startActivity(new Intent(getApplicationContext()
                        , Routine.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.contacts:
                        startActivity(new Intent(getApplicationContext()
                                , Contacts.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notice:
                        startActivity(new Intent(getApplicationContext()
                                , Notice.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.links:
                        startActivity(new Intent(getApplicationContext()
                                , Links.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });





        LinearLayout layout2 = findViewById(R.id.courseLayout2);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        String[] splitDate = currentDate.split(",");
        dayVar = findViewById(R.id.day);
        dateVar= findViewById(R.id.date);
        dayVar.setText(splitDate[0]);
        dateVar.setText(splitDate[1]);
        courseVar = findViewById(R.id.course);
        course2Var = findViewById(R.id.course2);
        join1var = findViewById(R.id.join1);

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);

        switch(day) {
            case Calendar.SUNDAY:
                courseVar.setText("Course: Web Engineering (WE)\n" +"Lecturer: Hasan Mahmud (CSE, IUT)\n" + "Time : 9 - 10 AM\n" + "(Fill the form given in CLassroom)" );
                course2Var.setText("Course: Information Theory & Coding (ITC) \n" + "Lecturer: Dr. M. Shamim Kaiser (IIT, DU)\n"+ "Time : 10.15 - 11.15 AM");
                break;
            case Calendar.MONDAY:
                courseVar.setText("Course: ICT Project Management (IPM) \n" + "Lecturer: S. M. Shamim Reza (ICT, BUP)\n"+ "Time : 9 - 10 AM");
                course2Var.setText("Course: Web Engineering \n" +"Lecturer: Hasan Mahmud (CSE, IUT)\n" + "Time : 10.15 - 11.15 AM\n" + "(Fill the form given in CLassroom)");
                break;
            case Calendar.TUESDAY:
                courseVar.setText("Course: Multimedia Communication (MC) \n" + "Lecturer: Dr. Mohammad Junaebur Rashid (DU)\n"+ "Time :  3 PM\n" + "(Visit CLassroom for link and attendence)");
                layout2.setVisibility(View.INVISIBLE);
                break;
            case Calendar.WEDNESDAY:
                courseVar.setText("Course: Information Theory & Coding (ITC) \n" + "Lecturer: Dr. M. Shamim Kaiser (IIT, DU)\n"+ "Time : 9 - 10 AM");
                layout2.setVisibility(View.INVISIBLE);
                break;
            case Calendar.THURSDAY:
                courseVar.setText("Course: ICT Project Management \n" + "Lecturer: S. M. Shamim Reza (ICT, BUP)\n"+ "Time : 9 - 10 AM");
                course2Var.setText("Course: Multimedia Communication \b(MC)\b \n" + "Lecturer: Dr. Mohammad Junaebur Rashid (DU)\n"+ "Time :  3 PM\n" + "(Visit CLassroom for link and attendence)");
                break;
            case Calendar.FRIDAY:
                courseVar.setText("Weekend Chill Time!!!");
                layout2.setVisibility(View.INVISIBLE);
                join1var.setVisibility(View.GONE);
                break;
            case Calendar.SATURDAY:
                courseVar.setText("Weekend CHill Time!!!");
                layout2.setVisibility(View.INVISIBLE);
                join1var.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void join1(View view){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        switch(day) {
            case Calendar.SUNDAY:
                Intent joinSunIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://classroom.google.com/u/0/c/MTE0MTAzMzI4ODIx")); //hasanmahmud
                startActivity(joinSunIntent);
                ;
                break;
            case Calendar.MONDAY:
                Intent joinMonIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bdren.zoom.us/j/7341030298?pwd=am9MN3JhTEpBY2YvQ0tFVkx3MnV6UT09")); //ShamimReza
                startActivity(joinMonIntent);
                ;
                break;
            case Calendar.TUESDAY:
                Intent joinTuesIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://classroom.google.com/u/0/c/MTE1MTc3MTUyOTY3")); //junayebur
                startActivity(joinTuesIntent);
                break;
            case Calendar.WEDNESDAY:
                Intent joinWedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://us04web.zoom.us/j/3252488765")); //ShamimKaiser
                startActivity(joinWedIntent);;
                break;
            case Calendar.THURSDAY:
                Intent joinThursIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bdren.zoom.us/j/7341030298?pwd=am9MN3JhTEpBY2YvQ0tFVkx3MnV6UT09")); //shamimReza
                startActivity(joinThursIntent);;
                break;
        }
    }

    public void join2(View view){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        switch(day) {
            case Calendar.SUNDAY:
                Intent joinSunIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://us04web.zoom.us/j/3252488765")); //ShamimKKaiser
                startActivity(joinSunIntent);
                break;
            case Calendar.MONDAY:
                Intent joinMonIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://classroom.google.com/u/0/c/MTE0MTAzMzI4ODIx")); //hasanmahmud
                startActivity(joinMonIntent);
                break;
            case Calendar.THURSDAY:
                Intent joinThursIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://classroom.google.com/u/0/c/MTE1MTc3MTUyOTY3")); //Junayebur
                startActivity(joinThursIntent);;
                break;
        }
    }
    }