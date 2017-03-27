package se2017.lex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ProgressBar;

public class GoalsTab extends AppCompatActivity {

    public static GoalObjects[] Goals = new GoalObjects[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_tab);

        //Add linear layout
        LinearLayout linlay = new LinearLayout(this);
        setContentView(linlay);
        linlay.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < Goals.length; i++)
        {
            if(Goals[i] == null)
            {

            }
            else {
                TextView tv = new TextView(this);
                tv.setText(Goals[i].n);
                linlay.addView(tv);

                ProgressBar pb = new ProgressBar(this);
                pb.setMax(Goals[i].t);
                pb.setProgress(Goals[i].c);
                linlay.addView(pb);
            }
        }


    }

    public void makeNewGoal(View v){
        Intent newGoal = new Intent (this, AddingGoals.class);
        startActivity(newGoal);
    }


}
