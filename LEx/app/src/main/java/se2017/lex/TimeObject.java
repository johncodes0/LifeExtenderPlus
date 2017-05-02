package se2017.lex;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 4/24/2017.
 * Object for time that is stored in the database by the applicataion
 */

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
