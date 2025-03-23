package group4.hw3.chordfinder.group4_HW3_ChordFinder;

import junit.framework.TestCase;
import java.util.Set;
/**
 * Unit test for ChordFinder class.
 */
public class ChordFinderTest extends TestCase {

    public void testMajorChord() {
        Set<String> chords = ChordFinder.getChordName("C", "E", "G");
        assertEquals(Set.of("C maj"), chords); // C E G should be a C major chord
    }

    public void testMinorChord() {
        Set<String> chords = ChordFinder.getChordName("A", "C", "E");
        assertEquals(Set.of("A min"), chords); // A C E should be an A minor chord
    }

    public void testDiminishedChord() {
        Set<String> chords = ChordFinder.getChordName("B", "D", "F");
        assertEquals(Set.of("B dim"), chords); // B D F should be a B diminished chord
    }

    public void testAugmentedChord() {
        Set<String> chords = ChordFinder.getChordName("C", "E", "G#");
        assertEquals(Set.of("C aug", "E aug", "G# aug"), chords); // C E G# should be an augmented chord
    }

    public void testEnharmonicMajorChord() {
        Set<String> chords = ChordFinder.getChordName("Db", "F", "Ab");
        assertEquals(Set.of("Db maj"), chords); // Db F Ab should be a Db major chord
    }

    public void testEnharmonicMinorChord() {
        Set<String> chords = ChordFinder.getChordName("A#", "C#", "F");
        assertEquals(Set.of("A# min"), chords); // A# C# F should be an A# minor chord
    }

    public void testUnrecognizedChord() {
        Set<String> chords = ChordFinder.getChordName("C", "D", "G");
        assertTrue(chords.isEmpty()); // C D G should not be a recognized chord
    }

    public void testInvalidNote() {
        try {
            ChordFinder.getChordName("Zb", "C", "E");
            fail("Expected IllegalArgumentException for invalid note name");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid note name: Zb", e.getMessage()); // Zb is not a valid note
        }
    }

    public void testDuplicateNotes() {
        try {
            ChordFinder.getChordName("A", "A", "C");
            fail("Expected IllegalArgumentException for duplicate notes");
        } catch (IllegalArgumentException e) {
            assertEquals("Duplicate notes are not allowed.", e.getMessage()); // Duplicate notes should throw an exception
        }
    }

    public void testTooFewNotes() {
        try {
            ChordFinder.getChordName("C", "E");
            fail("Expected IllegalArgumentException for too few notes");
        } catch (IllegalArgumentException e) {
            assertEquals("Input must contain exactly 3 notes.", e.getMessage()); // Too few notes should throw an exception
        }
    }

    public void testTooManyNotes() {
        try {
            ChordFinder.getChordName("C", "E", "G", "A");
            fail("Expected IllegalArgumentException for too many notes");
        } catch (IllegalArgumentException e) {
            assertEquals("Input must contain exactly 3 notes.", e.getMessage()); // Too many notes should throw an exception
        }
    }

    public void testCyclicAugmentedChord() {
        Set<String> chords = ChordFinder.getChordName("B", "D#", "G");
        assertEquals(Set.of("B aug", "D# aug", "G aug"), chords); // B D# G should be an augmented chord with multiple roots
    }

    public void testCyclicMajorChord() {
        Set<String> chords = ChordFinder.getChordName("D", "G", "B");
        assertEquals(Set.of("G maj"), chords); // D G B should be a G major chord
    }

    public void testCyclicMinorChord() {
        Set<String> chords = ChordFinder.getChordName("C", "Eb", "G");
        assertEquals(Set.of("C min"), chords); // C Eb G should be a C minor chord
    }

    public void testNoChordsRecognized() {
        Set<String> chords = ChordFinder.getChordName("E", "G", "A");
        assertTrue(chords.isEmpty()); // E G A should not be a recognized chord
    }
}
