package model;

public class Movie extends Product{
    private int minimumAge;
    private Category movieCategory;
    private String productor;

    public Movie(String title, String synopsis, String directorName, int day, int month, int year, String productor, int minimumAge, Category movieCategory){
        super(title, synopsis, directorName, day, month, year);
        this.minimumAge = minimumAge;
        this.movieCategory = movieCategory;
        this.productor = productor;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Category getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(Category movieCategory) {
        this.movieCategory = movieCategory;
    } 
}
