package model;

import java.util.ArrayList;

public class DataCenter {
    private final double SERVER_PRICE = 500000;

    private MiniRoom miniRooms[][];
    private MiniRoom simulationMiniRooms[][];
    ArrayList<Company> rentingCompanies = new ArrayList<Company>();
    
    /**
     * Initializes the data center creating the mini rooms and a set of simulation mini rooms
     */

    public DataCenter(){
        miniRooms = new MiniRoom[8][50];
        miniRooms = createMiniRooms(miniRooms);
        
        simulationMiniRooms = new MiniRoom[8][50];
        simulationMiniRooms = miniRooms;
    }

    /**
     * Recieves an empty set of mini rooms and creates in it every mini room with its initial values
     * @param miniRooms, this is the empty set of miniRooms
     * @return, set of mini rooms when they are created
     */
    
    public MiniRoom[][] createMiniRooms(MiniRoom[][] miniRooms){
        int x = 1;
        for(int i=0; i<8; i++){
            for(int j=0; j<50; j++){
                miniRooms[i][j] = new MiniRoom(i,j,SERVER_PRICE,x);
                x++;
            }
        }
        return miniRooms;
    }

    public ArrayList<Company> getRentingCompanies(){
        return rentingCompanies;
    }

    /**
     * Search for minirooms that are available
     * @return, information of every available mini room
     */

    public String showAvailableMiniRooms(){

        String availables="\n-----------------------Available mini rooms-----------------------\n";

        for(int i=0; i<8; i++){
            for(int j=0; j<50; j++){
                if(miniRooms[i][j].isAvailable()){
                    String onWindow;

                    if(miniRooms[i][j].isOnWindow()){
                        onWindow = "Yes";
                    }
                    else{
                        onWindow = "No";
                    }

                    availables += "\n Miniroom number: "+miniRooms[i][j].getRoomId()+
                                  "\n Row: "+(miniRooms[i][j].getRow()+1)+
                                  "\n Column: "+(miniRooms[i][j].getColumn()+1)+
                                  "\n On window: "+onWindow+
                                  "\n Rental price: "+miniRooms[i][j].getRentalValue()+"\n";
                }
            }
        }

        availables += "\n----------------------------------------------------------------------\n";

        return availables;
    }

    /**
     * Show availability of an especific mini room
     * @param roomId, the id of the mini room
     * @return, available
     */

    public boolean showAvailability(int roomId){
        boolean found = false;
        boolean available = false;

        for(int i=0; i<8 && !found; i++){
            for(int j=0; j<50 && !found; j++){
                if(miniRooms[i][j].getRoomId()==roomId){
                    if(miniRooms[i][j].isAvailable()){
                        available = true;
                    }
                    else{
                        available = false;
                    }
                    found = true;
                }
            }
        }

        return available;
    }

    /**
     * @param roomId, id of the mini room
     * @return price of the mini room
     */

    public double showPriceOfMiniroom(int roomId){
        boolean found = false;
        double price=0;

        for(int i=0; i<8 && !found; i++){
            for(int j=0; j<50 && !found; j++){
                if(miniRooms[i][j].getRoomId()==roomId){
                    price = miniRooms[i][j].getRentalValue();
                    found = true;
                }
            }
        }

        return price;
    }

    /**
     * Looks for a company that has the same NIT than the given one
     * @param companyNit, given NIT
     * @return repeated
     */

    public boolean repeatedNit(String companyNit){
        boolean repeated = false;

        for(int i=0; i<8 && !repeated; i++){
            for(int j=0; j<50 && !repeated; j++){
                if(miniRooms[i][j].getNitOfTheCompany().equalsIgnoreCase(companyNit)){
                    repeated = true;
                }
            }
        }

        return repeated;
    }

    /**
     * Looks for a project that has the same ID than the given one
     * @param projectId, id of the project
     * @return repeated
     */

    public boolean repeatedId(String projectId){
        boolean repeated = false;

        for(int i=0; i<8 && !repeated; i++){
            for(int j=0; j<50 && !repeated; j++){
                if(miniRooms[i][j].getIdOfIcesiProject().equalsIgnoreCase(projectId)){
                    repeated = true;
                }
            }
        }

        return repeated;
    }

