package se2017.lex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class HomeTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tab);
    }

    public void gotoGoals(View v){
        Intent toGoals = new Intent (this, GoalsTab.class);
        startActivity(toGoals);
    }
}
