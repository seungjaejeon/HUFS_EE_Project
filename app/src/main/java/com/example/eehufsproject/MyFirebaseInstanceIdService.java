package com.example.eehufsproject;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseInstanceIdService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token) {
        Log.d("MessagingService", "Refreshed token: " + token);

        // 서버에 토큰 등록 코드 작성
    }
}
