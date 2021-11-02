package model;

public abstract class Product {
    protected String synopsis;
    protected String directorName;
    protected Date releaseDate;

    public Product(String synopsis, String directorName, int day, int month, int year){
        this.synopsis = synopsis;
        this.directorName = directorName;
        releaseDate = new Date(day, month, year);
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

}
