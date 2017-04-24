package se2017.lex;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * This is an object that contains data about the HealthIndex.
 * User's Health File; when the user wants to calculate their health index, the function
 * pulls information from these java objects to make the calculation
 */


public class IndexObjects {
    public int currentHI;
    public int LITime;
    public int HITime;
    public String date;
    public IndexObjects(){ super();}
    public IndexObjects(int chi, int lit, int hit,String d)
    {
        this.currentHI = chi;
        this.LITime = lit;
        this.HITime = hit;
        this.date = d;

    }
    public IndexObjects(int chi, int lit, int hit)
    {
        this.currentHI = chi;
        this.LITime = lit;
        this.HITime = hit;
        Date today = Calendar.getInstance().getTime();

        // (2) create a date "formatter" (the date format we want)
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        // (3) create a new String using the date format we want
        this.date = formatter.format(today);


    }
    void currentdate() {
        Date today = Calendar.getInstance().getTime();

        // (2) create a date "formatter" (the date format we want)
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        // (3) create a new String using the date format we want
        date = formatter.format(today);
    }
}