    /**
     * Asign a mini room to a company
     * @param companyName, name of the company
     * @param companyNit, nit of the company
     * @param roomId, id of the mini room
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
     * @return asigned
     */

    public boolean asignCompany(String companyName, String companyNit, int roomId, int serversAmount, int day, int month, int year, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        boolean asigned = false;

        if(repeatedNit(companyNit)==false){
            for(int i=0; i<8 && !asigned; i++){
                for(int j=0; j<50 && !asigned; j++){
                    if(miniRooms[i][j].getRoomId()==roomId){
                        miniRooms[i][j].asignCompany(companyName, companyNit, serversAmount, day, month, year, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);
                        rentingCompanies.add(miniRooms[i][j].getHostCompany());
                        miniRooms[i][j].setAvailable(false);
                        asigned = true;
                    }
                }
            }
        }

        return asigned;
        
    }

    /**
     * Asign a mini room to an ICESI project
     * @param projectId, id of the project
     * @param roomId, id of the mini room
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
     * @return asigned
     */

    public boolean asignProject(String projectId, int roomId, int serversAmount, int day, int month, int year, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        boolean asigned = false;

        if(repeatedId(projectId)==false){
            for(int i=0; i<8 && !asigned; i++){
                for(int j=0; j<50 && !asigned; j++){
                    if(miniRooms[i][j].getRoomId()==roomId){
                        miniRooms[i][j].asignProject(projectId, serversAmount, day, month, year, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);
                        rentingCompanies.add(miniRooms[i][j].getHostCompany());
                        miniRooms[i][j].setAvailable(false);
                        miniRooms[i][j].setOn(true);
                        asigned = true;
                    }
                }
            }
        }

        else{
            asigned = false;
        }
        

        return asigned;
    }

    /**
     * Show companies that are renting in the moment
     * @return companies
     */

    public String showRentingCompanies(){
        String companies="----------------List of Hosts----------------------------------";

        for(int i=0; i<rentingCompanies.size(); i++){
            if(rentingCompanies.get(i) instanceof IcesiProject){
                companies += "\n"+(i+1)+". Icesi investigation project "+((IcesiProject) rentingCompanies.get(i)).getProjectId();
            }
            else{
                companies += "\n"+(i+1)+". "+rentingCompanies.get(i).getName();
            }
        }

        companies+="\n----------------------------------------------------------------";

        return companies;
    }

    /**
     * Asign a mini room to a company that already exists
     * @param companyOption, the number of the company that the user chose
     * @param roomId, id of the mini room
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
     * @return asigned
     */

    public boolean asignToExistingCompany(int companyOption, int roomId, int serversAmount, int day, int month, int year, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        boolean asigned = false;
        companyOption = companyOption - 1;

        Company existingCompany = rentingCompanies.get(companyOption);

        for(int i=0; i<8 && !asigned; i++){
            for(int j=0; j<50 && !asigned; j++){
                if(miniRooms[i][j].getRoomId()==roomId){
                    miniRooms[i][j].asignToExisting(existingCompany, serversAmount, day, month, year, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);
                    miniRooms[i][j].setAvailable(false);
                    asigned = true;
                }
            }
        }

        return asigned;
    }

    /**
     * Cancels the rent of all mini rooms
     * @param companyNumber, the number of the company that the user chose
     * @return processabilty
     */

