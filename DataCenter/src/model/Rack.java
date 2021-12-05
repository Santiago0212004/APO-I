package model;

import java.util.ArrayList;

public class Rack {

    ArrayList<Server> hostedServers;

    private int hostedServersAmount;

    public Rack(int hostedServersAmount, double cacheMemory, int processorsAmount, int processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        hostedServers = new ArrayList<Server>();
        this.hostedServersAmount = hostedServersAmount;
    }

    public int getHostedServersAmount() {
        return hostedServersAmount;
    }

    public void setHostedServersAmount(int hostedServersAmount) {
        this.hostedServersAmount = hostedServersAmount;
    }

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

    

}
