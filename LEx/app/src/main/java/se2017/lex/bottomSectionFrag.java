// written by: Kevin Lee and Kyung Lee
// tested by: Kevin Lee, Kyung Lee and John Eng
// debugged by: Kevin Lee, Kyung Lee, and John Eng

// This class is referenced by all tabs, functioning as the visible tab selector on the bottom of the app.

package se2017.lex;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;

public class bottomSectionFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_frag, container, false);

        return view;
    }



}
