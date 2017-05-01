package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//WRitten by John Eng
//Changes the profile in the App

public class ChangeProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
    }

    public void ret(View v){
        Intent r = new Intent (this, SettingsTab.class);
        startActivity(r);
    }
}
