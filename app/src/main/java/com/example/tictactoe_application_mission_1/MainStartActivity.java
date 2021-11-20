package com.example.tictactoe_application_mission_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainStartActivity extends AppCompatActivity {
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);


    }

    public void playBtn(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}