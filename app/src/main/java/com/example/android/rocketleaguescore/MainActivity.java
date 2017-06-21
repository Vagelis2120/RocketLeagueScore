package com.example.android.rocketleaguescore;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class MainActivity extends AppCompatActivity {
    int scoreBlueTeam = 0;
    int scoreOrangeTeam = 0;
    int demolitionBlue = 0;
    int demolitionOrange = 0;
    int gameOver = 2;
    Button btnStart;
    Button btnStop;
    TextView textTime;
    TextView scoreViewBlue;
    TextView scoreViewOrange;
    TextView demoViewBlue;
    TextView demoViewOrange;
    private static final String SCORE_BLUE = "blueScore";
    private static final String SCORE_ORANGE = "orangeScore";
    private static final String DEMO_BLUE = "demoBlue";
    private static final String DEMO_ORANGE = "demoOrange";
    private static final String GAME_OVER = "gameOver";
    private static final String TEXT_TIME = "5:00";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            scoreBlueTeam = savedInstanceState.getInt(SCORE_BLUE);
            scoreOrangeTeam = savedInstanceState.getInt(SCORE_ORANGE);
            demolitionBlue = savedInstanceState.getInt(DEMO_BLUE);
            demolitionOrange = savedInstanceState.getInt(DEMO_ORANGE);
            gameOver = savedInstanceState.getInt(GAME_OVER);
        }

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        textTime = (TextView) findViewById(R.id.textTime);
        scoreViewBlue = (TextView) findViewById(R.id.blue_score);
        scoreViewOrange = (TextView) findViewById(R.id.orange_score);
        demoViewBlue = (TextView) findViewById(R.id.blue_demolition);
        demoViewOrange = (TextView) findViewById(R.id.orange_demolition);

        textTime.setText(TEXT_TIME);

        final setTimer timer = new setTimer(10000, 1000);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
                scoreBlueTeam = 0;
                scoreOrangeTeam = 0;
                demolitionBlue = 0;
                demolitionOrange = 0;
                gameOver = 1;
                displayScoreForBlueTeam(scoreBlueTeam);
                displayScoreForOrangeTeam(scoreOrangeTeam);
                displayDemoBlue(demolitionBlue);
                displayDemoOrange(demolitionOrange);
                Toast.makeText(getApplicationContext(), "New Game Started!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * Displays the given score for Blue team.
     */
    public void displayScoreForBlueTeam(int score) {
        scoreViewBlue.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Orange team.
     */
    public void displayScoreForOrangeTeam(int score) {
        scoreViewOrange.setText(String.valueOf(score));
    }

    /**
     * Displays the demolitions for Blue team.
     */
    public void displayDemoBlue(int score) {
        demoViewBlue.setText(String.valueOf(score));
    }

    /**
     * Displays the demolitions for Orange team.
     */
    public void displayDemoOrange(int score) {
        demoViewOrange.setText(String.valueOf(score));
    }


    /**
     * This adds 1 goal for Blue team.
     */
    public void oneGoalBlueTeam(View view) {
        if (gameOver == 0) {
            scoreBlueTeam = scoreBlueTeam + 0;
            Toast.makeText(getApplicationContext(), "The Game Is Over !", Toast.LENGTH_SHORT).show();
        } else if (gameOver == 2) {
            scoreBlueTeam = 0;
            Toast.makeText(getApplicationContext(), "Game Hasn't Started !", Toast.LENGTH_SHORT).show();
        } else {
            scoreBlueTeam = scoreBlueTeam + 1;
            displayScoreForBlueTeam(scoreBlueTeam);
        }
    }

    /**
     * This adds 1 goal for Orange team.
     */
    public void oneGoalOrangeTeam(View view) {
        if (gameOver == 0) {
            scoreOrangeTeam = scoreOrangeTeam + 0;
            Toast.makeText(getApplicationContext(), "The Game Is Over !", Toast.LENGTH_SHORT).show();
        } else if (gameOver == 2) {
            scoreOrangeTeam = 0;
            Toast.makeText(getApplicationContext(), "Game Hasn't Started !", Toast.LENGTH_SHORT).show();
        } else {
            scoreOrangeTeam = scoreOrangeTeam + 1;
            displayScoreForOrangeTeam(scoreOrangeTeam);
        }
    }

    /**
     * This adds 1 demolition for Blue team.
     */
    public void oneDemolitionBlueTeam(View view) {
        if (gameOver == 0) {
            demolitionBlue = demolitionBlue + 0;
            Toast.makeText(getApplicationContext(), "The Game Is Over !", Toast.LENGTH_SHORT).show();
        } else if (gameOver == 2) {
            demolitionBlue = 0;
            Toast.makeText(getApplicationContext(), "Game Hasn't Started !", Toast.LENGTH_SHORT).show();
        } else {
            demolitionBlue = demolitionBlue + 1;
            displayDemoBlue(demolitionBlue);
        }
    }

    /**
     * This adds 1 demolition for Blue team.
     */
    public void oneDemolitionOrangeTeam(View view) {
        if (gameOver == 0) {
            demolitionOrange = demolitionOrange + 0;
            Toast.makeText(getApplicationContext(), "The Game Is Over !", Toast.LENGTH_SHORT).show();
        } else if (gameOver == 2) {
            demolitionOrange = 0;
            Toast.makeText(getApplicationContext(), "Game Hasn't Started !", Toast.LENGTH_SHORT).show();
        } else {
            demolitionOrange = demolitionOrange + 1;
            displayDemoOrange(demolitionOrange);
        }
    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class setTimer extends CountDownTimer {


        public setTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String ms = String.format("%2d:%02d", java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis),
                    java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(ms);
            textTime.setText(ms);
        }

        @Override
        public void onFinish() {
            textTime.setText("0:00");
            gameOver = 0;
            if (scoreBlueTeam > scoreOrangeTeam) {
                Toast.makeText(getApplicationContext(), "Blue Team Wins !", Toast.LENGTH_SHORT).show();
            } else if (scoreBlueTeam < scoreOrangeTeam) {
                Toast.makeText(getApplicationContext(), "Orange Team Wins !", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "It's a Draw !", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.putInt(SCORE_BLUE, scoreBlueTeam);
        displayScoreForBlueTeam(scoreBlueTeam);
        savedInstanceState.putInt(SCORE_ORANGE, scoreOrangeTeam);
        displayScoreForOrangeTeam(scoreOrangeTeam);
        savedInstanceState.putInt(DEMO_BLUE, demolitionBlue);
        displayDemoBlue(demolitionBlue);
        savedInstanceState.putInt(DEMO_ORANGE, demolitionOrange);
        displayDemoOrange(demolitionOrange);
        savedInstanceState.putInt(GAME_OVER, gameOver);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SCORE_BLUE, scoreBlueTeam);
        savedInstanceState.putInt(SCORE_ORANGE, scoreOrangeTeam);
        savedInstanceState.putInt(DEMO_BLUE, demolitionBlue);
        savedInstanceState.putInt(DEMO_ORANGE, demolitionOrange);
        savedInstanceState.putInt(GAME_OVER, gameOver);

        super.onSaveInstanceState(savedInstanceState);
    }
}
