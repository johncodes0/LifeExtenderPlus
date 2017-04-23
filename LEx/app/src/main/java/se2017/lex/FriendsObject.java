package se2017.lex;

/**
 * Created by jengol on 4/23/17.
 */

public class FriendsObject {


    public String name;
    public int healthIndex;

    public FriendsObject(){
        super();
    }

    public FriendsObject(String n, int hi){
        this.name = n;
        this.healthIndex = hi;
    }

    public String toString(){
        return "Friend: " + this.name +
                "\nHealth Index: " + this.healthIndex;
    }
}
