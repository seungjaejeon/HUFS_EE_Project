package com.example.eehufsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    private Button realtimeButton;
    private Button savedVideoButton;
    private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
            String token = String.valueOf(firebaseMessaging.getToken());
            Log.d("IDService","device token : "+token);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        // Find buttons by their IDs
        realtimeButton = findViewById(R.id.realtime_button);
        savedVideoButton = findViewById(R.id.saved_button);
        settingsButton = findViewById(R.id.settings_button);

        // Set button click listeners to navigate to their corresponding pages
        realtimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LiveScreenActivity.class));
            }
        });

        savedVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SavedVideoActivity.class));
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }
}
