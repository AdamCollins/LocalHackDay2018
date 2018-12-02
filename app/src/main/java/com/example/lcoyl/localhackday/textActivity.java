package com.example.lcoyl.localhackday;

import android.app.Activity;
import android.os.Bundle;

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
        setContentView(R.layout.preferences_layout);

    }
}
