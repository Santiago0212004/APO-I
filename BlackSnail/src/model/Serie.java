package model;

public class Serie extends Product {
    private String protagonistNames;
    private StateOfSerie serieState;
    private Season serieSeason;

    public Serie(String title, String synopsis, String directorName, int day, int month, int year, String protagonistNames, StateOfSerie serieState, int programmedEpisodesQuantity, int publishedEpisodesQuantity, String trailer){
        super(title, synopsis, directorName, day, month, year);
        this.protagonistNames = protagonistNames;
        this.serieState = serieState;
        serieSeason = new Season(1, programmedEpisodesQuantity, publishedEpisodesQuantity, trailer, day, month, year);
    }


    public String getProtagonistNames() {
        return protagonistNames;
    }

    public void setProtagonistNames(String protagonistNames) {
        this.protagonistNames = protagonistNames;
    }

    public StateOfSerie getSerieState() {
        return serieState;
    }

    public void setSerieState(StateOfSerie serieState) {
        this.serieState = serieState;
    }

    public Season getSerieSeason() {
        return serieSeason;
    }

    public void setSerieSeason(Season serieSeason) {
        this.serieSeason = serieSeason;
    }

}
