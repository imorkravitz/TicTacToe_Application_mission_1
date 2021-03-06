package com.example.tictactoe_application_mission_1;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity<buttons> extends AppCompatActivity {

    private boolean symbol = true;
    private int count = 0;
    private Integer p1Num =0;
    private Integer p2Num =0;
    TextView turn;
    TextView p1;
    TextView p2;
    TextView p2_score;
    TextView p1_score;
    Button[][] buttons = new Button[3][3];
    TextView[][] Icons = new TextView[3][3];
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
                String IconsID = "main_icon_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);

                resID = getResources().getIdentifier(IconsID,"id",getPackageName());
                Icons[i][j] = findViewById(resID);
            }
        }

        buttons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFunc(buttons[0][0], turn, Icons[0][0]);
            }
        });
        buttons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFunc(buttons[0][1], turn, Icons[0][1]);
            }
        });
        buttons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFunc(buttons[0][2], turn, Icons[0][2]);
            }
        });
        buttons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFunc(buttons[1][0], turn, Icons[1][0]);
            }
        });
        buttons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFunc(buttons[1][1], turn, Icons[1][1]);
            }
        });
        buttons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFunc(buttons[1][2], turn, Icons[1][2]);
            }
        });
        buttons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFunc(buttons[2][0], turn, Icons[2][0]);
            }
        });
        buttons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFunc(buttons[2][1], turn, Icons[2][1]);
            }
        });
        buttons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFunc(buttons[2][2], turn, Icons[2][2]);
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
        p2_score.setText("0");
    }

    private void setRestart() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                Icons[i][j].setBackgroundResource(R.drawable.empty);
            }
        }
    }

    private void mainFunc(Button B, TextView T, TextView icon) {
        if (symbol&&B.getText()=="") {
            B.setText("X");
            icon.setBackgroundResource(R.drawable.pic8);
            T.setText("O Turn");
            count++;
            symbol = !symbol;
        } else if(B.getText()=="") {
            B.setText("O");
            icon.setBackgroundResource(R.drawable.pic7);
            T.setText("X Turn");
            count++;
            symbol = !symbol;
        }
        if (count > 3) {
            if(checkWinner()!="") {
                if(!symbol) {
                    turn.setText("X Is The Winner!");
                    Toast.makeText(this, "X turn!", Toast.LENGTH_SHORT).show();
                    p1Num++;
                    p1_score.setText(p1Num.toString());
                    symbol = true;
                }
                else {
                    turn.setText("O Is The Winner!");
                    Toast.makeText(this, "O turn!", Toast.LENGTH_SHORT).show();
                    p2Num++;
                    p2_score.setText(p2Num.toString());
                    symbol = false;
                }
                setRestart();
                count = 0;
            }
        }
        if (count == 9)
            setRestart();
    }

    private String checkWinner() {
        for (int i = 0; i < buttons.length; i++) {
            //Column
            if (buttons[0][i].getText().toString().equals(buttons[1][i].getText())&&
                    buttons[1][i].getText().toString().equals(buttons[2][i].getText().toString()))
                return buttons[0][i].getText().toString();
            //Row
            if (buttons[i][0].getText().toString().equals(buttons[i][1].getText().toString())&&
                    buttons[i][1].getText().toString().equals(buttons[i][2].getText().toString()))
                return buttons[i][0].getText().toString();
            //Cross
        }
        if ((buttons[0][0].getText().toString().equals(buttons[1][1].getText().toString()) && buttons[1][1].getText().toString().equals(buttons[2][2].getText().toString()))||
                (buttons[0][2].getText().toString().equals(buttons[1][1].getText().toString()) && buttons[1][1].getText().toString().equals(buttons[2][0].getText().toString())))
            return buttons[1][1].getText().toString();
        return "";
    }
}