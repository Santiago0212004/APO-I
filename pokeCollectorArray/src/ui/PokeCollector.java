package ui;

import java.util.Scanner;


import model.Collection;


public class PokeCollector {
	private Collection myCollection;
	private Scanner sc; 
	
	
	public PokeCollector() {
		sc= new Scanner(System.in);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PokeCollector pc= new PokeCollector();
		
	
		System.out.println("Iniciando la aplicación");
		
		int option=0;
		
		do{
			
			option= pc.showMenu();
			pc.executeOperation(option);
			
		}while (option!=0);
		
	}
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Menú principal, seleccione una opción\n" +
				"(1) Para crear una colección \n" +
				"(2) Para crear, editar o eliminar un álbum \n" +
				"(3) Para mostrar la información de los albums en la colección \n"+
				"(4) Para agregar un pokemon un álbum\n"+
				"(0) Para salir"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			createCollection() ;
			break;
		case 2:
			showMenuAlbum() ;
			break;
		case 3:
			System.out.println(myCollection.showAlbums());
			break;
	
		case 4:
			addPokeInAlbum();
			break;


		
		default:
			System.out.println("Error, opción no válida");
		
		}
	}

	private void createCollection() { // 
		System.out.println("Ingrese los datos de una colección");
		String nom;
		int day, month, year;

		System.out.println("nombre");
		nom= sc.nextLine();

		System.out.println("fecha");
		

		System.out.println("dia");
		day= sc.nextInt();
		sc.nextLine();

		System.out.println("mes");
		month= sc.nextInt();
		sc.nextLine();

		System.out.println("año");
		year= sc.nextInt();
		sc.nextLine();



		myCollection = new Collection(nom, day, month, year);

		System.out.println("La Colección  "+ nom + " fue creada");
		
	}



	private void addPokeInAlbum() {
		
		if(myCollection!=null){
		
			System.out.println("Escriba el id del album a añadir un pokemon: ");
			int idAlbum = sc.nextInt();
		
			while(id!=1 && id!=2 && id!=3){
				System.out.println("Escriba un numero valido: ");

				System.out.println("Escriba el numero del album a añadir un pokemon: ");
				idAlbum = sc.nextInt();
			}
			
			if(myCollection.albumExists(idAlbum)){
				System.out.println("Escriba el nombre del pokemon");
			}
			
			else{
				
			}
			
			
			
		
			
		}
		
		
	}
	
	

	private void showMenuAlbum() {
		int option=0;
		System.out.println(
				"Menú Album\n" +
				"(1) Para crear un álbum\n" +
				"(2) Para editar un álbum\n"+
				"(3) Para eliminar un álbum\n"+
				"(0) Para volver"
				);
		option= sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		case 1:
			createAlbum();
			break;
		case 2:
			editAlbum();
			break;
		case 3: 
			deleteAlbum();
			break;
		
		}
		
	}
	private void deleteAlbum() {
		System.out.println("Escriba el numero del album a eliminar:");
		int id = sc.nextInt();

		while(id!=1 && id!=2 && id!=3){
			System.out.println("Escriba un numero valido: ");

			System.out.println("Escriba el numero del album a editar:");
			id = sc.nextInt();
		}

		myCollection.deleteAlbum(id);
	}
	private void editAlbum() {
		System.out.println("Digite los datos del album a editar ");

		System.out.println("Escriba el numero del album a editar:");
		int id = sc.nextInt();

		while(id!=1 && id!=2 && id!=3){
			System.out.println("Escriba un numero valido: ");

			System.out.println("Escriba el numero del album a editar:");
			id = sc.nextInt();
		}

		System.out.println("Nombre de la región del album:");
		String nom= sc.nextLine();

		
		System.out.println("Cantidad de pokemones de la región");
		int num = sc.nextInt();
		sc.nextLine();

		myCollection.editAlbum(id, nom, num);

	}
	private void createAlbum() {
		
		if(myCollection!=null){
			if(myCollection.hasAlbums()) {

				System.out.println("Digite los datos del album a crear ");
	
	
				System.out.println("Nombre de la región del album:");
				String nom= sc.nextLine();
	
			
				System.out.println("Cantidad de pokemones de la región");
				int num = sc.nextInt();
				sc.nextLine();
							
	
				myCollection.addAlbum(nom, num);
	
				System.out.println("El album \""+ nom +"\" ha sido creado con éxito\n");
	
				
			}else {
				System.out.println("No puede crearse el álbum porque se llegó al límite\n");
			}
		}
		else{
			System.out.println("No tiene una coleccion creada.");
		}
		
		
		
	}

		

}
	

	
	
	


