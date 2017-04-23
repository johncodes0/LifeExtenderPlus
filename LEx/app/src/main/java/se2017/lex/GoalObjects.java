package se2017.lex;

/**
 * This is an object that contains data about Goals.
 *
 *
 */
import java.util.HashMap;
import java.util.Map;
public class GoalObjects {
    public int c;
    public int t;
    public String n;
    public Map<String, Boolean> stars = new HashMap<>();
    private GoalObjects()
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
