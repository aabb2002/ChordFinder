package group4.hw3.chordfinder.group4_HW3_ChordFinder;

/**
 * Represents an interval between two notes in semitones.
 */
class Interval {
	private int semitones;
	
	/**
     * Constructs an Interval object with the given number of semitones.
     *
     * @param semitones the number of semitones in the interval.
     */
	public Interval(int semitones) {
        this.semitones = semitones;
    }
	
	/**
     * Returns the number of semitones in the interval.
     *
     * @return the number of semitones.
     */
	public int getSemitones() {
        return semitones;
    }
}
