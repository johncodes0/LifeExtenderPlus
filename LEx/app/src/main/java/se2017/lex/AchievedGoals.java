package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class AchievedGoals extends AppCompatActivity {
    private DatabaseReference fDatabase;
    String userid ="jariy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achieved_goals);
        fDatabase = FirebaseDatabase.getInstance().getReference(userid+"/Goals");
        fDatabase.addValueEventListener(new ValueEventListener() {
        GoalObjects temp;
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                int i = 0;

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    temp = child.getValue(GoalObjects.class);
                    if(i<(GoalsTab.CompleteGoals.length) && temp.com) {
                        GoalsTab.CompleteGoals[i] = temp;
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
