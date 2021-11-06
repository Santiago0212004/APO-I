package model;

public abstract class Product {
    protected String title;
    protected String synopsis;
    protected String directorName;
    protected Date releaseDate;

    /**
     * Constructor of class product
     * @param title, title of the product
     * @param synopsis, synopsis of the product
     * @param directorName, the name of the director of the product
     * @param day, release day of the product
     * @param month, release month of the product
     * @param year, release year of the product
     */

    public Product(String title, String synopsis, String directorName, int day, int month, int year){
        this.title = title;
        this.synopsis = synopsis;
        this.directorName = directorName;
        releaseDate = new Date(day, month, year);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * This is an abstract method that indicates that the subclasses of product must have a toString method
     */

    public abstract String toString();


}
