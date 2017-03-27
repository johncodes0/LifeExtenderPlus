package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class AddingGoals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_goals);
    }

    public void cancel(View v){
        Intent newGoal = new Intent (this, GoalsTab.class);
        startActivity(newGoal);
    }

    public void confirmGoal(View v) {
        //Get the inputs
        EditText goalName = (EditText) findViewById(R.id.tfgoalname);
        EditText currentProgress = (EditText) findViewById(R.id.tfcurrent);
        EditText goalTarget = (EditText) findViewById(R.id.tfgoaltarget);

        //Process data
        int cur = Integer.valueOf(currentProgress.getText().toString());
        int targ = Integer.valueOf(goalTarget.getText().toString());
        String name = String.valueOf(goalName.getText());

        GoalObjects NewG = new GoalObjects(cur, targ, name);

        for (int i = 0; i < GoalsTab.Goals.length; i++) {
            if(GoalsTab.Goals[i] == null) {
                GoalsTab.Goals[i] = NewG;
            }
        }

        Intent toGoals = new Intent(this, GoalsTab.class);
        startActivity(toGoals);

    }
}
