package com.syntesizer.reinier2.sharoom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Reinier2 on 22-1-2017.
 */

public class Ask extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ask);
    }

    public void Send(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        Intent intent = new Intent(this, Lecture.class);
        intent.putExtra("lecture", getIntent().getStringExtra("lecture"));
        intent.putExtra("question", message);
        startActivity(intent);
    }

}
