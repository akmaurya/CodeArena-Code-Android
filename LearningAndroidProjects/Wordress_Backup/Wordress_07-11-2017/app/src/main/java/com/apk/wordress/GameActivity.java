package com.apk.wordress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apk.wordress.model.QuestionVO;
import com.apk.wordress.util.Message;
import com.apk.wordress.util.QuestionsUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GameActivity extends Activity {

    Context context = this;

    int score = 0, questionVOListSize = 0, levelHighestScore, level;
    long levelTime=0;
    String[] option;

    TextView question, totalScore;
    Button option_1, option_2, option_3, option_4;
    ProgressBar questionProprogressBar;

    List<QuestionVO> questionVOList;
    QuestionsUtil questionsUtil;

    WordressDbAdaptor helper;
    HashMap<Integer,Integer> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        questionVOList = new ArrayList<>();
        questionsUtil = new QuestionsUtil();

        level = getIntent().getExtras().getInt("level");
        helper = new WordressDbAdaptor(this);
        helper.setDefaultScores();
        if(level==GamesI.LEVEL_ONE) {
            questionVOList = questionsUtil.getQuestionVOListLevelOne();
            levelHighestScore = helper.getLevelHighestScore(level);
            levelTime = GamesI.LEVEL_ONE_TIME;
        }
        else if(level==GamesI.LEVEL_TWO) {
            questionVOList = questionsUtil.getQuestionVOListLevelTwo();
            levelHighestScore = helper.getLevelHighestScore(level);
            levelTime = GamesI.LEVEL_TWO_TIME;
        }
        else if(level==GamesI.LEVEL_THREE) {
            questionVOList = questionsUtil.getQuestionVOListLevelThree();
            levelHighestScore = helper.getLevelHighestScore(level);
            levelTime = GamesI.LEVEL_THREE_TIME;
        }

        questionVOListSize = questionVOList.size();
        Collections.shuffle(questionVOList);

        question = (TextView) findViewById(R.id.question);
        option_1 = (Button) findViewById(R.id.option1);
        option_2 = (Button) findViewById(R.id.option2);
        option_3 = (Button) findViewById(R.id.option3);
        option_4 = (Button) findViewById(R.id.option4);
        totalScore = (TextView) findViewById(R.id.score);
        questionProprogressBar = (ProgressBar) findViewById(R.id.progressBar);
        questionProprogressBar.setVisibility(View.VISIBLE);

        setNextQuestion();

        final android.os.Handler handler = new android.os.Handler();
        final Runnable r = new Runnable() {
            int x = 100;
            @Override
            public void run() {

                handler.postDelayed(this, levelTime/10);
                if(x>=0) {
                    questionProprogressBar.setProgress(x);
                }
                x-=1;
                if (x==0)
                {
                    if (score>levelHighestScore)
                    {
                        long check = helper.updateHighestScore(level,score);
                        if(check<=0) {
                            Message.message(context,"Insertion failed - Level 1");
                        } else {
                            Message.message(context,"Insertion successful - Level 1");
                        }
                    }
                    showScore();
                }

                option_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(question.getText().equals(option_1.getText())) {
                            score+=10;
                            option_1.setBackgroundColor(Color.GREEN);
                        } else {
                            score-=2;
                            option_1.setBackgroundColor(Color.RED);
                        }
                        totalScore.setText("Score: " + score);
                        questionVOListSize--;
                        setNextQuestion();
                    }
                });

                option_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(question.getText().equals(option_2.getText())) {
                            score+=10;
                            option_2.setBackgroundColor(Color.GREEN);
                        } else {
                            score-=2;
                            option_2.setBackgroundColor(Color.RED);
                        }
                        totalScore.setText("Score: " + score);
                        questionVOListSize--;
                        setNextQuestion();
                    }
                });

                option_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(question.getText().equals(option_3.getText())) {
                            score+=10;
                            option_3.setBackgroundColor(Color.GREEN);
                        } else {
                            score-=2;
                            option_3.setBackgroundColor(Color.RED);
                        }
                        totalScore.setText("Score: " + score);
                        questionVOListSize--;
                        setNextQuestion();
                    }
                });

                option_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(question.getText().equals(option_4.getText())) {
                            score+=10;
                            option_4.setBackgroundColor(Color.GREEN);
                        } else {
                            score-=2;
                            option_4.setBackgroundColor(Color.RED);
                        }
                        totalScore.setText("Score: " + score);
                        questionVOListSize--;
                        setNextQuestion();
                    }
                });

            }
        };
        handler.postDelayed(r, 0000);
    }

    public void setNextQuestion() {
        option = questionVOList.get(questionVOListSize-1).getWordVO().getOptions();
        question.setText((""+option[0]).toUpperCase());

        Collections.shuffle(Arrays.asList(option));
        option_1.setText((""+option[0]).toUpperCase());
        option_2.setText((""+option[1]).toUpperCase());
        option_3.setText((""+option[2]).toUpperCase());
        option_4.setText((""+option[3]).toUpperCase());

        option_1.setBackgroundResource(android.R.drawable.btn_default);
        option_2.setBackgroundResource(android.R.drawable.btn_default);
        option_3.setBackgroundResource(android.R.drawable.btn_default);
        option_4.setBackgroundResource(android.R.drawable.btn_default);
    }

    public void showScore() {
        helper = new WordressDbAdaptor(this);
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.score_dialog);
        dialog.setTitle("Title...");

        /*Highest score level*/
        TextView highestScoreView = (TextView) dialog.findViewById(R.id.highestScoreView);
        highestScoreView.setText("Highest score is: " + levelHighestScore);

        /*Your score level*/
        TextView titleView = (TextView) dialog.findViewById(R.id.scoreView);
        titleView.setText("Your score is: " + score);

        Button changeLevelButton = (Button) dialog.findViewById(R.id.changeLevelButton);
        Button playAgainButton = (Button) dialog.findViewById(R.id.playAgainButton);
        // if button is clicked, close the custom dialog
        changeLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent i = new Intent(context, LevelActivity.class);
                startActivity(i);
            }
        });

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent i = new Intent(context, GameActivity.class);
                i.putExtra("level",level);
                startActivity(i);
            }
        });

        dialog.setCanceledOnTouchOutside(false);

        dialog.show();
    }
}