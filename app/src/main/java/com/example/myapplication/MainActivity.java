package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSignIn(View view) {
        EditText username = findViewById(R.id.et_username);
        EditText password = findViewById(R.id.et_password);
        Log.w("test", "onSignIn");

        if ("admin".equals(username.getText().toString()) &&
            "password".equals(password.getText().toString())
        ){
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("RESULT", "Success!!!");
            startActivity(intent);
            Log.w("test", "success");

        } else {
            Log.w("test", username.getText().toString() + ":" + password.getText().toString());
        }
    }
}
