// written by: Kevin Lee and John Eng
// tested by: Kevin Lee and John Eng
// debugged by: Kevin Lee


// Java class for GoalsObject that contains arbitrary values for user input containin upper and lower bounds of the goal,
// the name of the goal and a key(Hash) for the database

package se2017.lex;


import java.util.HashMap;
import java.util.Map;
public class GoalObjects {
    public int c;
    public int t;
    public String n;
    public String k;
    public boolean com;
    public Map<String, Boolean> stars = new HashMap<>();
    private GoalObjects()
    {
    super();
    }


    //Written by Jayan A
    //An Object that is stored by the database


    public GoalObjects(int cur, int tar, String nam,String key)
    {
        super();
        this.c = cur;
        this.t = tar;
        this.n = nam;
        this.k = key;
        this.com= false;
    }
    public GoalObjects(int cur, int tar, String nam,String key,boolean complete)
    {
        super();
        this.c = cur;
        this.t = tar;
        this.n = nam;
        this.k = key;
        this.com= complete;
    }
    public GoalObjects(int cur, int tar, String nam)
    {
        super();
        this.c = cur;
        this.t = tar;
        this.n = nam;
        this.k = null;
        this.com = false;
    }
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("current", c);
        result.put("target", t);
        result.put("name", n);

        return result;
    }

    @Override
    public String toString()
    {
        return this.n + "     " + this.c + "/" + this.t;
    }

}
