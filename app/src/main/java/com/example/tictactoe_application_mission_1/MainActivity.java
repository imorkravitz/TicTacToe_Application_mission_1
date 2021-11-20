package com.example.tictactoe_application_mission_1;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<buttons> extends AppCompatActivity {

    private boolean symbol = true; // x = true, o = false
    private int count = 0;
    private Integer p1Num =0;
    private Integer p2Num =0;
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
        //---------------------------------------//

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
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                setRestartScore();
                setRestart();
                count = 0;
                symbol = true;
                turn.setText("X You Start!");
                p1Num = 0;
                p2Num = 0;
            }
        });
    }

    private void setRestartScore() {
        p1_score.setText("0");
        p1_score.setTextColor(Color.GRAY);
        p2_score.setText("0");
        p2_score.setTextColor(Color.GRAY);
    }

    private void setRestart() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setBackgroundResource(R.drawable.empty);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void func(Button B, TextView T) {
        if (symbol) {
            B.setTextColor(Color.RED);
            B.setText("X");
            B.setBackgroundResource(R.drawable.pic2);
            T.setText("O Turn");
        } else {
            B.setTextColor(Color.BLUE);
            B.setText("O");
            B.setBackgroundResource(R.drawable.pic1);
            T.setText("X Turn");
        }
        if (count > 3) {
            char result = checkWinner();
            if(result == 'X') {
                turn.setText("X Is The Winner!");
                Toast.makeText(this,"X is the Winner",Toast.LENGTH_SHORT).show();
                setRestart();
                count = 0;
                p1Num++;
                p1_score.setText(p1Num.toString());
                p1_score.setTextColor(Color.RED);
                symbol = false;
            }

            if(result == 'O') {
                turn.setText("O Is The Winner!");
                Toast.makeText(this,"O is the Winner",Toast.LENGTH_SHORT).show();
                setRestart();
                count = 0;
                p2Num++;
                p2_score.setText(p2Num.toString());
                p2_score.setTextColor(Color.BLUE);
                symbol = true;
            }
        }
        if (count == 9) {
            setRestart();
        }
        count++;
        symbol = !symbol;
    }

    private char checkWinner() {
        for (int i = 0; i < buttons.length; i++) {

            //Column
            if (buttons[0][i].getText().toString().equals("X") && buttons[1][i].getText().toString().equals("X") && buttons[2][i].getText().toString() == "X") {
                return 'X';
            }
            if (buttons[0][i].getText().toString().equals("O") && buttons[1][i].getText().toString().equals("O") && buttons[2][i].getText().toString() == "O") {
                return 'O';
            }
            //Row
            if (buttons[i][0].getText().toString().equals("X") && buttons[i][1].getText().toString().equals("X") && buttons[i][2].getText().toString() =="X") {
                System.out.println("X Is The Winner!");
                return 'X';
            }
            if (buttons[i][0].getText().toString().equals("O") && buttons[i][1].getText().toString().equals("O") && buttons[i][2].getText().toString() =="O") {
                System.out.println("Y Is The Winner!");
                return 'O';
            }
            //Cross
        }
        if ((buttons[0][0].getText().toString().equals("X") && buttons[1][1].getText().toString().equals("X") && buttons[2][2].getText().toString() =="X" )||
                (buttons[0][2].getText().toString().equals("X") && buttons[1][1].getText().toString().equals("X") && buttons[2][0].getText().toString() =="X")){
            System.out.println("X Is The Winner!");
            return 'X';
        }
        if ((buttons[0][0].getText().toString().equals("O") && buttons[1][1].getText().toString().equals("O") && buttons[2][2].getText().toString() =="O" )||
                (buttons[0][2].getText().toString().equals("O") && buttons[1][1].getText().toString().equals("O") && buttons[2][0].getText().toString() =="O")){
            System.out.println("X Is The Winner!");
            return 'O';
        }
        return 'N';
    }
}