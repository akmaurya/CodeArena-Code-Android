package com.apk.wordress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.apk.wordress.model.QuestionVO;
import com.apk.wordress.util.QuestionsUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends Activity {

    /*Context of the LevelActivity*/
    Context context = this;

    /*Button references of the LevelActivity*/
    Button easyLevel = null;
    Button mediumLevel = null;
    Button hardLevel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_level);

        /*Button references of the Game levels*/
        easyLevel = (Button) findViewById(R.id.button4);
        mediumLevel = (Button) findViewById(R.id.button5);
        hardLevel = (Button) findViewById(R.id.button6);


        /*Easy level*/
        easyLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GameActivity.class);
                i.putExtra("level",GamesI.LEVEL_ONE);
                startActivity(i);
            }
        });

        /*Medium level*/
        mediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GameActivity.class);
                i.putExtra("level",GamesI.LEVEL_TWO);
                startActivity(i);
            }
        });

        /*Hard level*/
        hardLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GameActivity.class);
                i.putExtra("level",GamesI.LEVEL_THREE);
                startActivity(i);
            }
        });
    }
}