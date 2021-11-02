package model;

public class Movie extends Product{
    private String title;
    private int minimumAge;
    private Category movieCategory;

    public Movie(String synopsis, String directorName, int day, int month, int year, String title, int minimumAge, Category movieCategory){
        super(synopsis, directorName, day, month, year);
        this.title = title;
        this.minimumAge = minimumAge;
        this.movieCategory = movieCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
