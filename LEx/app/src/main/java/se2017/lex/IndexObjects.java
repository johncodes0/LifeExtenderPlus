package se2017.lex;

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

    public IndexObjects(int chi, int lit, int hit)
    {
        this.currentHI = chi;
        this.LITime = lit;
        this.HITime = hit;
    }

}
