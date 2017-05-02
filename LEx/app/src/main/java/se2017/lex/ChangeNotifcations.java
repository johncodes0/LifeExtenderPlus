// written by: John Eng
// tested by: John Eng
// debugged by: John Eng

// adjusts the options for notifcations based on settings

package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class ChangeNotifcations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_notifcations);
    }

    public void ret(View v){
        Intent r = new Intent (this, SettingsTab.class);
        startActivity(r);
    }
}
