package se2017.lex;

/**
 * Object that defines all the settings
 */

public class SettingsObject {
    public double pollingRate;
    //The time the user wakes up
    public int hr;
    public int min;
    public boolean am; // am == true, pm == false;
    // Time to travel to gym
    public int travelTime;
    // Have Health Index visible to friends
    public boolean healthIndexPublic;
    // Setting to mute Notifications
    public boolean muteNotifications;

    public SettingsObject(){
        super();
    }

    public SettingsObject(double p, int h, int m, boolean a, int t, boolean hi, boolean mN){
        this.pollingRate = p;
        this.hr = h;
        this.min = m;
        this.am = a;
        this.travelTime = t;
        this.healthIndexPublic = hi;
        this.muteNotifications = mN;
    }

    public String toString()
    {
        return   "pollingRate: " + this.pollingRate +
                "\nhour: " + this.hr +
                "\nmin: " + this.min +
                "\nam: " + this.am +
                "\ntravelTime: " + this.travelTime +
                "\nHealthIndexPublic: " + this.healthIndexPublic +
                "\nmuteNotifications: " + this.muteNotifications;
    }



}
