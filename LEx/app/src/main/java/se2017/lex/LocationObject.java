package se2017.lex;

import android.location.Location;


public class LocationObject {

    public Location loc;
    public String n;

    public LocationObject(){ super();}

    public LocationObject(Location locat, String key)
    {
        super();
        this.loc = locat;
        this.n = key;
    }


}
