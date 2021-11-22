package model;

import java.util.ArrayList;

public class Rack {
    private int amountOfHostedServers;

    ArrayList<Server> servers = new ArrayList<Server>();

    public int getAmountOfHostedServers() {
        return amountOfHostedServers;
    }

    public void setAmountOfHostedServers(int amountOfHostedServers) {
        this.amountOfHostedServers = amountOfHostedServers;
    }

}
