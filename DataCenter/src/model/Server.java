package model;

public class Server {
    private double cacheMemory;
    private int processorsAmount;
    private Trademark processorsTrademark;
    private double ramMemory;
    private int disksAmount;
    private double disksCapacity;

    /**
     * Constructor of server
     * @param cacheMemory, cache memory of the server
     * @param processorsAmount, amount of processors in the server
     * @param processorsTrademark, trademark of the processors of the server
     * @param ramMemory, amount of ram memory in the server
     * @param disksAmount, amount of disks in the server
     * @param disksCapacity, capacity of the disks of the server
     */

    public Server(double cacheMemory, int processorsAmount, Trademark processorsTrademark, double ramMemory, int disksAmount, double disksCapacity){
        this.cacheMemory = cacheMemory;
        this.processorsAmount = processorsAmount;
        this.processorsTrademark = processorsTrademark;
        this.ramMemory = ramMemory;
        this.disksAmount = disksAmount;
        this.disksCapacity = disksCapacity;
    }

    public double getCacheMemory() {
        return cacheMemory;
    }

    public void setCacheMemory(double cacheMemory) {
        this.cacheMemory = cacheMemory;
    }

    public int getProcessorsAmount() {
        return processorsAmount;
    }

    public void setProcessorsAmount(int processorsAmount) {
        this.processorsAmount = processorsAmount;
    }

    public Trademark getProcessorsTrademark() {
        return processorsTrademark;
    }

    public void setProcessorsTrademark(Trademark processorsTrademark) {
        this.processorsTrademark = processorsTrademark;
    }

    public double getRamMemory() {
        return ramMemory;
    }

    public void setRamMemory(double ramMemory) {
        this.ramMemory = ramMemory;
    }

    public int getDisksAmount() {
        return disksAmount;
    }

    public void setDisksAmount(int disksAmount) {
        this.disksAmount = disksAmount;
    }

    public double getDisksCapacity() {
        return disksCapacity;
    }

    public void setDisksCapacity(double disksCapacity) {
        this.disksCapacity = disksCapacity;
    }

}
