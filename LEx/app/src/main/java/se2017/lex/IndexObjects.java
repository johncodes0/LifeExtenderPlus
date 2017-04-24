package se2017.lex;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public double date;
    public String key;
    public Map<String, Boolean> stars = new HashMap<>();

    public IndexObjects(){ super();}
    public IndexObjects(int chi, int lit, int hit,double d, String k)
    {
        this.currentHI = chi;
        this.LITime = lit;
        this.HITime = hit;
        this.date = d;
        this.key = k;

    }
    public IndexObjects(int chi, int lit, int hit)
    {
        this.currentHI = chi;
        this.LITime = lit;
        this.HITime = hit;
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        // (3) create a new String using the date format we want
        String stn = formatter.format(today);
        this.date = Double.parseDouble(stn);

        this.key = null;

    }
    public IndexObjects(int chi, int lit, int hit,String k)
    {
        this.currentHI = chi;
        this.LITime = lit;
        this.HITime = hit;
        Date today = Calendar.getInstance().getTime();
        this.key = k;

        // (2) create a date "formatter" (the date format we want)
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        // (3) create a new String using the date format we want
        String stn = formatter.format(today);
        this.date = Double.parseDouble(stn);


    }
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("current", currentHI);
        result.put("LI", LITime);
        result.put("speed",HITime);
        result.put("key", key);
        result.put("date",date);


        return result;
    }


}
