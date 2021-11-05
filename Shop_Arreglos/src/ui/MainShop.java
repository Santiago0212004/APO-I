package ui;

import java.util.Scanner;
import model.Shop;


/**
 * Clase principal del proyecto candyShop.
 * Desarrollada para el 
 * @author angievig
 * @version 1.0
 * @since October 2021
 */
public class MainShop {
	
	/**
	 * store es la conexiOn con la clase Shop en el paquete model
	 */
	private Shop store;
	/**
	 * sc es el objeto que permite leer informaciOn digitada por el usuario
	 */
	private Scanner sc;
	
	/**
	 * Constructor de la clase, no recibe prametros.  
	 * El mEtodo inicializa el objeto lector 
	 */
	public MainShop() {
		sc= new Scanner(System.in);
	}
	

	public static void main (String[] args){
		// creando un objeto de la clase principal
		MainShop obPpal = new MainShop();
		obPpal.initShop();
		
		// variable para leer la entrada
		int option= 0;
		
		//ciclo para ejecutar el menu mientras que el usuario no
		// elija la opciOn para salir (0)
		do {
		    option =obPpal.showMenuAndGetOption();
		    obPpal.answerOption(option);
		}while (option !=0);


	}


	/**
	 * Metodo que se encarga de llamar a los mEtodos que resuelven cada uno de los 
	 * requerimientos de la aplicaciOn 
	 * @param userOption, int es el nUmero ingresado por el usuario (no ha sido validado) 
	 */
	public void answerOption(int userOption) {
		switch(userOption) {
		case 0: 
			System.out.println("cerrando la aplicaciOn, bye");
			break;
		case 1:
			sellProduct();
			break;
		case 2:
			break;
		case 3: 
			break;
		case 4: 
			registerProduct();
			break;
		case 5:
			System.out.println(store);
			System.out.println(store.productData());
			break;
		}
		
		
	}

	/** Requerimiento "Registrar producto"
	 * 
	 */
	
	public void registerProduct(){
		System.out.println("\n-------------Registrar Producto--------------\n");

		System.out.println("Ingrese el numero del producto: ");
		int numProduct = sc.nextInt();
		numProduct = numProduct - 1;

		System.out.println("Ingrese el nombre del producto: ");
		String nameProduct = sc.next();

		System.out.println("Ingrese la cantidad a vender del producto: ");
		int quantity = sc.nextInt();

		System.out.println("Ingrese el precio del producto: ");
		double price = sc.nextDouble();

		int productsAmount = store.getProductsAmount();

		while((numProduct<0 || numProduct>productsAmount)||(quantity<=0)||(price<=0)){
			System.out.println("\n--------------------Escriba datos válidos------------------\n");

			System.out.println("Ingrese el numero del producto: ");
			numProduct = sc.nextInt();
			numProduct = numProduct - 1;

			System.out.println("Ingrese el nombre del producto: ");
			nameProduct = sc.next();

			System.out.println("Ingrese la cantidad a vender del producto: ");
			quantity = sc.nextInt();

			System.out.println("Ingrese el precio del producto: ");
			price = sc.nextDouble();
		}

		if(store.verifyProduct(numProduct)){
			System.out.println("Desea sobreescribir el producto? \n1. Si \n2. No");
			int overwrite = sc.nextInt();

			while(overwrite!=1 && overwrite!=2){
				System.out.println("\nEscriba un valor valido");
				overwrite = sc.nextInt();
			}
			switch(overwrite){
				case 1:
					store.addProduct(numProduct, nameProduct, quantity, price);		
					System.out.println("\n--------------Producto registrado--------------");
					break;
				case 2:
					System.out.println("\n--------------Producto no registrado--------------");
					break;
			}
		}

		else{
			store.addProduct(numProduct, nameProduct, quantity, price);
			System.out.println("\n--------------Producto registrado--------------");
		}

		
	}

	/** Requerimiento "Vender Producto"
	 * 
	 */

	public void sellProduct(){
		System.out.println("\n----------Vender Producto----------\n");

		System.out.println("Escriba el numero del producto a comprar: ");
		int numProduct = sc.nextInt();
		numProduct = numProduct - 1;

		System.out.println("Escriba la cantidad a llevar: ");
		int quantityToBuy = sc.nextInt();

		int productsAmount = store.getProductsAmount();

		while((numProduct<0 || numProduct>productsAmount)||(quantityToBuy<=0)){
			System.out.println("\n--------------------Escriba datos válidos------------------\n");

			System.out.println("Escriba el numero del producto a comprar: ");
			numProduct = sc.nextInt();
			numProduct = numProduct - 1;

			System.out.println("Escriba la cantidad a llevar: ");
			quantityToBuy = sc.nextInt();
		}

		store.sellProduct(numProduct, quantityToBuy);
		System.out.println("\n--------------Producto vendido--------------");
	}


	/**
	 * Metodo que permite crear instancias de los objetos con informaciOn ingresada
	 * por el usuario
	 */
	public void initShop() {
		System.out.println("Bienvenido a la tienda de APO1, digite el nombre del  dueño");
		String name = sc.nextLine();

		System.out.println("Ahora digite la cantidad de productos: ");
		int productsAmount = sc.nextInt();

		store = new Shop(name, productsAmount);
		
	}
	
	/**
	 * Metodo que muestra el menu de la aplicaciOn, a este metod hace falta implementar la validaciOn
	 * del valor ingresado por el usuario
	 * @return input, int, es la opciOn elegida por el usuario
	 */
	public int showMenuAndGetOption() {
		int input;
		System.out.println("\n\nMenu de la Tienda, digite una opciOn\n"+ 
		                    "(1) Vender Producto\n" +
		                    "(2) Mostrar la cantidad de dinero en caja\n" +
		                    "(3) Consultar la disponibilidad de un product\n"+
							"(4) Registrar un producto\n"+
							"(5) Mostrar los datos de la tienda\n"+
		                    "(0) Para salir"
	
		);
		input = sc.nextInt();
		sc.nextLine();
		return input;
	}

}
