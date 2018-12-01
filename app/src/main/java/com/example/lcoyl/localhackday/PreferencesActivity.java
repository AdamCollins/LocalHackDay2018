package com.example.lcoyl.localhackday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences_layout);

        setupPowerButtonTakesPhotoSwitch();
        setupDayModeSwitch();

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
        Switch dayModeSwitch = findViewById(R.id.dayModeSwitch);
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
