package model;

public class Serie extends Product {
    private String protagonistNames;
    private StateOfSerie serieState;
    private Season serieSeason;

    public Serie(String synopsis, String directorName, int day, int month, int year, String protagonistNames, StateOfSerie serieState){
        super(synopsis, directorName, day, month, year);
        this.protagonistNames = protagonistNames;
        this.serieState = serieState;
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