    public String cancelRentOfAllRooms(int companyNumber){
        String processability = "";
        double totalDiskCapacity=0, totalRamMemory=0;

        companyNumber = companyNumber - 1;

        Company companyToCancel = rentingCompanies.get(companyNumber);

        

        if(companyToCancel instanceof IcesiProject){
            for(int i=0; i<8; i++){
                for(int j=0; j<50; j++){
                    if(miniRooms[i][j].isAvailable()==false){
                        if(((IcesiProject) companyToCancel).getProjectId().equalsIgnoreCase(((IcesiProject) miniRooms[i][j].getHostCompany()).getProjectId())){
                            totalDiskCapacity += miniRooms[i][j].getTotalDiskCapacity();
                            totalRamMemory += miniRooms[i][j].getTotalRamMemory();
                            miniRooms[i][j].leaveMiniRoom();
                            rentingCompanies.remove(companyNumber);
                        }
                    }
                }
            }
        }
        else{
            for(int i=0; i<8; i++){
                for(int j=0; j<50; j++){
                    if(miniRooms[i][j].isAvailable()==false){
                        if(companyToCancel.getNit().equalsIgnoreCase(miniRooms[i][j].getHostCompany().getNit())){
                            totalDiskCapacity += miniRooms[i][j].getTotalDiskCapacity();
                            totalRamMemory += miniRooms[i][j].getTotalRamMemory();
                            miniRooms[i][j].leaveMiniRoom();
                            rentingCompanies.remove(companyNumber);
                        }
                    }
                }
            }
        }

        processability = "\nTotal disk capacity: "+totalDiskCapacity+"tb"+
                         "\nTotal ram memory: "+totalRamMemory+"gb\n";
    
        return processability+"\nRENT CANCELED";
    }

    /**
     * Cancels the rent of an especific mini room of the company
     * @param companyNumber, the number of the company that the user chose
     * @param roomId, id of the mini room that is going to be canceled
     * @return processabilty
     */

    public String cancelRentOfARoom(int companyNumber, int roomId){
        boolean canceled = false;

        String processability = "";
        double totalDiskCapacity=0, totalRamMemory=0;

        companyNumber = companyNumber - 1;

        Company companyToCancel = rentingCompanies.get(companyNumber);

        

        if(companyToCancel instanceof IcesiProject){
            for(int i=0; i<8 && !canceled; i++){
                for(int j=0; j<50 && !canceled; j++){
                    if(miniRooms[i][j].isAvailable()==false){
                        if((((IcesiProject) companyToCancel).getProjectId().equalsIgnoreCase(((IcesiProject) miniRooms[i][j].getHostCompany()).getProjectId())) && (miniRooms[i][j].getRoomId()==roomId)){
                            totalDiskCapacity += miniRooms[i][j].getTotalDiskCapacity();
                            totalRamMemory += miniRooms[i][j].getTotalRamMemory();
                            miniRooms[i][j].leaveMiniRoom();

                            if(amountOfRents(companyNumber, 1)<1){
                                rentingCompanies.remove(companyNumber);
                            }

                            canceled = true;
                        }
                    }
                }
            }
        }
        else{
            for(int i=0; i<8 && !canceled; i++){
                for(int j=0; j<50 && !canceled; j++){
                    if(miniRooms[i][j].isAvailable()==false){
                        if((companyToCancel.getNit().equalsIgnoreCase(miniRooms[i][j].getHostCompany().getNit())) && (miniRooms[i][j].getRoomId()==roomId)){
                            totalDiskCapacity += miniRooms[i][j].getTotalDiskCapacity();
                            totalRamMemory += miniRooms[i][j].getTotalRamMemory();
                            miniRooms[i][j].leaveMiniRoom();

                            if(amountOfRents(companyNumber, 0)<1){
                                rentingCompanies.remove(companyNumber);
                            }

                            canceled = true;
                        }
                    }
                }
            }
        }

        if(canceled){
            processability = "\nTotal disk capacity: "+totalDiskCapacity+"tb"+
                             "\nTotal ram memory: "+totalRamMemory+"gb\n\nRENT CANCELED";
        }
        else{
            processability = "Couldn't find a mini room rented by this company with the id";
        }

        
    
        return processability;
    }

    /**
     * Calculates the amount of renting servers that a company has (if it is zero, the company dissapears of the list)
     * @param companyNumber, the company that the user chose
     * @param type, 0 if company, 1 if Icesi project
     * @return, amount of rents
     */

