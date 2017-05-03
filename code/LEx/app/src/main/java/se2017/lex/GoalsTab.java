// written by: Kevin Lee
// tested by: Kevin Lee
// debugged by: Kevin Lee

// tab that interacts with creating/editing GoalObjects and displaying them

package se2017.lex;

import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;



public class GoalsTab extends AppCompatActivity {

    //Creates an array to store and save the user's goals
    public static GoalObjects[] Goals = new GoalObjects[10];
    public static GoalObjects[] CompleteGoals = new GoalObjects[100];
    public static int targetGoal;
    private DatabaseReference fDatabase;
    String userid ="jariy";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_tab);
        //Load data from Database
        fDatabase = FirebaseDatabase.getInstance().getReference(userid+"/Goals");

        fDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
              int i = 0;

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    while(child.getValue(GoalObjects.class) == null) {
                    }
                    if(i<(Goals.length)) {
                        Goals[i] = child.getValue(GoalObjects.class);
                        i++;
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });



        View linearLayout = findViewById(R.id.info);

        //For loop to display all of the goals saved in the array as a list on the goals tab page
        for(int i = 0; i < Goals.length; i++) {
            if(Goals[i] != null && !Goals[i].com)
            {

                //Text View to display name of goal and give a fraction on the completion progress of the goal
                TextView ListGoal = new TextView(this);
                ListGoal.setText("  " + Goals[i].n + "              " + Goals[i].c + " / " + Goals[i].t);
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
                        fDatabase.child(Goals[delbID].k).removeValue();
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
                    EditGoal.setId(i);
                    final int editbID = EditGoal.getId();
                    EditGoal.setText("Edit");
                    final Intent toEditGoals = new Intent(this, EditGoals.class);
                    EditGoal.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            targetGoal = editbID;
                            startActivity(toEditGoals);
                        }
                    });
                    ((LinearLayout) linearLayout).addView(EditGoal);
                } else {
                    //Display a button for finishing the goal
                    Button CompleteGoal = new Button(this);
                    CompleteGoal.setId(i);
                    final int completeID = CompleteGoal.getId();
                    CompleteGoal.setText("Complete");
                    CompleteGoal.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            //Create a new Goal Object (java class) to store goal info entered by the user
                            GoalObjects NewG = new GoalObjects(Goals[completeID].c, Goals[completeID].t, Goals[completeID].n, Goals[completeID].k,true);
                            //Change Goal in database
                            fDatabase.child(NewG.k).setValue(NewG);
                            //Copy Over a Goals Object into the completed goals array
                            for (int j = 0; j < CompleteGoals.length; j++) {
                                if(CompleteGoals[j] == null) {
                                    CompleteGoals[j] = NewG;
                                    break;
                                }
                            }
                            Goals[completeID] = null;
                            startActivity(toGoals);
                        }
                    });
                    ((LinearLayout) linearLayout).addView(CompleteGoal);

                }
            }
        }


    }




    //On clicking the button to make a new goal, open activity where user can create a new goal
    public void makeNewGoal(View v){
        Intent newGoal = new Intent (this, AddingGoals.class);
        startActivity(newGoal);
    }

    public void viewAchievements (View v){
        Intent toAchievements = new Intent (this, AchievedGoals.class);
        startActivity(toAchievements);
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
