package com.example.eehufsproject;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseInstanceIdService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token) {
        Log.d("MessagingService", "Refreshed token: " + token);

        // 서버에 토큰 등록 코드 작성
        sendRegistrationToServer(token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // 메시지 수신 및 처리 코드 작성
    }

    private void sendRegistrationToServer(String token){
        // 서버에 토큰 등록 코드 작성
    }
}
