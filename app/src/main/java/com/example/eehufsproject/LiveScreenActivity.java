package com.example.eehufsproject;

import static com.example.eehufsproject.R.*;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class LiveScreenActivity extends AppCompatActivity {

    private Button leftButton;
    private Button rightButton;
    private Socket socket;
    private static final int SERVERPORT = 8080;
    private static final String SERVER_IP = "192.168.0.86";
    private boolean isRunning = false; // flag to control the continuous movement of the motor
    private String direction = ""; // variable to store the direction of the motor movement

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_screen);

        String uri = "rtsp://192.168.1.123:8555/unicast";
        VideoView v = (VideoView) findViewById( R.id.video_View );
        v.setVideoURI( Uri.parse(uri) );
        //v.setMediaController( new MediaController( this ) );
        v.requestFocus();
        v.start();
        leftButton = findViewById(R.id.btn_left);
        rightButton = findViewById(R.id.btn_right);

        // create a thread that handles the socket connection and motor control
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(SERVER_IP, SERVERPORT);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    while (true) {
                        if (direction.equals("left")) {
                            out.println("rotate motor left");
                            isRunning=false;
                            direction="";
                        } else if (direction.equals("right")) {
                            out.println("rotate motor right");
                            isRunning=false;
                            direction="";
                        } else {
                            out.println("stop motor");
                        }
                        Thread.sleep(1000); // wait for 1 second before next movement
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    direction = "left";
                    isRunning = true;
                }
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    direction = "right";
                    isRunning = true;
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try{socket.close();}
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
