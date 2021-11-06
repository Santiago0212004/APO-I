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

    @Override

    public String toString(){

        String generalData = "\n------------General Data-------------\n"+
                             "\nTitle: "+getTitle()+
                             "\nSynopsis: "+getSynopsis()+
                             "\nDirector name: "+getDirectorName()+
                             "\nDate: "+getReleaseDate().toString();

        String movieData = "\n--------------Movie Data---------------\n"+
                           "\nProductor: "+productor+
                           "\nMinimum recommended age: "+minimumAge+
                           "\nMovie Category: "+movieCategory;

        return generalData + movieData;
    }
}
