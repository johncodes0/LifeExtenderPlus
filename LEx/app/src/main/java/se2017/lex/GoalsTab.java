package se2017.lex;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;

public class GoalsTab extends AppCompatActivity {

    //Creates an array to store and save the user's goals
    public static GoalObjects[] Goals = new GoalObjects[5];


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_tab);

        View linearLayout = findViewById(R.id.info);

        //For loop to display all of the goals saved in the array as a list on the goals tab page
        for(int i = 0; i < Goals.length; i++) {
            if(Goals[i] != null)
            {
                //Text View to display name of goal and give a fraction on the completion progress of the goal
                TextView ListGoal = new TextView(this);
                ListGoal.setText("  " +  (i+1) + "). " + Goals[i].n + "              " + Goals[i].c + " / " + Goals[i].t);
                ListGoal.setTextSize(20);
                ListGoal.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                ((LinearLayout) linearLayout).addView(ListGoal);

                //Display a progress bar to further illustrate the user's completion progress toward their goal
                ProgressBar GProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                GProgressBar.setMax(Goals[i].t);
                GProgressBar.setProgress(Goals[i].c);
                GProgressBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
                ((LinearLayout) linearLayout).addView(GProgressBar);
            }
        }
    }

    //On clicking the button to make a new goal, open activity where user can create a new goal
    public void makeNewGoal(View v){
        Intent newGoal = new Intent (this, AddingGoals.class);
        startActivity(newGoal);
    }

    //Fragment Links for tab switcher
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
