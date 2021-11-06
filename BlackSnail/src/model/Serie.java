package model;

public class Serie extends Product {
    private String protagonistNames;
    private StateOfSerie serieState;
    private String reason;
    private Season serieSeasons[];

    private final int MAX_SEASONS = 50;

    /**
     * Constructor of Serie
     * @param title, title of the product
     * @param synopsis, synopsis of the product
     * @param directorName, name of the director of the product
     * @param day, release day of the product
     * @param month, release month of the product
     * @param year, release year of the product
     * @param protagonistNames, names of the protagonist of the serie separated by commas
     * @param serieState, state of the serie, censored or uncesored
     * @param reason, reason of the censure of the serie in the case it is censored
     * @param programmedEpisodesQuantity, programmed episodes quantity of the first season
     * @param publishedEpisodesQuantity, published episodes quantity of the first season
     * @param trailer, trailer URL of the season
     */

    public Serie(String title, String synopsis, String directorName, int day, int month, int year, String protagonistNames, StateOfSerie serieState, String reason, int programmedEpisodesQuantity, int publishedEpisodesQuantity, String trailer){
        super(title, synopsis, directorName, day, month, year);
        this.protagonistNames = protagonistNames;
        this.serieState = serieState;
        this.reason = reason;
        serieSeasons = new Season[MAX_SEASONS];
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    /**
     * This method adds a season in the first null position in the array
     * @param programmedEpisodesQuantity, Programmed episodes quantity of the season
     * @param publishedEpisodesQuantity, Published episodes quantity of the season
     * @param trailer, trailer URL of the season
     * @param day, release day of season
     * @param month, release month of season
     * @param year, release year of season
     * @return, added, boolean
     */

    public boolean addSeason(int programmedEpisodesQuantity, int publishedEpisodesQuantity, String trailer, int day, int month, int year){
        boolean added = false;
        for(int i=0; i<50; i++){
            if(serieSeasons[i]==null && !added){
                serieSeasons[i] = new Season(programmedEpisodesQuantity, publishedEpisodesQuantity, trailer, day, month, year);
                added = true;
            }
        }
        return added;
    }

    @Override

    /**
     * This is a toString method with the data of the serie and its seasons
     * @return, String
     */

    public String toString(){

        String generalData = "\n------------General Data-------------\n"+
                             "\nTitle: "+getTitle()+
                             "\nSynopsis: "+getSynopsis()+
                             "\nDirector name: "+getDirectorName()+
                             "\nDate of first emission: "+getReleaseDate().toString();

        String serieData = "\n---------------Serie Data---------------\n"+
                           "\nProtagonist names: "+protagonistNames+
                           "\nState of the serie: "+serieState+". "+reason;
        
        String seasons = "";

        for(int i=0; i<50; i++){
            if(serieSeasons[i]!=null){
                seasons += "\n\n---------------Season number "+(i+1)+"----------------\n"+
                           serieSeasons[i].toString()+"\n";
            }
        }

        return generalData + serieData + seasons;
    }

    /**
     * This a method that returns the data of the serie and the data of the last season
     * @return, String
     */

    public String serieWithLastSeason(){
        String lastSeasonData = "";
        boolean found = false;


        String generalData = "\n\n------------General Data-------------\n"+
                             "\nTitle: "+getTitle()+
                             "\nSynopsis: "+getSynopsis()+
                             "\nDirector name: "+getDirectorName()+
                             "\nDate of first emission: "+getReleaseDate().toString();

        String serieData = "\n\n---------------Serie Data---------------\n"+
                           "\nProtagonist names: "+protagonistNames+
                           "\nState of the serie: "+serieState+". "+reason;

        for(int i=0; i<50 && !found; i++){
            if(serieSeasons[i]==null){
                lastSeasonData = "\n\n-------------Last Season-------------\n"+
                                  serieSeasons[i-1].toString();
                found = true;
            }
        }

        return generalData + serieData + lastSeasonData;
    }

}
