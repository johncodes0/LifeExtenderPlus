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
}
