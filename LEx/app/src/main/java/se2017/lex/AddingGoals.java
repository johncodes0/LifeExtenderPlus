package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.Suppress;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;


/**
 * This class allows for goals to be created.
 * It is referenced from the GoalsTab class.
 *
 */


public class AddingGoals extends AppCompatActivity {
    private DatabaseReference mDatabase;
    public String userid = "jariy";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_goals);
        mDatabase = FirebaseDatabase.getInstance().getReference(userid+"/Goals");

    }

    /** On clicking the cancel button, return to the Goals Tab without saving any entries */
    public void cancel(View v){
        Intent newGoal = new Intent (this, GoalsTab.class);
        startActivity(newGoal);
    }

    /** On click, read entries from the user, save them to variables */
    public void confirmGoal(View v) {
        //Get the inputs
        EditText goalName = (EditText) findViewById(R.id.tfgoalname);
        EditText currentProgress = (EditText) findViewById(R.id.tfcurrent);
        EditText goalTarget = (EditText) findViewById(R.id.tfgoaltarget);

        //Process data
        int cur = Integer.valueOf(currentProgress.getText().toString());
        int targ = Integer.valueOf(goalTarget.getText().toString());
        String name = String.valueOf(goalName.getText());




        //Create child location with key
        String key = mDatabase.push().getKey();

        //Create a new Goal Object (java class) to store goal info entered by the user
        GoalObjects NewG = new GoalObjects(cur, targ, name,key);
        //Stores the Goal into database
        mDatabase.child(key).setValue(NewG);
        //Return to the Goals Tab after adding the goal
        Intent toGoals = new Intent(this, GoalsTab.class);
        startActivity(toGoals);

    }
}
