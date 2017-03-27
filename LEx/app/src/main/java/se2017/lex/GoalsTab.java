package se2017.lex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class GoalsTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_tab);
    }

    public void makeNewGoal(View v){
        Intent newGoal = new Intent (this, AddingGoals.class);
        startActivity(newGoal);
    }
}
