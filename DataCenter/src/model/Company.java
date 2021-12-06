package model;

public class Company{
    protected String name;
    protected String nit;
    
    /**
     * Constructor of company
     * @param name, name of the company
     * @param nit, NIT of the company
     */

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
