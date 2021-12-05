package model;

public class Company {
    protected String name;
    protected String nit;
    

    public Company(String name, String nit){
        this.name = name;
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
