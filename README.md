# Chord Finder 

**A musical chord identification system that determines chord names from three input notes**

## Features

- **Chord Recognition**  
  Identifies major (`maj`), minor (`min`), augmented (`aug`), and diminished (`dim`) chords

- **Enharmonic Support**  
  Handles equivalent notes (e.g., A♯ = B♭, C♯ = D♭)
- **Order Agnostic**  
  Works with notes in any order (e.g., `G-B-D` = `D-G-B`)
- **Input Validation**  
  Ensures valid notes (A-G with ♯/♭) and exactly 3 notes


##  Installation
```bash
git clone https://github.com/aabb2002/ChordFinder.git
cd ChordFinder
mvn clean install
