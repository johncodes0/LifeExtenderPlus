package se2017.lex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class displays the HealthIndex while also being responsible for analysis of data.
 *
 */

public class StatsTab extends AppCompatActivity {

    //Creates a class object HealthInfo that stores the data needed to calculate the health index
    public static IndexObjects HealthInfo = new IndexObjects(200,60,60);
    private DatabaseReference fDatabase;
    String userid ="jariy";
    public IndexObjects HI[] = new IndexObjects[20];

    /** On opening the Stats Tab, calculate and display the Health Index */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_tab);
        fDatabase = FirebaseDatabase.getInstance().getReference(userid+"/HI");
        String key = fDatabase.push().getKey();
        fDatabase.child(key).setValue(HealthInfo);


        fDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                int i = 0;

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    if(child.getValue(IndexObjects.class) == null) { break;
                    }
                    if(i<(HI.length)) {
                        HI[i] = child.getValue(IndexObjects.class);
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

    }
    public void pushHI(){
        Date today = Calendar.getInstance().getTime();

        // (2) create a date "formatter" (the date format we want)
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        // (3) create a new String using the date format we want
        String d = formatter.format(today);
        for(int i =0; i <HI.length; i++) {
            if(HI[i].date == d) {
                return;
            }
        }
        String key = fDatabase.push().getKey();
        fDatabase.child(key).setValue(HealthInfo);
    }

    /** Drafted formula to calculate the Health Index */
    protected void calculateHI () {
        TextView output = (TextView) findViewById(R.id.tv_HI);

        int H_0 = HealthInfo.currentHI; //inital index
        int L = 1; //low intensity multiplier
        int H = 3; //high intensity multiplier
        int x1 = HealthInfo.LITime; //time for low intensity periods (minutes)
        int x2 = HealthInfo.HITime; //time for high intensity periods (minutes)
        int H_nm1 = H_0; //previous health index
        int H_n = 0; //current health index


        //calculates current HI
        if (x1 > 30) {
            if (x2 != 0) {
                H_n = L * x1 + H * x2 + H_nm1;
            }
            else
                H_n = H_n - 100;
        }

        //Displaying the Health Index
        String formattedHI = String.format("%,d",H_n);
        output.setText("Health Index: " + formattedHI);

        //initiate button and progress bar
        ImageButton btn_HIoutput = (ImageButton) findViewById(R.id.btn_HIoutput);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btn_HIoutput.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //call function to calculate health index
                calculateHI();
                //second click changes progress bar visibility to "visible"
                //should be able to check value of HI and set current progress status accordingly
                progressBar.setVisibility(View.VISIBLE);
            }
        });
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