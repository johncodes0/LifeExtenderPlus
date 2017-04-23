package se2017.lex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;

/**
 * This class is referenced by all tabs, functioning as the visible tab selector on the bottom of the app.
 */



public class bottomSectionFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_frag, container, false);


        //IMO I think that the code should be totally different and uses stuff like the listener to more effectively
        //use the code and not having the same methods in every class, something to worry about later


//        final Button home_button = (Button) view.findViewById(R.id.button);
//        final Button stats_button = (Button) view.findViewById(R.id.button);
//        final Button goals_button = (Button) view.findViewById(R.id.button);
//        final Button map_button = (Button) view.findViewById(R.id.button);
//        final Button settings_button = (Button) view.findViewById(R.id.button);
//
//
//        home_button.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                }
//
//
//        );
//
//
//        stats_button.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//
//                    }
//                }
//        );



        return view;
    }



}
