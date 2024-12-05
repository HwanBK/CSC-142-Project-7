
/**
 * Write a description of class MusicTrack here.
 *
 * @author Hwansu Kim (Billy)
 * @version 03/13/2022
 */
public class MusicTrack implements Comparable<MusicTrack> {
    // ENUM //
    // public enum SortOrder {
        // ARTIST, TITLE, TRACK_ORDER
    // }
    
    
    // INSTANCE DATA //
    private String artist;
    private String title;
    private int trackOrder;
    // private static SortOrder sortOrder;
    
    
    // CONSTRUCTOR //
    /**
     * MusicTrack constructor.
     * @param artist        The artist of the track.
     * @param title         The title of the track.
     */
    public MusicTrack(String artist, String title) {
        setArtist(artist);
        setTitle(title);
    }
    
    
    // ACCESSORS//
    /**
     * Accessor for the artist of the track.
     * @return              The artist of the track.
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     * Accessor for the title of the track.
     * @return              The title of the track.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Accessor for the track order.
     * @return              The track order of the track.
     */
    public int getTrackOrder() {
        return trackOrder;
    }
    
    
    // MUTATORS //
    /**
     * Mutator for the artist of the track.
     * @param artist        The artist of the track.
     */
    public void setArtist(String artist) {
        checkNullOrEmpty(artist);
        this.artist = artist;
    }
    
    /**
     * Mutator for the title of the track.
     * @param title         The title of the track.
     */
    public void setTitle(String title) {
        checkNullOrEmpty(title);
        this.title = title;
    }
    
    /**
     * Mutator for the track order of the track.
     * @param trackOrder    The track order of the track.
     */
    public void setTrackOrder(int trackOrder) {
        if (trackOrder < 1) {
            throw new IllegalArgumentException("trackOrder must not be less than 1.");
        }
        this.trackOrder = trackOrder;
    }
    
    // /**
     // * Static mutator for the sort order.
     // * @param sortOrder     The sort order of the track.
     // */
    // public static void setSortOrder(SortOrder sortOrder) {
        // if (sortOrder == null) {
            // throw new IllegalArgumentException("sortOrder must not be null.");
        // }
        // MusicTrack.sortOrder = sortOrder;
    // }
    
    
    // MISC. //
    public String toString() {
        return String.format("%2d", trackOrder) + ". " + title + " -- " + artist;
    }
    
    
    public int compareTo(MusicTrack other) {
        return trackOrder - other.trackOrder;
        // return MusicTrack.sortOrder - other.sortOrder;
    }
    
    
    private void checkNullOrEmpty(String target) {
        if (target == null || target.isEmpty()) {
            throw new IllegalArgumentException(target + "must not be null or empty.");
        }
    }
}
