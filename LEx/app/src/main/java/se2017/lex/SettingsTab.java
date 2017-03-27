package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingsTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_tab);
    }

    public void confirmGoal(View v) {
        //Get the inputs
        EditText currentHI = (EditText) findViewById(R.id.tfcurrentind);
        EditText HITime = (EditText) findViewById(R.id.tfhitime);
        EditText LITime = (EditText) findViewById(R.id.tflitime);

        //Process data
        int cur = Integer.valueOf(currentHI.getText().toString());
        int hi = Integer.valueOf(HITime.getText().toString());
        int li = Integer.valueOf(LITime.getText().toString());

        StatsTab.HealthInfo.currentHI = cur;
        StatsTab.HealthInfo.HITime = hi;
        StatsTab.HealthInfo.LITime = li;


        Intent toStats = new Intent(this, StatsTab.class);
        startActivity(toStats);
    }

    //Fragment Links
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
