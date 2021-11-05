package model;

public class Shop{

    private String owner;
    private int productsAmount;
    private double totalSales;

    private Product[] products;

    public Shop(String owner, int productsAmount){
        this.owner = owner;
        this.productsAmount = productsAmount;
        
        products = new Product[this.productsAmount];
    }

    //Getters and setters of owner

    /** Obtiene el nombre del dueño
     * 
     * @return owner
     */

    public String getOwner(){
        return owner;
    }

    /** Cambia el nombre del dueño por el que se obtiene por parametro
     * 
     * @param owner, nombre del dueño
     */

    public void setOwner(String owner){
        this.owner = owner;
    }

    //Getters and setters of productsAmount

    /** Obtiene la cantidad de productos que hay para vender
     * 
     * @return productsAmount
     */

    public int getProductsAmount(){
        return productsAmount;
    }

    /** Cambia la cantidad de productos por la que se obtiene por parametro
     * 
     * @param productsAmount, cantidad de productos
     */

    public void setProductsAmount(int productsAmount){
        this.productsAmount = productsAmount;
    }

    //Getters and setters of totalSales

    /** Obtiene las ventas totales
     * 
     * @return totalSales
     */

    public double getTotalSales(){
        return totalSales;
    }

    /** Cambia las ventas totales a las que se obtienen por parametro
     * 
     * @param totalSales, ventas totales
     */

    public void setTotalSales(double totalSales){
        this.totalSales = totalSales;
    }

    //Add product

    /** Añade un producto, teniendo en cuenta la posicion que el usuario elegió, entonces ejecuta el constructor
     * 
     * @param numProduct, numero del producto
     * @param name, nombre del producto
     * @param quantity, cantidad a vender de ese producto
     * @param price, precio del producto
     */

    public void addProduct(int numProduct, String name, int quantity, double price){

        products[numProduct] = new Product(name, quantity, price);

    }

    /** Metodo que verifica si un producto ya esta registrado
     * 
     * @param numProduct, int, es el id del producto
     * @return out, boolean que es true si el prodcuto esta registrado,
     * false en el caso contrario
     */

    public boolean verifyProduct(int numProduct){

        boolean out=false;

        out = products[numProduct]!=null;

        return out;
    }

    /** Metodo que vende un producto
     * 
     * @param numProduct, int, es el id del producto
     * @param quantityToBuy, int, es la cantidad a comprar de ese producto
     */

    public void sellProduct(int numProduct, int quantityToBuy){
        products[numProduct].sellProduct(quantityToBuy);
    }

    /** Crea un string con los datos de todos los productos registrados
     * 
     * @return data 
     */

    public String productData(){
        String data = "";
        for(int i=0; i<productsAmount; i++){
            if(products[i] != null){
                data += products[i]+"\n";
            }
        }
        return data;
    }

    //To String

    public String toString(){
        int vendidos = 0;
        
        for(int i=0; i<productsAmount; i++){
            if(products[i] != null){
                vendidos += products[i].getNumProductsSold();
                totalSales += products[i].getNumProductsSold()*products[i].getPrice();
            }
        }
		
        return "**** Datos de la tienda ****\n"+
		"nombre del dueño: "+owner+
		"\ncantidad de dinero en caja: "+totalSales+
		"\ncantidad de productos vendidos: "+vendidos;
    }
}