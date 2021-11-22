package model;

public class Server {
    private int amountOfProcessors;
    private int amountOfDisks;

    private double cacheMemory;
    private double disksCapacity;
    private double ramMemory;

    

    private Processor serverProccesor;

    public Server(int amountOfProcessors, int amountOfDisks, double cacheMemory, double disksCapacity, double ramMemory, Processor serverProccesor){
        this.amountOfProcessors = amountOfProcessors;
        this.amountOfDisks = amountOfDisks;
        this.cacheMemory = cacheMemory;
        this.disksCapacity = disksCapacity;
        this.ramMemory = ramMemory;
        this.serverProccesor = serverProccesor;
    }

    public int getAmountOfProcessors() {
        return amountOfProcessors;
    }

    public void setAmountOfProcessors(int amountOfProcessors) {
        this.amountOfProcessors = amountOfProcessors;
    }

    public int getAmountOfDisks() {
        return amountOfDisks;
    }

    public void setAmountOfDisks(int amountOfDisks) {
        this.amountOfDisks = amountOfDisks;
    }

    public double getChacheMemory() {
        return chacheMemory;
    }

    public void setChacheMemory(double chacheMemory) {
        this.chacheMemory = chacheMemory;
    }

    public double getDisksCapacity() {
        return disksCapacity;
    }

    public void setDisksCapacity(double disksCapacity) {
        this.disksCapacity = disksCapacity;
    }

    public double getRamMemory() {
        return ramMemory;
    }

    public void setRamMemory(double ramMemory) {
        this.ramMemory = ramMemory;
    }

    public Processor getServerProccesor() {
        return serverProccesor;
    }

    public void setServerProccesor(Processor serverProccesor) {
        this.serverProccesor = serverProccesor;
    }

}
