package model;

public class MiniRoom {
    private int id;
    private Company hostCompany;
    private double rentalPrice;
    private Rack rack;
    private boolean miniRoomOn;
    private boolean miniRoomRented;
    private Date rentalDate;

    public MiniRoom(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getHostCompany() {
        return hostCompany;
    }

    public void setHostCompany(Company hostCompany) {
        this.hostCompany = hostCompany;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
		this.rack = rack;
	}

    public boolean isMiniRoomOn() {
        return miniRoomOn;
    }

    public void setMiniRoomOn(boolean miniRoomOn) {
        this.miniRoomOn = miniRoomOn;
    }

    public boolean isMiniRoomRented() {
        return miniRoomRented;
    }

    public void setMiniRoomRented(boolean miniRoomRented) {
        this.miniRoomRented = miniRoomRented;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

}
