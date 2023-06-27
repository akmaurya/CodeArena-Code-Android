package com.apk.wordress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.apk.wordress.dao.WordressDbAdaptor;
import com.apk.wordress.util.Message;

public class MainActivity extends Activity {

    /*Context of the MainActivity*/
    Context context = this;

    /*Button references of the MainActivity*/
    Button quitButton = null;
    Button playButton = null;
    Button highestScoreButton = null;
    WordressDbAdaptor helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        helper = new WordressDbAdaptor(this);

        helper.setDefaultScores();

        /*Button references of the Game*/
        playButton = (Button) findViewById(R.id.button);
        highestScoreButton = (Button) findViewById(R.id.button2);
        quitButton = (Button) findViewById(R.id.button3);


        /*Play button*/
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, LevelActivity.class);
                startActivity(i);
            }
        });

        /*Highest score button*/
        highestScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int easytLevelHighestScore = helper.getLevelHighestScore(1);
                int mediumLevelHighestScore = helper.getLevelHighestScore(2);
                int highLevelHighestScore = helper.getLevelHighestScore(3);
                Message.message(context, "Level-1: "+easytLevelHighestScore+"\n"+"Level-2: "+mediumLevelHighestScore+"\n"+"Level-3: "+highLevelHighestScore);
                showHighestScore(easytLevelHighestScore, mediumLevelHighestScore, highLevelHighestScore);
            }
        });

        /*Quit button*/
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmExitDialog();
               /* int check = helper.updateHighestScore(3,40);
                if(check<=0) {
                    Message.message(context,"Update failed." + check);
                } else {
                    Message.message(context,"Update successful." + check);
                }*/
            }
        });
    }

    private void confirmExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Message.message(context,"No button is clicked");
            }
        }).show();
    }

    public void showHighestScore(int easyLevelHighScore, int mediumLevelHighScore, int highLevelHighScore) {
        helper = new WordressDbAdaptor(this);
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.highest_score_dialog);
        dialog.setTitle("Title...");

        /*Highest score Easy level*/
        TextView easyLevelView = (TextView) dialog.findViewById(R.id.easyLevelScore);
        easyLevelView.setText("Easy Level: " + easyLevelHighScore);

        /*Highest score Medium level*/
        TextView mediumLevelView = (TextView) dialog.findViewById(R.id.mediumLevelScore);
        mediumLevelView.setText("Medium Level: " + mediumLevelHighScore);

        /*Highest score High level*/
        TextView highLevelView = (TextView) dialog.findViewById(R.id.highLevelScore);
        highLevelView.setText("High Level: " + highLevelHighScore);


        Button dismissButton = (Button) dialog.findViewById(R.id.dismissButton);
        // if button is clicked, close the custom dialog

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
