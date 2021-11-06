package model;


public class Movie extends Product{
    private int minimumAge;
    private Category movieCategory;
    private String productor;

    /**
     * The constructor of Movie
     * @param title, title of the product
     * @param synopsis, synopsis of the product
     * @param directorName, name of the director of the product
     * @param day, release day of the product
     * @param month, release month of the product
     * @param year, release year of the product
     * @param productor, productor of the movie
     * @param minimumAge, minimum recommended age to watch the movie
     * @param movieCategory, the category of the movie
     */

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


    @Override

    /**
     * ToString method that returns a string with all the data of the movie
     * @return String
     */

    public String toString(){

        String generalData = "\n------------General Data-------------\n"+
                             "\nTitle: "+getTitle()+
                             "\nSynopsis: "+getSynopsis()+
                             "\nDirector name: "+getDirectorName()+
                             "\nRelease date: "+getReleaseDate().toString();

        String movieData = "\n--------------Movie Data---------------\n"+
                           "\nProductor: "+productor+
                           "\nMinimum recommended age: "+minimumAge+
                           "\nMovie Category: "+movieCategory;

        return generalData + movieData;
    }
}
