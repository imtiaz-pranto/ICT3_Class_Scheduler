package com.imtiaz.ict3classscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.HashMap;
import java.util.Map;


public class Notice extends AppCompatActivity {
    LinearLayout noticeLayoutvar;
    TextView notice1,notice2,notice3, notice4, notice5, notice6, notice7, notice8, notice9, notice10;
    public FirebaseRemoteConfig firebaseRemoteConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        //Firebase
        notice1 = findViewById(R.id.notice1);
        notice2 = findViewById(R.id.notice2);
        notice3 = findViewById(R.id.notice3);
        notice4 = findViewById(R.id.notice4);
        notice5 = findViewById(R.id.notice5);
        notice6 = findViewById(R.id.notice6);
        notice7 = findViewById(R.id.notice7);
        notice8 = findViewById(R.id.notice8);

        //Init Firebase
        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder().build();
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings);

        //Init Default
        Map<String, Object> defaultdata = new HashMap<>();
        defaultdata.put("notice1", "Notice will be shown here");
        defaultdata.put("notice2", "Notice2 will be shown here");
        defaultdata.put("notice3", "Notice3 will be shown here");
        defaultdata.put("notice4", "Notice4 will be shown here");
        defaultdata.put("notice5", "Notice5 will be shown here");
        defaultdata.put("notice7", "Notice7 will be shown here");
        defaultdata.put("notice8", "Notice8 will be shown here");
        defaultdata.put("notice6", "Notice6 is here!");


        firebaseRemoteConfig.setDefaultsAsync(defaultdata);

//Fetch
        firebaseRemoteConfig.fetch(0);

        notice1.setText(firebaseRemoteConfig.getString("notice1"));
        notice2.setText(firebaseRemoteConfig.getString("notice2"));
        notice3.setText(firebaseRemoteConfig.getString("notice3"));
        notice4.setText(firebaseRemoteConfig.getString("notice4"));
        notice5.setText(firebaseRemoteConfig.getString("notice5"));
        notice6.setText(firebaseRemoteConfig.getString("notice6"));
        notice7.setText(firebaseRemoteConfig.getString("notice7"));
        notice8.setText(firebaseRemoteConfig.getString("notice8"));

        //notice1.setVisibility(firebaseRemoteConfig.getBoolean("notice3visiblity"));
        firebaseRemoteConfig.fetchAndActivate();

//SwipeAction
        noticeLayoutvar = findViewById(R.id.noticelayout);
        noticeLayoutvar.setOnTouchListener(new OnSwipeTouchListener(Notice.this) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                startActivity(new Intent(getApplicationContext()
                        , MainActivity.class));
                overridePendingTransition(0, 0);
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                startActivity(new Intent(getApplicationContext()
                        , Routine.class));
                overridePendingTransition(0, 0);
            }
        });

//navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.notice);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.notice:
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
                    case R.id.links:
                        startActivity(new Intent(getApplicationContext()
                                , Links.class));
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

    public void refresh(View view) {
        Toast.makeText(this, "Refreshed Noticeboard", Toast.LENGTH_SHORT).show();
//Fetch
        firebaseRemoteConfig.fetch(0);

        notice1.setText(firebaseRemoteConfig.getString("notice1"));
        notice2.setText(firebaseRemoteConfig.getString("notice2"));
        notice3.setText(firebaseRemoteConfig.getString("notice3"));
        notice4.setText(firebaseRemoteConfig.getString("notice4"));
        notice5.setText(firebaseRemoteConfig.getString("notice5"));
        notice6.setText(firebaseRemoteConfig.getString("notice6"));
        notice7.setText(firebaseRemoteConfig.getString("notice7"));
        notice8.setText(firebaseRemoteConfig.getString("notice8"));

        //notice1.setVisibility(firebaseRemoteConfig.getBoolean("notice3visiblity"));
        firebaseRemoteConfig.fetchAndActivate();
    }
}