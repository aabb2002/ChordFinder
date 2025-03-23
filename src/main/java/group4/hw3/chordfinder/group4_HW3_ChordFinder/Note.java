package group4.hw3.chordfinder.group4_HW3_ChordFinder;
import java.util.*;


/**
 * Represents a musical note with a name and a corresponding semitone value.
 */
class Note {
	private String name;
	private int value;

	private static final Map<String, Integer> NOTE_VALUES = new HashMap<>();
	static {
		NOTE_VALUES.put("A", 0);
		NOTE_VALUES.put("A#", 1);
		NOTE_VALUES.put("Bb", 1);
		NOTE_VALUES.put("B", 2);
		NOTE_VALUES.put("C", 3);
		NOTE_VALUES.put("C#", 4);
		NOTE_VALUES.put("Db", 4);
		NOTE_VALUES.put("D", 5);
		NOTE_VALUES.put("D#", 6);
		NOTE_VALUES.put("Eb", 6);
		NOTE_VALUES.put("E", 7);
		NOTE_VALUES.put("F", 8);
		NOTE_VALUES.put("F#", 9);
		NOTE_VALUES.put("Gb", 9);
		NOTE_VALUES.put("G", 10);
		NOTE_VALUES.put("G#", 11);
		NOTE_VALUES.put("Ab", 11);
	}

	/**
     * Constructs a Note object with the given name.
     *
     * @param name the name of the note (e.g., "C", "A#", "Bb").
     * @throws IllegalArgumentException if the note name is invalid.
     */
	public Note(String name) {
		if (!NOTE_VALUES.containsKey(name)) {
			throw new IllegalArgumentException("Invalid note name: " + name);
		}
		this.name = name;
		this.value = NOTE_VALUES.get(name);
	}

	/**
     * Returns the semitone value of the note.
     *
     * @return the semitone value (0-11).
     */
	public int getValue() {
		return value;
	}

	/**
     * Returns the name of the note.
     *
     * @return the name of the note.
     */
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Note note = (Note) o;
		return value == note.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

}
