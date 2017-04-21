package se2017.lex;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;


/**
 * This class allows visibility of goals and interacts with AddingGoals class.
 *
 *
 */


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
                final ProgressBar GProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                GProgressBar.setMax(Goals[i].t);
                GProgressBar.setProgress(Goals[i].c);
                GProgressBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
                ((LinearLayout) linearLayout).addView(GProgressBar);



                //Display a button for deleting the goal
                Button DelGoal = new Button(this);
                DelGoal.setId(i);
                final int delbID = DelGoal.getId();
                DelGoal.setText("Delete");
                final Intent toGoals = new Intent(this, GoalsTab.class);
                DelGoal.setOnClickListener(new View.OnClickListener()
                {
                    //When deleting the goal, go to that element of the array and set it to null
                    @Override
                    public void onClick(View v)
                    {
                        Goals[delbID] = null;
                        startActivity(toGoals);
                    }
                });
                ((LinearLayout) linearLayout).addView(DelGoal);



                //If goal is complete, allow user to save the goal to their achievements
                //If goal is incomplete, allow user to edit the goal
                if (Goals[i].c < Goals[i].t) {
                    //Display a button for editing the goal
                    Button EditGoal = new Button(this);
                    EditGoal.setId(i * 2);
                    int editbID = EditGoal.getId();
                    EditGoal.setText("Edit");



                    ((LinearLayout) linearLayout).addView(EditGoal);
                } else {
                    //Display a button for finishing the goal
                    Button EditGoal = new Button(this);
                    EditGoal.setId(i * 2);
                    int editbID = EditGoal.getId();
                    EditGoal.setText("Complete");



                    ((LinearLayout) linearLayout).addView(EditGoal);

                }
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
