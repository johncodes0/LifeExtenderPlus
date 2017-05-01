package se2017.lex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

//Written by Kevin Lee and John Eng
//Changes the calandar to show the Active Periods

public class ChangeCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_calendar);
    }

    public void ret(View v){
        Intent r = new Intent (this, SettingsTab.class);
        startActivity(r);
    }
}
