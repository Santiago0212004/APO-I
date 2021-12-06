package model;

public class MiniRoom {
    private Company hostCompany;
    private double rentalValue;
    private double baseRentalValue;
    private int roomId;
    private Rack rack;
    private boolean available;
    private boolean on;
    private int row;
    private int column;
    private Date rentalDate;

    /**
     * Constructor of mini room
     * @param row, row of the mini room
     * @param column, column of the mini room
     * @param rentalValue, rental value of the mini room
     * @param roomId, id of the mini room
     */

    public MiniRoom(int row, int column, double rentalValue, int roomId){
        this.row = row;
        this.column = column;
        baseRentalValue = rentalValue;
        this.rentalValue = baseRentalValue - calculateDiscounts();
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

    /**
     * Shows if a mini room is next to a window
     * @return onWindow
     */

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

    /**
     * Calculates the discounts
     * @return discount
     */

    public double calculateDiscounts(){
        double discount;

        if(isOnWindow()){
            discount = baseRentalValue*0.10;
        }
        else if(row==6){
            discount = baseRentalValue*0.15;
        }
        else if(row>=1 && row<=5){
            discount = (baseRentalValue*0.25)*(-1);
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

    /**
     * Obtains the nit of the host company if it is not a project
     * @return nit
     */

    public String getNitOfTheCompany(){
        String nit = "";
        if(hostCompany!=null){
            nit = hostCompany.getNit();
        }
        return nit;
    }

    /**
     * Obtains the id of the host if it is an ICESI project
     * @return id
     */

    public String getIdOfIcesiProject(){
        String id="";
        if(hostCompany!=null){
            if(hostCompany instanceof IcesiProject){
                id = ((IcesiProject) hostCompany).getProjectId();
            }
        }
        return id;
    }

    /**
     * Asing the mini room to a company
     * @param companyName, name of the company
     * @param companyNit, nit of the company
     * @param serversAmount, the amount of servers that are going to be hosted
     * @param day, renting day
     * @param month, renting month
     * @param year, renting year
     * @param cacheMemory, cache memory of the server
     * @param processorsAmount, amount of processors in the server
     * @param processorsTrademark, trademark of the processors of the server
     * @param ramMemory, amount of ram memory in the server
     * @param disksAmount, amount of disks in the server
     * @param disksCapacity, capacity of the disks of the server
     */

    public void asignCompany(String companyName, String companyNit, int serversAmount, int day, int month, int year, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        hostCompany = new Company(companyName, companyNit);
        rentalDate = new Date(day, month, year);
        on = true;

        if(serversAmount<4){
            rentalValue += rentalValue*0.15;
        }

        rack = new Rack(serversAmount, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);
    }

    /**
     * Asign the mini room to an ICESI project
     * @param projectId, id of the project
     * @param serversAmount, the amount of servers that are going to be hosted
     * @param day, renting day
     * @param month, renting month
     * @param year, renting year
     * @param cacheMemory, cache memory of the server
     * @param processorsAmount, amount of processors in the server
     * @param processorsTrademark, trademark of the processors of the server
     * @param ramMemory, amount of ram memory in the server
     * @param disksAmount, amount of disks in the server
     * @param disksCapacity, capacity of the disks of the server
     */

    public void asignProject(String projectId, int serversAmount, int day, int month, int year, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        hostCompany = new IcesiProject(projectId);
        rentalDate = new Date(day, month, year);
        on = true;

        if(serversAmount<4){
            rentalValue += rentalValue*0.15;
        }

        rack = new Rack(serversAmount, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);

    }

    /**
     * Asign an existing company ti the mini room
     * @param existingCompany, company objecj
     * @param serversAmount, the amount of servers that are going to be hosted
     * @param day, renting day
     * @param month, renting month
     * @param year, renting year
     * @param cacheMemory, cache memory of the server
     * @param processorsAmount, amount of processors in the server
     * @param processorsTrademark, trademark of the processors of the server
     * @param ramMemory, amount of ram memory in the server
     * @param disksAmount, amount of disks in the server
     * @param disksCapacity, capacity of the disks of the server
     */

    public void asignToExisting(Company existingCompany, int serversAmount, int day, int month, int year, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        hostCompany = existingCompany;
        rentalDate = new Date(day, month, year);
        on = true;

        if(serversAmount<4){
            rentalValue += rentalValue*0.15;
        }

        rack = new Rack(serversAmount, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);

    }

    public double getTotalDiskCapacity(){
        return rack.getTotalDiskCapacity();
    }

    public double getTotalRamMemory(){
        return rack.getTotalRamMemory();
    }

    /**
     * This method untie the company of the mini room and gives the mini room its initial values
     */

    public void leaveMiniRoom(){
        rentalValue = baseRentalValue - calculateDiscounts();
        available = true;
        on = false;
        rentalDate = null;
        rack.deleteServers();
        hostCompany = null;
    }

}
