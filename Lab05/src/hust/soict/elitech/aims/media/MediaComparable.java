package hust.soict.elitech.aims.media;

/**
 * Media Comparable Interface
 * Section 12: Override equals & compareTo
 * Provides comparison functionality for Media objects
 */
public interface MediaComparable extends Comparable<Media> {
    
    /**
     * Compare two media objects by title
     */
    @Override
    default int compareTo(Media other) {
        if (other == null) {
            return 1;
        }
        
        // Compare by title first
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        
        // If titles are equal, compare by price
        return Float.compare(this.getPrice(), other.getPrice());
    }
    
    /**
     * Check if two media objects are equal
     */
    @Override
    boolean equals(Object obj);
    
    /**
     * Get hash code for media object
     */
    @Override
    int hashCode();
}
