package model;

public class MiniRoom {
    private Company hostCompany;
    private double rentalValue;
    private int roomId;
    private Rack rack;
    private boolean available;
    private boolean on;
    private int row;
    private int column;
    private Date rentalDate;

    public MiniRoom(int row, int column, double rentalValue, int roomId){
        this.row = row;
        this.column = column;
        this.rentalValue = rentalValue;
        this.rentalValue = this.rentalValue - calculateDiscounts();
        available = true;
        on = false;
        this.roomId = roomId;
    }

    
    public Company getHostCompany() {
        return hostCompany;
    }

    public void setHostCompany(Company hostCompany) {
        this.hostCompany = hostCompany;
    }

    public boolean isOnWindow() {
        boolean onWindow=false;

        if(row==0 || column==0 || row==7 || column==49){
            onWindow=true;
        }

        return onWindow;
    }

    public double getRentalValue() {
        return rentalValue;
    }

    public double calculateDiscounts(){
        double discount;

        if(isOnWindow()){
            discount = rentalValue*0.10;
        }
        else if(row==6){
            discount = rentalValue*0.15;
        }
        else if(row>=1 && row<=5){
            discount = (rentalValue*0.25)*(-1);
        }
        else{
            discount = 0;
        }

        return discount;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getNitOfTheCompany(){
        String nit = "";
        if(hostCompany!=null){
            nit = hostCompany.getNit();
        }
        return nit;
    }

    public String getIdOfIcesiProject(){
        String id="";
        if(hostCompany!=null){
            if(hostCompany instanceof IcesiProject){
                id = ((IcesiProject) hostCompany).getProjectId();
            }
        }
        return id;
    }

    public void asignCompany(String companyName, String companyNit, int serversAmount, int day, int month, int year, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        hostCompany = new Company(companyName, companyNit);
        rentalDate = new Date(day, month, year);

        if(serversAmount<4){
            rentalValue += rentalValue*0.15;
        }

        rack = new Rack(serversAmount, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);
    }

    public void asignProject(String projectId, int serversAmount, int day, int month, int year, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        hostCompany = new IcesiProject(projectId);
        rentalDate = new Date(day, month, year);

        if(serversAmount<4){
            rentalValue += rentalValue*0.15;
        }

        rack = new Rack(serversAmount, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);

    }

}
