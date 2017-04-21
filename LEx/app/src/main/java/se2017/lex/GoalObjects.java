package se2017.lex;

/**
 * This is an object that contains data about Goals.
 *
 *
 */

public class GoalObjects {
    public int c;
    public int t;
    public String n;

    public GoalObjects()
    {
        super();
    }

    public GoalObjects(int cur, int tar, String nam)
    {
        super();
        this.c = cur;
        this.t = tar;
        this.n = nam;
    }

    @Override
    public String toString()
    {
        return this.n + "     " + this.c + "/" + this.t;
    }

}
