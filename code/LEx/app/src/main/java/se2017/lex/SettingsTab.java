// written by: John Eng
// tested by: John Eng
// debugged by: John Eng

// processes changes to the settings and relays information over the other tabs


package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
//Imports for notifications
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;


public class SettingsTab extends AppCompatActivity {



    NotificationCompat.Builder notif;
    private static final int uniqueID = 481516;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_tab);


        notif = new NotificationCompat.Builder(this);
        notif.setAutoCancel(true);

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




    public void changeNotificationsSettings(View v){
        Intent changeN = new Intent(this,ChangeNotifcations.class);
        startActivity(changeN);
        //TESTING THE NOTIFICATION
//        sendNotification(null);
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
