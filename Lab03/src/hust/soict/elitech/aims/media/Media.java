package hust.soict.elitech.aims.media;

import java.util.Comparator;

public abstract class Media {
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
        Comparator.comparing(Media::getTitle)
                  .thenComparing(Comparator.comparingDouble(Media::getCost).reversed());

    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
        Comparator.comparingDouble(Media::getCost).reversed()
                  .thenComparing(Media::getTitle);

    public Media() {
        nbMedia++;
        this.id = nbMedia;
    }

    public Media(String title) {
        this();
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return this.title != null && this.title.equals(other.title);
    }

    @Override
    public abstract String toString();
}
