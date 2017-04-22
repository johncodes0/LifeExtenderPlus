package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;



public class AchievedGoals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achieved_goals);

        View linLayout = findViewById(R.id.moreinfo);

        //For loop to display all of the goals saved in the array as a list on the goals tab page
        for(int i = 0; i < GoalsTab.CompleteGoals.length; i++) {
            if(GoalsTab.CompleteGoals[i] != null)
            {
                //Text View to display name of goal and give a fraction on the completion progress of the goal
                TextView ListGoal = new TextView(this);
                ListGoal.setText( (i+1) + "). " + GoalsTab.CompleteGoals[i].n);
                ListGoal.setTextSize(30);
                ListGoal.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                ((LinearLayout) linLayout).addView(ListGoal);

                //Text View to display name of goal and give a fraction on the completion progress of the goal
                TextView Prog = new TextView(this);
                Prog.setText("  " + GoalsTab.CompleteGoals[i].c + " / " + GoalsTab.CompleteGoals[i].t);
                Prog.setTextSize(20);
                Prog.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                ((LinearLayout) linLayout).addView(Prog);
            }
        }


    }

    public void goBack(View v){
        Intent newGoal = new Intent (this, GoalsTab.class);
        startActivity(newGoal);
    }
}
