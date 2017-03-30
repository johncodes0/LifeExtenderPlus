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


/**
 * This class allows visibility of goals and interacts with AddingGoals class.
 *
 *
 */


public class GoalsTab extends AppCompatActivity {

    public static GoalObjects[] Goals = new GoalObjects[5];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_tab);

        View linearLayout = findViewById(R.id.info);

        for(int i = 0; i < Goals.length; i++) {
            if(Goals[i] != null)
            {
                TextView ListGoal = new TextView(this);
                ListGoal.setText("  " +  (i+1) + "). " + Goals[i].n + "              " + Goals[i].c + " / " + Goals[i].t);
                ListGoal.setTextSize(20);
                ListGoal.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                ((LinearLayout) linearLayout).addView(ListGoal);

                ProgressBar GProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                GProgressBar.setMax(Goals[i].t);
                GProgressBar.setProgress(Goals[i].c);
                GProgressBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
                ((LinearLayout) linearLayout).addView(GProgressBar);
            }
        }
    }

    public void makeNewGoal(View v){
        Intent newGoal = new Intent (this, AddingGoals.class);
        startActivity(newGoal);
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
