package se2017.lex.test;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import se2017.lex.GoalObjects;

import static android.content.ContentValues.TAG;
import static junit.framework.Assert.assertEquals;

public class ExampleTest extends InstrumentationTestCase {
    public static int test;
    private DatabaseReference fDatabase;
    String userid ="jariy";
    int reality;
    public void test() throws Exception {
        final int expected = 10;
        fDatabase = FirebaseDatabase.getInstance().getReference(userid+"/test");
        fDatabase.setValue(expected);
        fDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                reality = dataSnapshot.getValue(int.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        assertEquals(expected, reality);
    }


}