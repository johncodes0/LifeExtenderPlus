package se2017.lex;

/**
<<<<<<< HEAD
 * This is an object that contains data about the HealthIndex.
=======
 * Created by Kevin on 3/27/2017.
 * User's Health File; when the user wants to calculate their health index, the function
 * pulls information from these java objects to make the calculation
>>>>>>> f1bfc2b2b341500f99729ad5377da18201f5de11
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
