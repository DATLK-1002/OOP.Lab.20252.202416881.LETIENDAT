package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, director, 0, cost);
        this.artist = artist;
    }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " already exists in CD!");
        } else {
            tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " not found in CD!");
        } else {
            tracks.remove(track);
            System.out.println("Removed track: " + track.getTitle());
        }
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("ERROR: CD " + getTitle() + " cannot be played");
            return;
        }
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());
        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - ").append(getTitle()).append(" - ").append(getCategory())
          .append(" - ").append(artist).append(" - ").append(getDirector())
          .append(" - ").append(getLength()).append(" min: ").append(getCost()).append(" $");
        for (Track t : tracks) {
            sb.append("\n  ").append(t.toString());
        }
        return sb.toString();
    }
}
