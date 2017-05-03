// written by: John Eng
// tested by: John Eng
// debugged by: John Eng

// Java class for TimeObject that extracts the data from Google Calendar containing data
// about the hour, minute, second, day, and name of each event's beginning and end time.

package se2017.lex;

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
