package model;

public class Product{
    private String name;
    private int numProductsForSale;
    private int numProductSold;
    private double price;

    public Product(String name, int numProductsForSale, double price){
        this.name = name;
        this.numProductsForSale = numProductsForSale;
        this.price = price;
        numProductSold = 0;
    }

    public String getName(){
        return name;
    } 

    public void setName(String name){
        this.name = name;
    }

    public int getNumProductsForSale(){
        return numProductsForSale;
    }

    public void setNumProductsForSale(int numProductsForSale){
        this.numProductsForSale = numProductsForSale;
    }

    public int getNumProductsSold(){
        return numProductSold;
    }

    public void setNumProductsSold(int numProductSold){
        this.numProductSold = numProductSold;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String toString(){
        double numProductsInInventory = numProductsForSale-numProductSold;
        return "\n**** Datos del Producto ****"+"\nnombre: "+name+"\ncantidad de productos en el inventario: "+numProductsInInventory+"\nprecio del producto: "+price+"\ncantidad de productos vendidos: "+numProductSold;
    }

}