    public int amountOfRents(int companyNumber, int type){
        int amount = 0;

        if(type==0){
            for(int i=0; i<8; i++){
                for(int j=0; j<50; j++){
                    if(miniRooms[i][j].getHostCompany()!=null){
                        if(rentingCompanies.get(companyNumber).getNit().equalsIgnoreCase(miniRooms[i][j].getHostCompany().getNit())){
                            amount++;
                        }
                    }
                }
            }
        }

        if(type==1){
            for(int i=0; i<8; i++){
                for(int j=0; j<50; j++){
                    if(miniRooms[i][j].getHostCompany()!=null){
                        if(miniRooms[i][j].getHostCompany() instanceof IcesiProject){
                            if(((IcesiProject) rentingCompanies.get(companyNumber)).getProjectId().equalsIgnoreCase(((IcesiProject) miniRooms[i][j].getHostCompany()).getProjectId())){
                                amount++;
                            }
                        }
                    }
                }
            }
        }

        return amount;
    }

    /**
     * Shows the id of a mini room given its row and column
     * @param row, row of the mini room
     * @param column, column of the mini room
     * @return id of the mini room
     */

    public int getIdOfRoom(int row, int column){
        return miniRooms[row][column].getRoomId();
    }

    /**
     * Shows if a mini room is on or off given its row and column
     * @param row, row of the mini room
     * @param column, column of the mini room
     * @return status of the mini room
     */

    public boolean miniRoomOn(int row, int column){
        return miniRooms[row][column].isOn();
    }

    /**
     * Turns off every mini room of the simulation
     */

    public void turnOnSimulation(){
        for(int i=0; i<8; i++){
            for(int j=0; j<50; j++){
                simulationMiniRooms[i][j].setOn(true);
            }
        }
    }

    /**
     * Executes the L simulation
     */

    public void simulationL(){
        for(int i=0; i<8; i++){
            for(int j=0; j<50; j++){
                if(i==0 || j==0){
                    simulationMiniRooms[i][j].setOn(false);
                }
            }
        }
    }

    /**
     * Executes the Z simulation
     */

    public void simulationZ(){
        for(int i=0; i<8; i++){
            for(int j=0; j<50; j++){
                if(i==0 || i==7){
                    simulationMiniRooms[i][j].setOn(false);
                }
            }
        }

        for(int i=0; i<8; i++){
            for(int j=48; j>=1; j-=6){
                simulationMiniRooms[i][j].setOn(false);
                i++;
            }
        }

    }

    /**
     * Executes the H simulation
     */

    public void simulationH(){
        for(int i=0; i<8; i++){
            for(int j=0; j<50; j++){
                if((i+1)%2==0){
                    simulationMiniRooms[i][j].setOn(false);
                }
            }
        }
    }

    /**
     * Executes the O simulation
     */

    public void simulationO(){
        for(int i=0; i<8; i++){
            for(int j=0; j<50; j++){
                if(simulationMiniRooms[i][j].isOnWindow()){
                    simulationMiniRooms[i][j].setOn(false);
                }
            }
        }
    }

    /**
     * Executes M simulation
     * @param n, column that user chose
     */

    public void simulationM(int n){
        for(int i=0; i<8; i++){
            for(int j=0; j<50; j++){
                if(j==(n-1)){
                    simulationMiniRooms[i][j].setOn(false);
                }
            }
        }
    }

    /**
     * Executes P simulation
     * @param m, corridor user chose
     */

    public void simulationP(int m){
        for(int i=0; i<8; i++){
            for(int j=0; j<50; j++){
                if(i==(m-1)){
                    simulationMiniRooms[i][j].setOn(false);
                }
            }
        }
    }

    /**
     * Shows the id of a simulation mini room given its row and column
     * @param row, row of the mini room
     * @param column, column of the mini room
     * @return id of the mini room
     */

    public int getIdOfSimulationRoom(int row, int column){
        return simulationMiniRooms[row][column].getRoomId();
    }

    /**
     * Shows if a simulation mini room is on or off given its row and column
     * @param row, row of the mini room
     * @param column, column of the mini room
     * @return status of the mini room
     */

    public boolean simulationMiniRoomOn(int row, int column){
        return simulationMiniRooms[row][column].isOn();
    }

}
