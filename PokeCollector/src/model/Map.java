package model;

public class Map{

    private String imagePath;
    private Date pictureDate;
    private Coordinate latitude;
    private Coordinate longitude;

    public CardCollection(String imagePath, Date pictureDate, Coordinate latitude, Coordinate longitude){
        this.imagePath = imagePath;
        this.pictureDate = pictureDate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    

}