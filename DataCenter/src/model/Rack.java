package model;

public class Rack {
    private int amountOfHostedServers;

    private Server[] servers; 

    public Rack(int amountOfHostedServers){
        this.amountOfHostedServers = amountOfHostedServers;
        servers = new Server[amountOfHostedServers];
    }

    public int getAmountOfHostedServers() {
        return amountOfHostedServers;
    }

    public void setAmountOfHostedServers(int amountOfHostedServers) {
        this.amountOfHostedServers = amountOfHostedServers;
    }

}
