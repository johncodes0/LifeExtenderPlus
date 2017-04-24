package se2017.lex;

/**
 * Created by TuneLynk on 4/24/2017.
 */

public class eTime {


        public long secondStart;
        public long minuteStart;
        public long hourStart;
        public long secondEnd;
        public long minuteEnd;
        public long hourEnd;
        public String name;


        public eTime(long sS, long mS, long hS, long sE, long mE, long hE, String n){
            this.secondStart = sS;
            this.minuteStart = mS;
            this.hourStart = hS;
            this.secondEnd = sE;
            this.minuteEnd = mE;
            this.hourEnd = hE;
            this.name = n;
        }

}
