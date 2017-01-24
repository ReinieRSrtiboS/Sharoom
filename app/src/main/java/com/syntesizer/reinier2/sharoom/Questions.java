package com.syntesizer.reinier2.sharoom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Reinier2 on 23-1-2017.
 */

public class Questions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        Intent intent = getIntent();
        String[] questions = new String[1000000];
        for (int i = 0; i < 1000000; i++) {
            if (intent.getStringExtra("" + 1) != null) {
                String message = intent.getStringExtra("" + i);
                questions[i] = message;
            }
        }

        TextView textView = new TextView(this);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.question);
        layout.addView(textView);
    }
}
