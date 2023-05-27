package com.example.eehufsproject;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.FileDownloadTask;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.example.eehufsproject.MyFirebaseMessagingService;

import com.google.firebase.messaging.FirebaseMessaging;


public class MainActivity extends AppCompatActivity {

    private Button realtimeButton;
    private Button savedVideoButton;
    private Button settingsButton;

//    private void downloadPhoto() throws IOException {
//        FirebaseStorage storage = FirebaseStorage.getInstance();
//        StorageReference storageRef = storage.getReference();
//        StorageReference fileRef = storageRef.child("images/photo.jpg");
//        File localFile = File.createTempFile("temp", "jpg");
//
//        fileRef.getFile(localFile)
//                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                        // 다운로드 성공 시 처리할 작업
//                        // 로컬 파일(localFile)에 다운로드된 사진이 저장됩니다.
//                        // 예를 들어, 이미지뷰(ImageView)에 사진을 설정할 수 있습니다.
//                        ImageView imageView = findViewById(R.id.imageView);
//                        Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                        imageView.setImageBitmap(bitmap);
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // 다운로드 실패 시 처리할 작업
//                    }
//                });
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent fcm = new Intent(getApplicationContext(), MyFirebaseMessagingService.class);
        startService(fcm);
//        try {
//            FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
//            String token = String.valueOf(firebaseMessaging.getToken());
//            Log.d("IDService","device token : "+token);
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
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
