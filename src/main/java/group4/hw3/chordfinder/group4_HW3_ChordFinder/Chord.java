package group4.hw3.chordfinder.group4_HW3_ChordFinder;
import java.util.*;

class Chord {
	private String name;
	private List<Interval> intervals;
	
	public Chord(String name, List<Interval> intervals) {
        this.name = name;
        this.intervals = intervals;
    }

    public String getName() {
        return name;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

}
