package model;

public class Season {
    private int number;
    private int programedEpisodesQuantity;
    private int publishedEpisondesQuantity;
    private String trailer;
    private Date releaseDateOfSeason;

    public Season(int number, int programedEpisodesQuantity, int publishedEpisondesQuantity, String trailer, int day, int month, int year){
        this.number = number;
        this.programedEpisodesQuantity = programedEpisodesQuantity;
        this.publishedEpisondesQuantity = publishedEpisondesQuantity;
        this.trailer = trailer;
        releaseDateOfSeason = new Date(day, month, year);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getProgramedEpisodesQuantity() {
        return programedEpisodesQuantity;
    }

    public void setProgramedEpisodesQuantity(int programedEpisodesQuantity) {
        this.programedEpisodesQuantity = programedEpisodesQuantity;
    }

    public int getPublishedEpisondesQuantity() {
        return publishedEpisondesQuantity;
    }

    public void setPublishedEpisondesQuantity(int publishedEpisondesQuantity) {
        this.publishedEpisondesQuantity = publishedEpisondesQuantity;
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

}
