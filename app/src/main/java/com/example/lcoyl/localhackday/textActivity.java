package com.example.lcoyl.localhackday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class textActivity extends Activity {

    private static Boolean isNightModeOn = false;

    public static void setIsNightModeOn(Boolean b){
        isNightModeOn = b;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        //code for setting up night/light modes
        if (isNightModeOn){
            setTheme(R.style.AppTheme_Dark);
        }
        else setTheme(R.style.AppTheme_Light);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        TextView textView = findViewById(R.id.output);
        textView.setText(message);
    }
    @Override
    public void onBackPressed(){
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
