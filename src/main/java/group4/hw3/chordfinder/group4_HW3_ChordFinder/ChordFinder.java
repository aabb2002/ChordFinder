
/** group members 
 * 1.Andrew 
 * 2.Lawrence
 * 3.Nur
 */

package group4.hw3.chordfinder.group4_HW3_ChordFinder;


import java.util.*;


/**
 * A class that identifies the name of a chord based on three input notes.
 */
public class ChordFinder{
	private static final List<Chord> CHORDS = Arrays.asList(
	        new Chord("maj", Arrays.asList(new Interval(0), new Interval(4), new Interval(7))),
	        new Chord("min", Arrays.asList(new Interval(0), new Interval(3), new Interval(7))),
	        new Chord("dim", Arrays.asList(new Interval(0), new Interval(3), new Interval(6))),
	        new Chord("aug", Arrays.asList(new Interval(0), new Interval(4), new Interval(8)))
	    );

	/**
     * Returns a set of chord names that the given notes can represent.
     *
     * @param notes three notes of the chord, separated by a space.
     * @return a set of chord names if recognized, or an empty set if no chords are recognized.
     * @throws IllegalArgumentException if the input does not contain exactly 3 notes,
     * if duplicate notes are provided, or if an invalid note name is provided.
     */
	    public static Set<String> getChordName(String... notes) {
	        if (notes.length != 3) {
	            throw new IllegalArgumentException("Input must contain exactly 3 notes.");
	        }

	        Set<Note> noteSet = new HashSet<>();
	        for (String noteName : notes) {
	            noteSet.add(new Note(noteName));
	        }
	        if (noteSet.size() != 3) {
	            throw new IllegalArgumentException("Duplicate notes are not allowed.");
	        }

	        Set<String> recognizedChords = new HashSet<>();
	        List<Note> noteList = new ArrayList<>(noteSet);
	        Collections.sort(noteList, Comparator.comparingInt(Note::getValue));

	        for (int i = 0; i < 3; i++) {
	            Note root = noteList.get(i);
	            Note third = noteList.get((i + 1) % 3);
	            Note fifth = noteList.get((i + 2) % 3);

	            // Method 1: Root to third, third to fifth
	            int rootToThird = (third.getValue() - root.getValue() + 12) % 12;
	            int thirdToFifth = (fifth.getValue() - third.getValue() + 12) % 12;

	            // Method 2: Root to third, root to fifth
	            int rootToFifth = (fifth.getValue() - root.getValue() + 12) % 12;

	            for (Chord chord : CHORDS) {
	                if ((rootToThird == chord.getIntervals().get(1).getSemitones() &&
	                     thirdToFifth == (chord.getIntervals().get(2).getSemitones() - chord.getIntervals().get(1).getSemitones() + 12) % 12) ||
	                    (rootToThird == chord.getIntervals().get(1).getSemitones() &&
	                     rootToFifth == chord.getIntervals().get(2).getSemitones())) {
	                    recognizedChords.add(root.getName().toUpperCase() + " " + chord.getName());
	                }
	            }
	        }

	        return recognizedChords;
}

/**
 * The main method for interacting with the ChordFinder class.
* Prompts the user to input three notes and displays the recognized chord names.
 *
 * @param args command-line arguments (not used).
 */
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("Enter three notes (e.g., A C# E):");
        String input = scanner.nextLine();
        String[] notes = input.split(" ");

        try {
            Set<String> chords = getChordName(notes);
            if (chords.isEmpty()) {
                System.out.println("No recognized chords.");
            } else {
                System.out.println("Chord Name(s): " + chords);
            }
            break; // Exit the loop if input is valid
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please try again.");
        }
    }
    scanner.close();
	}
}
