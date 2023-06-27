package com.facebook.www.calendar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button previousButton = (Button) findViewById(R.id.prevButton);
        Button nexttButton = (Button) findViewById(R.id.nextButton);
        final TextView resultTextView = (TextView) findViewById(R.id.textView);

        previousButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        int m = Integer.parseInt((String)resultTextView.getText());
                        m = m - 1;
                        resultTextView.setText(""+m);
                        Toast.makeText(MainActivity.this, ""+m,Toast.LENGTH_SHORT).show();
                    }
                }

        );

        nexttButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        int n = Integer.parseInt((String)resultTextView.getText());
                        n = n + 1;
                        resultTextView.setText(""+n);
                        Toast.makeText(MainActivity.this,""+n,Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
