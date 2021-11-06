package model;

public class Serie extends Product {
    private String protagonistNames;
    private StateOfSerie serieState;
    private Season serieSeasons[];

    public Serie(String title, String synopsis, String directorName, int day, int month, int year, String protagonistNames, StateOfSerie serieState, int programmedEpisodesQuantity, int publishedEpisodesQuantity, String trailer){
        super(title, synopsis, directorName, day, month, year);
        this.protagonistNames = protagonistNames;
        this.serieState = serieState;
        serieSeasons = new Season[50];
        serieSeasons[0] = new Season(programmedEpisodesQuantity, publishedEpisodesQuantity, trailer, day, month, year);
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

    @Override

    public String toString(){

        String generalData = "\n------------General Data-------------\n"+
                             "\nTitle: "+getTitle()+
                             "\nSynopsis: "+getSynopsis()+
                             "\nDirector name: "+getDirectorName()+
                             "\nDate: "+getReleaseDate().toString();

        String serieData = "\n---------------Serie Data---------------\n"+
                           "\nProtagonist names: "+protagonistNames+
                           "\nState of the serie: "+serieState;

        return generalData + serieData;
    }

}
