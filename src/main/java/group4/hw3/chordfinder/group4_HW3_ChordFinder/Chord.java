package group4.hw3.chordfinder.group4_HW3_ChordFinder;
import java.util.*;

/**
 * Represents a chord with a name and a list of intervals.
 */
class Chord {
	private String name;
	private List<Interval> intervals;
	
	/**
     * Constructs a Chord object with the given name and intervals.
     *
     * @param name      the name of the chord (e.g., "maj", "min").
     * @param intervals the list of intervals that define the chord.
     */
	public Chord(String name, List<Interval> intervals) {
        this.name = name;
        this.intervals = intervals;
    }

	/**
     * Returns the name of the chord.
     *
     * @return the name of the chord.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of intervals that define the chord.
     *
     * @return the list of intervals.
     */
    public List<Interval> getIntervals() {
        return intervals;
    }

}
