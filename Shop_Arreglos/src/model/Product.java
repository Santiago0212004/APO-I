package model;

public class Product{
    private String name;
    private int numProductsForSale;
    private int numProductSold;
    private double price;

    /** Constructor de la clase product
     * 
     * @param name, nombre del producto
     * @param numProductsForSale, numero de productos a vender
     * @param price, precio del producto
     */

    public Product(String name, int numProductsForSale, double price){
        this.name = name;
        this.numProductsForSale = numProductsForSale;
        this.price = price;
        numProductSold = 0;
    }

    /** Obtiene el nombre del producto
     * 
     * @return name, es el nombre del producto
     */

    public String getName(){
        return name;
    } 

    /** Cambia el nombre del producto al que se obtiene por parametro
     * 
     * @param name, nombre del producto
     */

    public void setName(String name){
        this.name = name;
    }

    /** Obtiene la cantidad a vender del producto
     * 
     * @return numProductsForSale 
     */

    public int getNumProductsForSale(){
        return numProductsForSale;
    }

    /** Cambia la cantidad del producto por la que se obtiene por parametro
     *
     * @param numProductsForSale, unidades a vender del producto
     */

    public void setNumProductsForSale(int numProductsForSale){
        this.numProductsForSale = numProductsForSale;
    }

    /** Obtiene la cantidad vendida del producto
     * 
     * @return numProductsSold
     */

    public int getNumProductsSold(){
        return numProductSold;
    }

    /** Cambia la cantidad vendida a la que se obtiene por parametro
     * 
     * @param numProductSold, cantidad vendida
     */

    public void setNumProductsSold(int numProductSold){
        this.numProductSold = numProductSold;
    }

    /** Obtiene el precio del producto
     * 
     * @return price
     */

    public double getPrice(){
        return price;
    }

    /** Cambia el precio del producto por el que se obtiene por parámetro
     * 
     * @param price, precio del producto
     */

    public void setPrice(double price){
        this.price = price;
    }

    /** Vende un producto con la cantidad que desee el usuario
     * 
     * @param quantityToBuy, cantidad a comprar
     */

    public void sellProduct(int quantityToBuy){
        numProductSold += quantityToBuy;
    }

    public String toString(){
        double numProductsInInventory = numProductsForSale-numProductSold;
        return "\n**** Datos del Producto ****"+"\nnombre: "+name+"\ncantidad de productos en el inventario: "+numProductsInInventory+"\nprecio del producto: "+price+"\ncantidad de productos vendidos: "+numProductSold;
    }

}