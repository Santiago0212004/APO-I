package model;

public class Season {
    private int programmedEpisodesQuantity;
    private int publishedEpisodesQuantity;
    private String trailer;
    private Date releaseDateOfSeason;

    /**
     * Constructor of Season
     * @param programmedEpisodesQuantity, programmed episodes quantity of the Season
     * @param publishedEpisodesQuantity, published episodes quantity of the Season
     * @param trailer, trailer URL of the season
     * @param day, release day of the season
     * @param month, release month of the season
     * @param year, release year of the season
     */

    public Season(int programmedEpisodesQuantity, int publishedEpisodesQuantity, String trailer, int day, int month, int year){       
        this.programmedEpisodesQuantity = programmedEpisodesQuantity;
        this.publishedEpisodesQuantity = publishedEpisodesQuantity;
        this.trailer = trailer;
        releaseDateOfSeason = new Date(day, month, year);
    }

    public int getProgrammedEpisodesQuantity() {
        return programmedEpisodesQuantity;
    }

    public void setProgrammedEpisodesQuantity(int programmedEpisodesQuantity) {
        this.programmedEpisodesQuantity = programmedEpisodesQuantity;
    }

    public int getPublishedEpisodesQuantity() {
        return publishedEpisodesQuantity;
    }

    public void setPublishedEpisodesQuantity(int publishedEpisondesQuantity) {
        this.publishedEpisodesQuantity = publishedEpisodesQuantity;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Date getReleaseDateOfSeason() {
        return releaseDateOfSeason;
    }

    public void setReleaseDateOfSeason(Date releaseDateOfSeason) {
        this.releaseDateOfSeason = releaseDateOfSeason;
    }

    /**
     * toString method that returns all data of season
     * @return data, String
     */

    public String toString(){

        String data = "\nQuantity of programmed episodes: "+programmedEpisodesQuantity+
                      "\nQuantity of published episodes: "+publishedEpisodesQuantity+
                      "\nTrailer URL: "+trailer+
                      "\nDate: "+releaseDateOfSeason.toString();
        
        return data;
    }

}
