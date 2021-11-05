package model;

public class CardCollection{
    private String ownerName;

    private Album album1;
    private Album album2;
    private Album album3;
    private Album album4;

    private Date creationDate;

    public CardCollection(String ownerName, Album album1,Album album2,Album album3,Album album4,Date creationDate){
        this.ownerName = ownerName;
        this.album1 = album1;
        this.album2 = album2;
        this.album3 = album3;
        this.album4 = album4;
        this.creationDate = creationDate;
    }


    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void setAlbum1(Album album1){
        this.album1 = album1;
    }

    public void setAlbum2(Album album2){
        this.album2 = album2;
    }

    public void setAlbum3(Album album3){
        this.album3 = album3;
    }

    public void setAlbum4(Album album4){
        this.album4 = album4;
    }

    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }

    public Album getAlbum1(){
        return album1;
    }

    public Album getAlbum2(){
        return album2;
    }

    public Album getAlbum3(){
        return album3;
    }

    public Album getAlbum4(){
        return album4;
    }

    public Date getCreationDate(){
        return creationDate;
    }
}