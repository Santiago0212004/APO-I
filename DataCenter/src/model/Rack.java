package model;

import java.util.ArrayList;

public class Rack {

    ArrayList<Server> hostedServers;

    private int hostedServersAmount;

    /**
     * Constructor of rack
     * @param hostedServersAmount, amount of servers that are going to be hosted
     * @param cacheMemory, cache memory of the server
     * @param processorsAmount, amount of processors in the server
     * @param processorsTrademark, trademark of the processors of the server
     * @param ramMemory, amount of ram memory in the server
     * @param disksAmount, amount of disks in the server
     * @param disksCapacity, capacity of the disks of the server
     */

    public Rack(int hostedServersAmount, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        hostedServers = new ArrayList<Server>();
        this.hostedServersAmount = hostedServersAmount;
        registerServers(hostedServersAmount, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity); 
    }

    public int getHostedServersAmount() {
        return hostedServersAmount;
    }

    public void setHostedServersAmount(int hostedServersAmount) {
        this.hostedServersAmount = hostedServersAmount;
    }

    /**
     * Registers all the servers in the rack
     * @param hostedServersAmount, amount of servers that are going to be hosted
     * @param cacheMemory, cache memory of the server
     * @param processorsAmount, amount of processors in the server
     * @param processorsTrademark, trademark of the processors of the server
     * @param ramMemory, amount of ram memory in the server
     * @param disksAmount, amount of disks in the server
     * @param disksCapacity, capacity of the disks of the server
     */

    public void registerServers(int hostedServersAmount, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        Server serverToAdd;
        Trademark trademarkOfProcessors = Trademark.NONE;

        switch(processorsTrademark){
            case 1:
                trademarkOfProcessors = Trademark.INTEL;
                break;
            case 2:
                trademarkOfProcessors = Trademark.AMD;
                break;
        }

        for(int i=0; i<hostedServersAmount; i++){
            serverToAdd = new Server(cacheMemory, processorsAmount, trademarkOfProcessors, ramMemory, disksAmount, disksCapacity);
            hostedServers.add(serverToAdd);
        }
    }

    /**
     * Gets the total disk capacity of the rack
     * @return totalDiskCapacity
     */

    public double getTotalDiskCapacity(){
        double totalDiskCapacity=0;

        for(int i=0; i<hostedServers.size(); i++){
            totalDiskCapacity += (hostedServers.get(i).getDisksAmount())*(hostedServers.get(i).getDisksCapacity());
        }

        return totalDiskCapacity;
    }

    /**
     * Gets the total ram memory of the rack
     * @return totalRamMemory
     */

    public double getTotalRamMemory(){
        double totalRamMemory=0;

        for(int i=0; i<hostedServers.size(); i++){
            totalRamMemory += hostedServers.get(i).getRamMemory();
        }

        return totalRamMemory;
    }

    /**
     * Deletes the servers of the rack
     */

    public void deleteServers(){
        hostedServers.clear();
    }

    

}
