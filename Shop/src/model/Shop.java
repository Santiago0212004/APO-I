package model;

public class Shop{

    private String owner;
    private double totalSales;

    private Product product1;
    private Product product2;
    private Product product3;

    public Shop(String owner){
        this.owner = owner;
    }

    //Getters and setters of owner

    public String getOwner(){
        return owner;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    //Getters and setters of totalSales

    public double getTotalSales(){
        return totalSales;
    }

    public void setTotalSales(double totalSales){
        this.totalSales = totalSales;
    }

    //Getters and setters of product1

    public Product getProduct1(){
        return product1;
    }

    public void setProduct1(Product product1){
        this.product1 = product1;
    }

    //Getters and setters of product2

    public Product getProduct2(){
        return product2;
    }

    public void setProduct2(Product product2){
        this.product2 = product2;
    }

    //Getters and setters of product3

    public Product getProduct3(){
        return product3;
    }

    public void setProduct3(Product product3){
        this.product3 = product3;
    }

    //Add product

    /** Metodo que 
     * 
     * @param numProduct
     * @param name
     * @param quantity
     * @param price
     */

    public void addProduct(int numProduct, String name, int quantity, double price){

        switch(numProduct){
            case 1:
                product1 = new Product(name, quantity, price);
                break;
            case 2:
                product2 = new Product(name, quantity, price);
                break;
            case 3:
                product3 = new Product(name, quantity, price);
                break;
        }

    }

    /** Metodo que verifica si un producto ya esta registrado
     * 
     * @param numProduct, int es el id del producto, es un numero entre 1 u3
     * @return out, boolean que es true si el prodcuto esta registrado,
     * false en el caso contrario
     */

    public boolean verifyProduct(int numProduct){

        boolean out=false;

        switch(numProduct){
            case 1:
                out = product1!=null;
                break;
            case 2:
                out = product2!=null;
                break;
            case 3:
                out = product3!=null;
                break;
        }
        return out;
    }

    //To String

    public String toString(){
		int vendidos = 0;
		
		if(product1 != null){
			vendidos += product1.getNumProductsSold();
		}
		if(product2 != null){
			vendidos += product2.getNumProductsSold();
		}
		if(product3 != null){
			vendidos += product3.getNumProductsSold();
		}
		
        return "**** Datos de la tienda ****\n"+
		"nombre del dueño: "+owner+
		"\ncantidad de dinero en caja: "+totalSales+
		"\ncantidad de productos vendidos: "+vendidos;
    }
}