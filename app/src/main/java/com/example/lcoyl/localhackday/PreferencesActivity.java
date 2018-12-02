package com.example.lcoyl.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Switch;


public class PreferencesActivity extends AppCompatActivity {

    private Switch nightModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //set up night/light mode
        if (AppCompatDelegate.getDefaultNightMode()
                ==AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.AppTheme_Dark);
        }
        else setTheme(R.style.AppTheme_Light);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences_layout);

        nightModeSwitch = findViewById(R.id.nightModeSwitch);
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            nightModeSwitch.setChecked(true);
        }

        nightModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    MainActivity.setIsNightModeOn(true);
                    reset();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    MainActivity.setIsNightModeOn(false);
                    reset();
                }
            }
        });
        //setupPowerButtonTakesPhotoSwitch();
        //setupDayModeSwitch();

    }

    public void reset(){
        Intent i = new Intent(getApplicationContext(), PreferencesActivity.class);
        startActivity(i);
    }


    // EFFECTS: creates switch based on power button switch in preferences_layout
    //          calls appropriate method(s) if the switch is checked
    private void setupPowerButtonTakesPhotoSwitch() {
        Switch powerButtonTakesPhotoSwitch = findViewById(R.id.powerButtonTakesPhotoSwitch);
        powerButtonTakesPhotoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //todo: whatever methods allow power button to take pictures
                }
            }
        });
    }

    // EFFECTS: creates switch based on day mode switch in preferences_layout
    //          calls method to make app day mode if switch is checked
    private void setupDayModeSwitch() {
        Switch dayModeSwitch = findViewById(R.id.nightModeSwitch);
        dayModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    makeAppDayMode();
                }
            }
        });
    }

    // todo: code this
    // switches app's background colour to white and text to black
    private void makeAppDayMode(){

    }


}
