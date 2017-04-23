package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * This class changes applicable settings that has parameters that affects the backend calendar code.
 *
 *
 */

public class SettingsTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_tab);
    }


    //The rate at which the Google Maps will poll for GPS coordinates.
    public double pollingRate;
    //The time the user wakes up
    public int hr;
    public int min;
    public boolean am; // am == true, pm == false;
    // Time to travel to gym
    public int travelTime;
    // Have Health Index visible to friends
    public boolean healthIndexPublic;
    // Setting to mute Notifications
    public boolean muteNotifications;





    /**
     * Test method to check Health Index algorithm
     *
     *
     *
     */

//    public void confirmGoal(View v) {
//        //Get the inputs entered by the user and store them into variables
//        EditText currentHI = (EditText) findViewById(R.id.tfcurrentind);
//        EditText HITime = (EditText) findViewById(R.id.tfhitime);
//        EditText LITime = (EditText) findViewById(R.id.tflitime);
//
//        //Process data by storing the variables as integers for usage in calculations
//        int cur = Integer.valueOf(currentHI.getText().toString());
//        int hi = Integer.valueOf(HITime.getText().toString());
//        int li = Integer.valueOf(LITime.getText().toString());
//
//        //Store the processed data in a Java Object
//        StatsTab.HealthInfo.currentHI = cur;
//        StatsTab.HealthInfo.HITime = hi;
//        StatsTab.HealthInfo.LITime = li;
//
//        //After confirming the entered data, return to the Stats Tab to view the updated result
//        Intent toStats = new Intent(this, StatsTab.class);
//        startActivity(toStats);
//    }

    public void changeNotificationsSettings(View v){
        Intent changeN = new Intent(this,ChangeNotifcations.class);
        startActivity(changeN);
    }

    public void changeLocationGPSSettings(View v){
        Intent changeL = new Intent(this, ChangeLocationGPS.class);
        startActivity(changeL);

    }

    public void changeCalendarSettings(View v){
        Intent changeC = new Intent(this,ChangeCalendar.class);
        startActivity(changeC);
    }

    public void changeProfileSettings(View v){
        Intent changeP = new Intent(this,ChangeProfile.class);
        startActivity(changeP);
    }


    //Fragment Links for Tab Switcher
    public void gotoHome(View v) {
        Intent toHome = new Intent(this, HomeTab.class);
        startActivity(toHome);
    }
    public void gotoStats(View v) {
        Intent toStats = new Intent(this, StatsTab.class);
        startActivity(toStats);
    }
    public void gotoMaps(View v) {
        Intent toMaps = new Intent(this, MapsTab.class);
        startActivity(toMaps);
    }
    public void gotoSettings(View v) {
        Intent toSettings = new Intent(this, SettingsTab.class);
        startActivity(toSettings);
    }
    public void gotoGoals(View v) {
        Intent toGoals = new Intent(this, GoalsTab.class);
        startActivity(toGoals);
    }
}
