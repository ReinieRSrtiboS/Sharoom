package com.syntesizer.reinier2.sharoom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Reinier2 on 22-1-2017.
 */

public class HomeScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
    }


    public void Send(View view) {
        Intent intent = new Intent(this, Lecture.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra("lecture", message);
        startActivity(intent);
    }


}
