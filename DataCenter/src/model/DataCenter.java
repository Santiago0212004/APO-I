package model;

import java.util.ArrayList;

public class DataCenter {
    private final double SERVER_PRICE = 500000;
    private MiniRoom miniRooms[][];
    ArrayList<Company> rentingCompanies = new ArrayList<Company>();
    

    public DataCenter(){
        miniRooms = new MiniRoom[8][50];
        miniRooms = createMiniRooms(miniRooms);
    }
    
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

    public boolean asignProject(String projectId, int roomId, int serversAmount, int day, int month, int year, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        boolean asigned = false;

        if(repeatedId(projectId)==false){
            for(int i=0; i<8 && !asigned; i++){
                for(int j=0; j<50 && !asigned; j++){
                    if(miniRooms[i][j].getRoomId()==roomId){
                        miniRooms[i][j].asignProject(projectId, serversAmount, day, month, year, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);
                        rentingCompanies.add(miniRooms[i][j].getHostCompany());
                        miniRooms[i][j].setAvailable(false);
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

}
