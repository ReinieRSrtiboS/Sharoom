package com.syntesizer.reinier2.sharoom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Reinier2 on 22-1-2017.
 */

public class Lecture extends AppCompatActivity {
    int send = 0;
    Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        connection = new Connection();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecture);

        Intent intent = getIntent();
        String message = intent.getStringExtra("lecture");
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.title_name);
        layout.addView(textView);

        if (intent.getStringExtra("question") != null) {
            connection.sendQuestion(intent.getStringExtra("question"));
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.fast:
                if (checked) {
                    send = 1;
                    break;
                }
            case R.id.slow:
                if (checked) {
                    send = 2;
                    break;
                }
            case R.id.quiet:
                if (checked) {
                    send = 3;
                    break;
                }
            case R.id.follow:
                if (checked) {
                    send = 4;
                    break;
                }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        connection.Close();
    }

    public void Send(View view) {
        connection.sendFeedBack(send);
    }

//    public void Ask(View view) {
//        EditText editText = (EditText) findViewById(R.id.edit_message2);
//        String message = editText.getText().toString();
//        connection.sendQuestion(message);
//    }

    public void Ask(View view) {
        Intent intent = new Intent(this, Ask.class);
        intent.putExtra("lecture", getIntent().getStringExtra("lecture"));
        startActivity(intent);
    }

    public void Questions(View view) {
        List<String> questions = connection.getQuestion();
        Intent intent = new Intent(this, Questions.class);
        for (int i = 0; i < questions.size(); i++) {
            intent.putExtra("" + i, questions.get(i));
        }
    }
}
