package com.example.tictactoe_application_mission_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity<buttons> extends AppCompatActivity {

    private boolean symbol = true; // x = true, o = false
    private int count = 0;
    boolean endGame = false;
    TextView turn;
    TextView p1;
    TextView p2;
    TextView p2_score;
    TextView p1_score;
    Button[][] buttons = new Button[3][3];
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //---------------------------------------//
        turn = findViewById(R.id.main_textTurn);
        p1 = findViewById(R.id.main_p1);
        p2 = findViewById(R.id.main_p2);
        p1_score = findViewById(R.id.main_score_p1);
        p2_score = findViewById(R.id.main_score_p2);
        restart = findViewById(R.id.main_restart);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "main_Bt" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
            }
        }

        buttons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func(buttons[0][0], turn);
            }
        });
        buttons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func(buttons[0][1], turn);
            }
        });
        buttons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func(buttons[0][2], turn);
            }
        });
        buttons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func(buttons[1][0], turn);
            }
        });
        buttons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func(buttons[1][1], turn);
            }
        });
        buttons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func(buttons[1][2], turn);
            }
        });
        buttons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func(buttons[2][0], turn);
            }
        });
        buttons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func(buttons[2][1], turn);
            }
        });
        buttons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func(buttons[2][2], turn);
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRestartScore();
                setRestart();
                count = 0;
                symbol = true;
                turn.setText("X Turn");
            }
        });
    }

    private void setRestartScore() {
        p1_score.setText("0");
        p2_score.setText("0");
    }

    private void setRestart() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }


    private void func(Button B, TextView T) {
        if (symbol) {
            B.setText("X");
            T.setText("O Turn");
        } else {
            B.setText("O");
            T.setText("X Turn");
        }
        if (count >= 5) {
            char result = checkWinner();
            if(result == 'X')
                turn.setText("X is the Winner!");
        }
        if (count == 8) {
            setRestart();
        }
        count++;
        symbol = !symbol;
    }

    private char checkWinner() {
        for (int i = 0; i < buttons.length; i++) {

            //Column
            if (buttons[0][i].getText().toString() =="X" && buttons[1][i].getText().toString() == "X" && buttons[2][i].getText().toString() == "X") {

                return 'X';
            }
            /*if (buttons[0][i] + buttons[1][i] + buttons[2][i] == 12) {
                System.out.println("Y is the winner!");
                return;
            }
            //Row
            if (buttons[i][0] + buttons[i][1] + buttons[i][2] == 3) {
                System.out.println("X is the winner!");
                return;
            }
            if (buttons[i][0] + buttons[i][1] + buttons[i][2] == 12) {
                System.out.println("Y is the winner!");
                return;
            }
            //Cross
        }
        if (buttons[0][0] + buttons[1][1] + buttons[2][2] == 3 || buttons[0][2] + buttons[1][1] + buttons[2][0] == 3) {
            System.out.println("X is the winner!");
            return;
        }
        if (buttons[0][0] + buttons[1][1] + buttons[2][2] == 12 || buttons[0][2] + buttons[1][1] + buttons[2][0] == 12) {
            System.out.println("Y is the winner!");
            return;
        } else {
            System.out.println("There is no winner yet..");

        }*/
    }
        return 'N';
}}