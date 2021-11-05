/**
 * @author Santiago Barraza
 * @version 1.0.0
 */

package ui;

import java.util.Scanner;
import model.Channel;


public class ChannelSystem {
    private Channel blackSnail;
    private Scanner sc;

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
                "(5) Create a Product\n"+
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
			createProduct();
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
        if(blackSnail.avaliableSpaceForSubscribers()){

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

    public void createProduct(){
        int typeOfProduct;
        boolean added;

        //Variables for both
        String title, synopsis, directorName;
        int day, month, year;
        

        //Variables for Serie
        String protagonistNames, trailer;
        int programmedEpisodesQuantity, publishedEpisodesQuantity, state;

        //Variables for movie
        String productor;
        int minimumAge, categoy;
        

        if(blackSnail.availableSpaceForProducts()){

            System.out.println("\nEnter the title: ");
            title = sc.nextLine();

            while(title.equals("")){
                System.out.println("Can't enter an empty title. Write a valid one: ");
                title = sc.nextLine();
            }
            
            System.out.println("\n----------Digit the premiere date------\n");

            System.out.println("Day: ");
            day = sc.nextInt();
            sc.nextLine();

            System.out.println("Month: ");
            month = sc.nextInt();
            sc.nextLine();

            System.out.println("Year: ");
            year = sc.nextInt();
            sc.nextLine();

            while(day<0 || month<0 || year<0){
                System.out.println("\nWrite a valid date");

                System.out.println("Day: ");
                day = sc.nextInt();
                sc.nextLine();

                System.out.println("Month: ");
                month = sc.nextInt();
                sc.nextLine();

                System.out.println("Year: ");
                year = sc.nextInt();
                sc.nextLine();  
            }

            System.out.println("\nWrite a synopsis: ");
            synopsis = sc.nextLine();

            while(synopsis.equals("")){
                System.out.println("\nCan't enter an empty synopsis. Write a valid one: ");
                synopsis = sc.nextLine();
            }

            System.out.println("\nWrite the name of the director: ");
            directorName = sc.nextLine();

            while(directorName.equals("")){
                System.out.println("\nCan't enter an empty director name. Write a valid one: ");
                directorName = sc.nextLine();
            }
            

            System.out.println("\nWrite the type of product \n"+
                               "(1) Serie \n"+
                               "(2) Movie \n"
                            );
            
            typeOfProduct = sc.nextInt();
            sc.nextLine();
            
            while(typeOfProduct!=1 && typeOfProduct!=2){
                System.out.println("\nEnter a valid option: ");
                typeOfProduct = sc.nextInt();
                sc.nextLine();
            }

            if(typeOfProduct==1){

                System.out.println("\nWrite the name of the protagonists (Separated by commas): ");
                protagonistNames = sc.nextLine();

                while(protagonistNames.equals("")){
                    System.out.println("\nYou must write at least one name: ");
                    protagonistNames = sc.nextLine();
                }

                System.out.println("\nEnter the state of the serie \n"+
                               "(1) CENSORED \n"+
                               "(2) UNCENSORED \n"
                            );

                state = sc.nextInt();
                sc.nextLine();

                while(state!=1 && state!=2){
                    System.out.println("Enter a valid option");
                    state = sc.nextInt();
                    sc.nextLine();
                }

                System.out.println("---------------Write the data of the first season-------------");

                System.out.println("\nDigit the number of programmed episodes");
                programmedEpisodesQuantity = sc.nextInt();
                sc.nextLine();
                
                System.out.println("\nDigit the number of published episodes");
                publishedEpisodesQuantity = sc.nextInt();
                sc.nextLine();   

                while(programmedEpisodesQuantity<0 || publishedEpisodesQuantity<0){
                    System.out.println("\nWrite valid quantities");
    
                    System.out.println("\nDigit the number of programmed episodes: ");
                    programmedEpisodesQuantity = sc.nextInt();
                    sc.nextLine();
                
                    System.out.println("\nDigit the number of published episodes: ");
                    publishedEpisodesQuantity = sc.nextInt();
                    sc.nextLine();   
                }
                
                System.out.println("\nWrite the trailer URL: ");
                trailer = sc.nextLine();

                while(trailer.equals("")){
                    System.out.println("\nCan't enter an empty trailer URL. Write a valid one: ");
                    trailer = sc.nextLine();
                }

                added = blackSnail.addSerie(title, synopsis, directorName, day, month, year, protagonistNames, state, programmedEpisodesQuantity, publishedEpisodesQuantity, trailer);

                if(added){
                    System.out.println("\nSerie added sucessfully");
                }
                else{
                    System.out.println("\nCouldn't create the serie");
                }

            }

            if(typeOfProduct==2){
                System.out.println("\nWrite the name of the productor of the movie: ");
                productor = sc.nextLine();

                while(productor.equals("")){
                    System.out.println("\nProduct name can't be empty, write a valid one: ");
                    productor = sc.nextLine();
                }

                System.out.println("\nWrite the recommended minimum age to watch the movie: ");
                minimumAge = sc.nextInt();
                sc.nextLine();
                
                while(minimumAge<0){
                    System.out.println("\nWrite a valid minimum age: ");
                    minimumAge = sc.nextInt();
                    sc.nextLine();
                }

                System.out.println("\nWrite the category of the movie \n"+
                               "(1) Romantic \n"+
                               "(2) Action \n"+
                               "(3) Suspense \n"+
                               "(4) Horror \n"+
                               "(5) Comedy \n"
                            );
            
                categoy = sc.nextInt();
                sc.nextLine();

                while(categoy<1 && categoy>5){
                    System.out.println("\nWrite a valid movie category: ");
                    categoy = sc.nextInt();
                    sc.nextLine();
                }

                added = blackSnail.addMovie(title, synopsis, directorName, day, month, year, productor, minimumAge, categoy);

                if(added){
                    System.out.println("\nMovie added sucessfully");
                }
                else{
                    System.out.println("\nCouldn't create the movie");
                }
            }

        }
    }

}
