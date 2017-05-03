// written by: Daniel Huang
// tested by: Daniel Huang
// debugged by: Daniel Huang

// Java class for time and date of Active Period locations


package se2017.lex;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TimeObject {
    public Map<String, Boolean> stars = new HashMap<>();

    public long date;
    public String n;

    public TimeObject(){super();}

    public TimeObject(long day, String key)
    {
        this.date = day;
        this.n = key;
    }



}
