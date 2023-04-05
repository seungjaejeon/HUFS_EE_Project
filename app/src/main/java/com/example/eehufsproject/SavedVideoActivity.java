package com.example.eehufsproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SavedVideoActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> savedVideosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_video);

        // get a reference to the list view
        listView = findViewById(R.id.video_view);

        // create an adapter for the list view
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, savedVideosList);

        // set the adapter on the list view
        listView.setAdapter(adapter);

        // add some sample saved videos to the list
        savedVideosList.add("Video 1");
        savedVideosList.add("Video 2");
        savedVideosList.add("Video 3");

        // set a click listener on the list view items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // handle clicking on a saved video item
                String selectedVideo = savedVideosList.get(position);
                Toast.makeText(SavedVideoActivity.this, "Selected video: " + selectedVideo, Toast.LENGTH_SHORT).show();

                // TODO: launch the video playback activity
            }
        });
    }
}
