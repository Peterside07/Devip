package com.example.devip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Dashboardactivity extends AppCompatActivity {
    private Button logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardactivity);
        logOutButton = findViewById(R.id.dbd_btn_logout);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Dashboardactivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
        SharedPreferences preferences = getSharedPreferences("MYPREFF", MODE_PRIVATE);
        String display = preferences.getString("Display", "");

        TextView displayInfo = (TextView) findViewById(R.id.dbd_tv_brief_info);
        displayInfo.setText(display);


    }



}
