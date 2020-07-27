package com.imtiaz.ict3classscheduler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Contacts extends AppCompatActivity {
    ListView namelist;
    String[] teachers={
            "SM Salim Reza (BUP)-ICT Project Management",
            "Dr. Md. Junayebur Rashid (DU) - Multimedia Comm.",
            "Dr. M. Shamim Kaiser (JU)-Info Theory and Coding",
            "Hasan Mahmud (IUT)-Web Engineering",
            "Zarin Tasnim - Batch Cordinator",
            "Md. Ehsanul Kabir - Section Officer",
            "Md. Faizur Rahman - Section Officer"
    };
    String[] numbers= {"01769021808", "01911701485","01711932323","01844056187","01769021809","01769021830","01769021816"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        namelist =(ListView) findViewById(R.id.idList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,teachers);
        namelist.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.contacts:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
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




        namelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(Contacts.this, "Phone number of " + teachers[i] + " copied to the clipboard!", Toast.LENGTH_SHORT).show();
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("Numbers",numbers[i]);
                    clipboard.setPrimaryClip(clip);
                }
            });




    }
}