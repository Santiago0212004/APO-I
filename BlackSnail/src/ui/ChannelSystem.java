/**
 * @author Santiago Barraza
 * @version 1.0.0
 */

package ui;

import java.util.Scanner;
import model.*;


public class ChannelSystem {
    private Channel blackSnail;
    private Scanner sc;
    private Product avengers, strangerThings, backToTheFuture, theWalkingDead, titanic;

    /**
     * This methond is the constructor of the main object and initializes the scanner.
     */

    public ChannelSystem(){
        sc = new Scanner(System.in);
    }

    public static void main(String[] args){
        ChannelSystem mySystem = new ChannelSystem();

        System.out.println("Initializing System");

        mySystem.initializeChannel();

        int option=0;
		
		do{
			
			option= mySystem.showMenu();
			mySystem.executeOperation(option);
			
		}while (option!=0);
    }

    /**
     * This method initializes the channel Black Snail with its data.
     */

    public void initializeChannel(){
        blackSnail = new Channel("10020030201", "Cra 3B #45-32", "www.blacksnail.com");
    }

    /**
     * Shows the menu, so the user select the option that he want to use.
     * @return option, int, it's the option that the user chose.
     */

    public int showMenu() {
		int option=0;

		System.out.println(
				"\nMain menu, select an option \n" +
				"(1) Create a new subscriber \n" +
				"(2) Deactivate a subscriber \n" +
				"(3) Show the number of active subscribers for each type of customer \n"+
				"(4) Show the name of the underage subscriber who has the highest number of hours willing to consume \n"+
                "(5) Create five products \n"+
				"(0) Exit\n" 
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}

    /**
     * Executes the operation that the user chose in the menu
     * @param operation, int, it's the option the user chose.
     */

    private void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			createSubscriber();
			break;
		case 2:
		    disactivateSubscriber();
			break;
		case 3:
			showActiveSubscribers();
			break;
		case 4:
			showBestUnderageSubscriber();
			break;
        case 5:
			createFiveProducts();
			break;

		default:
			System.out.println("\nERROR, select a valid option");
		}
	}

    /**
     * Creates a subscriber
     */

    public void createSubscriber(){
        String idNumber, name;
        int age, type;
        double hoursWillingToWatch;
        if(blackSnail.avaliableSpace()){

            System.out.println("\nWrite the id number: ");
            idNumber = sc.next();

            while(idNumber.equals("")){
                System.out.println("Can't enter an empty id. Write a valid one: ");
                type = sc.nextInt();
            }
            
            System.out.println("\nWrite the name: ");
            name = sc.nextLine();

            while(name.equals("")){
                System.out.println("Can't enter an empty name. Write a valid one: ");
                type = sc.nextInt();
            }

            System.out.println("\nEnter the age: ");
            age = sc.nextInt();

            System.out.println("\nWrite the hours willing to watch: ");
            hoursWillingToWatch = sc.nextDouble();

            System.out.println("\nWrite the type of client \n"+
                               "(1) NORMAL \n"+
                               "(2) GOLD \n"+
                               "(3) PLATINUM \n"+
                               "(4) DIAMOND"
                            );
            
            type = sc.nextInt();
            
            while(type!=1 && type!=2 && type!=3 && type!=4){
                System.out.println("Enter a valid option");
                type = sc.nextInt();
            }

            boolean added = blackSnail.addSubscriber(idNumber, name, age, hoursWillingToWatch, type);

            if(added){
                System.out.println("Subscriber added sucessfully");
            }
            else{
                System.out.println("The id number of the subscriber is repeated");
            }
        }
    }

    /**
     * Distativates the subscriber the user wants to. The subscriber is identified by his id number.
     */

    public void disactivateSubscriber(){
        String idNumber;

        System.out.println("\nWrite the idNumber of the subcriber you want to disactivate: ");
        idNumber = sc.next();

        boolean disactivated = blackSnail.disactivateSubscriber(idNumber);

        if(disactivated==true){
            System.out.println("\nSubscriber disactivated");
        }
        else{
            System.out.println("\nThat id number doesn't exist");
        }
    }

    /**
     * This method shows the active subscribers separated by rank
     */

    public void showActiveSubscribers(){
        System.out.println("\nThe amount of active subcribers is: "+blackSnail.getActiveSubscribers()+
        "\nAre distributed in this way: "+
        "\nNORMAL: "+blackSnail.getNormalSubscribers()+
        "\nGOLD: "+blackSnail.getGoldSubscribers()+
        "\nPLATINUM: "+blackSnail.getPlatinumSubscribers()+
        "\nDIAMOND: "+blackSnail.getDiamondSubscribers()+"\n");
    }
    
    /**
     * This method shows the underage subscriber who is willing to watch more hours than the rest.
     */

    public void showBestUnderageSubscriber(){
        if(blackSnail.findBestUnderageSubscriber().equals("")==false){
            System.out.println("The underage subscriber that will watch more hours is: "+blackSnail.findBestUnderageSubscriber());
        }
        else{
            System.out.println("There isn't an underage subscriber.");
        }
        
    }

    public void createFiveProducts(){
        avengers = new Movie("Muy buena", "Joe Russo", 25, 4, 2019, "Avengers: End Game", 16, Category.ACTION);
        strangerThings = new Serie("Buena", "Shawn Levy", 15, 8, 2016, "Eleven", StateOfSerie.UNCENSORED);
        backToTheFuture = new Movie("Excelente", "Robert Zemeckis", 10, 7, 1986, "Back To The Future", 16, Category.ACTION);
        theWalkingDead = new Serie("Muy buena", "Greg Nicotero", 31, 10, 2010, "Rick Grimes", StateOfSerie.CENSORED);
        titanic = new Movie("Excelente", "James Cameron", 13, 2, 1998, "Titanic", 16, Category.ROMANTIC);
    }
}
