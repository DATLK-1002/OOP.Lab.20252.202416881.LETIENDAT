/**
 * DigitalVideoDisc class represents a DVD with its properties and methods
 */
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    /**
     * Constructor for DigitalVideoDisc
     */
    public DigitalVideoDisc() {
        this.title = "";
        this.category = "";
        this.director = "";
        this.length = 0;
        this.cost = 0.0f;
    }

    /**
     * Constructor with parameters
     */
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    /**
     * Get the title of the DVD
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title of the DVD
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the category of the DVD
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Set the category of the DVD
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get the director of the DVD
     */
    public String getDirector() {
        return this.director;
    }

    /**
     * Set the director of the DVD
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Get the length of the DVD
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Set the length of the DVD
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Get the cost of the DVD
     */
    public float getCost() {
        return this.cost;
    }

    /**
     * Set the cost of the DVD
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * Display DVD information
     */
    @Override
    public String toString() {
        return "DVD [" + this.title + " - " + this.category + " - " + this.director + 
               " - " + this.length + " minutes - $" + this.cost + "]";
    }
}
