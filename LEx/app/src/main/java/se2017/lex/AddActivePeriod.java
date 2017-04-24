package se2017.lex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class AddActivePeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_active_period);

        TextView startTime = (TextView) findViewById(R.id.suggestStart);
        TextView endTime = (TextView) findViewById(R.id.suggestEnd);

        startTime.setText(HomeTab.startAPSuggestion + "");
        endTime.setText(HomeTab.endAPSuggestion + "");

    }

    public void acceptEvent(View v){
        eTime APSuggest = new eTime(0,0,HomeTab.startAPSuggestion,0,0,HomeTab.endAPSuggestion,"Active Period");
        HomeTab.sorted.add(APSuggest);

        Intent toHome = new Intent(this, HomeTab.class);
        startActivity(toHome);
    }

    public void gotoHome(View v) {
        Intent toHome = new Intent(this, HomeTab.class);
        startActivity(toHome);
    }

}