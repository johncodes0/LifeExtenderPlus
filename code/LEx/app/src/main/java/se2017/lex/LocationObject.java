// written by: Daniel Huang
// tested by: Daniel Huang
// debugged by: Daniel Huang

// Java class for LocationObject that describes GPS data including the latitude, longitude, speed, and key (Hash) for the database



package se2017.lex;

import android.location.Location;

import java.util.HashMap;
import java.util.Map;


public class LocationObject {
    public Map<String, Boolean> stars = new HashMap<>();

    public double lat;
    public double longi;
    public float speed;
    public String n;

    public LocationObject(){ super();}

    //Object in order to store Locations in the Database
    //Created by Daniel Huang

    public LocationObject(double lati, double longit, float fast, String key)
    {
        this.lat = lati;
        this.longi = longit;
        this.speed = fast;
        this.n = key;
    }
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Long", longi);
        result.put("Lat", lat);
        result.put("speed", speed);
        result.put("key", n);


        return result;
    }


}
