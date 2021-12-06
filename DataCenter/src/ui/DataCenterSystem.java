package ui;

import java.util.Scanner;
import java.util.ArrayList;
import model.DataCenter;

public class DataCenterSystem {
    private Scanner sc;
    private DataCenter myDataCenter;

	/**
	 * Initializes the system
	 */

    public DataCenterSystem(){
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {

		DataCenterSystem dataSystem = new DataCenterSystem();
		
		System.out.println("Initializing data center system...");

        dataSystem.initializeDataCenter();
		
		int option=0;
		
		do{
			option= dataSystem.showMenu();
			dataSystem.executeOperation(option);
		}while (option!=0);
		
    }

	/**
	 * Initializes the data center
	 */

    public void initializeDataCenter(){
        myDataCenter = new DataCenter();
    }

	/**
	 * Shows the menu with the options
	 * @return option the user chose
	 */

    public int showMenu(){
		int option=0;

		System.out.println(
				"\n------------------Main menu, choose an option-------------\n" +
				"(1) Show disponible mini rooms\n" +
				"(2) Rent a mini room\n" +
				"(3) Rent a mini room for an existing company\n"+
				"(4) Cancel a rent\n"+
				"(5) Show the map\n"+
				"(6) Simulation\n"+
                "(0) Exit"
				);

		option= sc.nextInt();
		sc.nextLine();
		return option;
    }

    /**
     * Executes an operation
     * @param operation, operation that the user chose
     */

    public void executeOperation(int operation) {
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			System.out.println(showAvailableMinirooms());
			break;
		case 2:
			rentMiniRoom();
			break;
		case 3:
			rentMiniRoomForExistingCompany();
			break;
		case 4:
			cancelRent();
			break;
		case 5:
			showMap();
			break;
		case 6:
			simulation();
			break;
		default:
			System.out.println("Error, choose a valid option.");
			break;
		
		}
    }

	/**
	 * Shows the available mini rooms
	 * @return, string with the available mini rooms
	 */

	public String showAvailableMinirooms(){
		return myDataCenter.showAvailableMiniRooms();
	}

	/**
	 * Ask for the data for renting a mini room, validates it, and rent the mini room
	 */

	public void rentMiniRoom(){

		int rentType, day, month, year, max_day=0, roomId, rentOption, serversAmount, processorsAmount, processorsTrademark, disksAmount;
		String companyName, companyNit, projectId;
		double price, overrun=0, cacheMemory, ramMemory, disksCapacity;
		boolean asigned = false;


		System.out.println("\n----------Write the date------\n");

        System.out.println("Day: ");
        day = sc.nextInt();
        sc.nextLine();

        System.out.println("Month: ");
        month = sc.nextInt();
        sc.nextLine();

        while(month<1 || month>12){
            System.out.println("Write a valid month: ");
            month = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Year: ");
        year = sc.nextInt();
        sc.nextLine();

        while(year<1){
            System.out.println("Write a valid year: ");
            year = sc.nextInt();
            sc.nextLine();
        }

        if(month==2 && ((year% 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))){
            max_day = 29;
        }
        else if(month==2){
            max_day = 28;
        }
        else if(month==4 || month==6 || month==9 || month==11){
            max_day = 30;
        }
        else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            max_day = 31;
        }

        while(day<1 || day>max_day){
            System.out.println("\nYou wrote a not allowed day for that month. Write a valid one: ");
            day = sc.nextInt();
            sc.nextLine();
        }
		
		System.out.println("\nWrite the id number of the miniRoom (from 1 to 400): ");
        roomId = sc.nextInt();
        sc.nextLine();

		while(roomId<1 || roomId>400){
			System.out.println("\nWrite a valid id number: ");
        	roomId = sc.nextInt();
        	sc.nextLine();
		}

		while(myDataCenter.showAvailability(roomId)==false){
			System.out.println("\nThis mini room is not available, choose another one: ");
			roomId = sc.nextInt();
        	sc.nextLine();
		}

		System.out.println("\nDigit the amount of server that is going to be used: ");
		serversAmount = sc.nextInt();
		sc.nextLine();

		while(serversAmount<1){
			System.out.println("Digit a valid amount: ");
			serversAmount = sc.nextInt();
			sc.nextLine();
		}

		if(serversAmount<4){
			overrun = myDataCenter.showPriceOfMiniroom(roomId)*0.15;
		}

		price = myDataCenter.showPriceOfMiniroom(roomId) + overrun;

		System.out.println("\n------------------------------------------------------------------------------------------------------------");
		System.out.println("Price of this miniroom: "+myDataCenter.showPriceOfMiniroom(roomId));
		System.out.println("Overrun: "+overrun+"    (If there is an overrun it is because there are being rented less than four servers)");
		System.out.println("The TOTAL price of this mini room is: "+price);
		System.out.println("------------------------------------------------------------------------------------------------------------\n");

		System.out.println("\nRENT");
		System.out.println("\n1. Yes");
		System.out.println("\n2. No");
		rentOption = sc.nextInt();
		sc.nextLine();

		while(rentOption!=1 && rentOption!=2){
			System.out.println("Enter a valid option: ");
			rentOption = sc.nextInt();
			sc.nextLine();
		}


		if(rentOption==1){

			System.out.println("-------SERVERS DATA-------");

			System.out.println("Write the amount of cache memory (GB): ");
			cacheMemory = sc.nextDouble();
			sc.nextLine();

			while(cacheMemory<0){
				System.out.println("Write a valid amount of cache memory (GB): ");
				cacheMemory = sc.nextDouble();
				sc.nextLine();
			}

			System.out.println("Write the amount of processors: ");
			processorsAmount = sc.nextInt();
			sc.nextLine();

			while(processorsAmount<0){
				System.out.println("Write a valid amount of processors: ");
				processorsAmount = sc.nextInt();
				sc.nextLine();
			}

			System.out.println("Write the trademark of the processors: ");
			System.out.println("1. Intel");
			System.out.println("2. Amd");
			processorsTrademark = sc.nextInt();
			sc.nextLine();

			while(processorsTrademark!=1 && processorsTrademark!=2){
				System.out.println("Write a valid trademark of the processors: ");
				processorsTrademark = sc.nextInt();
				sc.nextLine();
			}

			System.out.println("Write the amount of ram memory (GB): ");
			ramMemory = sc.nextDouble();
			sc.nextLine();

			while(ramMemory<0){
				System.out.println("Write a valid amount of ram memory (GB): ");
				ramMemory = sc.nextDouble();
				sc.nextLine();
			}

			System.out.println("Write the amount of disks: ");
			disksAmount = sc.nextInt();
			sc.nextLine();

			while(processorsAmount<0){
				System.out.println("Write a valid amount of disks: ");
				disksAmount = sc.nextInt();
				sc.nextLine();
			}

			System.out.println("Write the disks capacity (TB): ");
			disksCapacity = sc.nextDouble();
			sc.nextLine();

			while(disksCapacity<0){
				System.out.println("Write a valid disks capacity (TB: ");
				disksCapacity = sc.nextDouble();
				sc.nextLine();
			}

			System.out.println("\nIs this mini room for a company or for an Icesi investigation project? ");
			System.out.println("\n1. Company");
			System.out.println("\n2. Icesi investigation project");
			rentType = sc.nextInt();
			sc.nextLine();

			while(rentType!=1 && rentType!=2){
				System.out.println("Enter a valid option: ");
				rentType = sc.nextInt();
				sc.nextLine();
			}

			if(rentType==1){
				System.out.println("\nWrite the name of the company: ");
				companyName = sc.nextLine();

				System.out.println("\nWrite the NIT of the company: ");
				companyNit = sc.nextLine();

				asigned = myDataCenter.asignCompany(companyName,companyNit, roomId, serversAmount, day, month, year, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);
			}
			if(rentType==2){
				System.out.println("\nWrite the ID of the project: ");
				projectId = sc.nextLine();
				asigned = myDataCenter.asignProject(projectId, roomId, serversAmount, day, month, year, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);
			}

			if(asigned){
				System.out.println("\nRENT SUCESSFUL\n");
			}
			else{
				System.out.println("\nRENT UNSUCESSFUL. You probably added an existing company or entered a repeated project id\n");
			}

			
		}

		if(rentOption==2){
			System.out.println("\nRENT UNSUCESSFUL\n");
		}
		
		
	}

	/**
	 * Ask for the data to rent a mini room for a company or a project that already exists
	 */

	public void rentMiniRoomForExistingCompany(){

		if(myDataCenter.getRentingCompanies().size()>0){

			int companyOption, day, month, year, max_day=0, roomId, rentOption, serversAmount, processorsAmount, processorsTrademark, disksAmount;
			double price, overrun=0, cacheMemory, ramMemory, disksCapacity;
			boolean asigned = false;

			System.out.println(myDataCenter.showRentingCompanies());

			System.out.println("\nChoose the company: ");
			companyOption = sc.nextInt();
			sc.nextLine();

			while(companyOption<1 || companyOption>myDataCenter.getRentingCompanies().size()){
				System.out.println("\nChoose a valid company: ");
				companyOption = sc.nextInt();
				sc.nextLine();
			}

			System.out.println("\n----------Write the date------\n");

        	System.out.println("Day: ");
        	day = sc.nextInt();
        	sc.nextLine();

        	System.out.println("Month: ");
        	month = sc.nextInt();
        	sc.nextLine();

        	while(month<1 || month>12){
            	System.out.println("Write a valid month: ");
            	month = sc.nextInt();
            	sc.nextLine();
        	}

        	System.out.println("Year: ");
        	year = sc.nextInt();
        	sc.nextLine();

        	while(year<1){
            	System.out.println("Write a valid year: ");
            	year = sc.nextInt();
            	sc.nextLine();
        	}

        	if(month==2 && ((year% 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))){
            	max_day = 29;
        	}
        	else if(month==2){
            	max_day = 28;
        	}
        	else if(month==4 || month==6 || month==9 || month==11){
         		max_day = 30;
        	}
        	else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            	max_day = 31;
        	}

        	while(day<1 || day>max_day){
            	System.out.println("\nYou wrote a not allowed day for that month. Write a valid one: ");
            	day = sc.nextInt();
            	sc.nextLine();
        	}
		
			System.out.println("\nWrite the id number of the miniRoom (from 1 to 400): ");
        	roomId = sc.nextInt();
        	sc.nextLine();

			while(roomId<1 || roomId>400){
				System.out.println("\nWrite a valid id number: ");
        		roomId = sc.nextInt();
        		sc.nextLine();
			}

			while(myDataCenter.showAvailability(roomId)==false){
				System.out.println("\nThis mini room is not available, choose another one: ");
				roomId = sc.nextInt();
        		sc.nextLine();
			}

			System.out.println("\nDigit the amount of server that is going to be used: ");
			serversAmount = sc.nextInt();
			sc.nextLine();

			while(serversAmount<1){
				System.out.println("Digit a valid amount: ");
				serversAmount = sc.nextInt();
				sc.nextLine();
			}

			if(serversAmount<4){
				overrun = myDataCenter.showPriceOfMiniroom(roomId)*0.15;
			}

			price = myDataCenter.showPriceOfMiniroom(roomId) + overrun;

			System.out.println("\n------------------------------------------------------------------------------------------------------------");
			System.out.println("Price of this miniroom: "+myDataCenter.showPriceOfMiniroom(roomId));
			System.out.println("Overrun: "+overrun+"    (If there is an overrun it is because there are being rented less than four servers)");
			System.out.println("The TOTAL price of this mini room is: "+price);
			System.out.println("------------------------------------------------------------------------------------------------------------\n");

			System.out.println("\nRENT");
			System.out.println("\n1. Yes");
			System.out.println("\n2. No");
			rentOption = sc.nextInt();
			sc.nextLine();

			while(rentOption!=1 && rentOption!=2){
				System.out.println("Enter a valid option: ");
				rentOption = sc.nextInt();
				sc.nextLine();
			}

			if(rentOption==1){

				System.out.println("-------SERVERS DATA-------");

				System.out.println("Write the amount of cache memory (GB): ");
				cacheMemory = sc.nextDouble();
				sc.nextLine();

				while(cacheMemory<0){
					System.out.println("Write a valid amount of cache memory (GB): ");
					cacheMemory = sc.nextDouble();
					sc.nextLine();
				}

				System.out.println("Write the amount of processors: ");
				processorsAmount = sc.nextInt();
				sc.nextLine();

				while(processorsAmount<0){
					System.out.println("Write a valid amount of processors: ");
					processorsAmount = sc.nextInt();
					sc.nextLine();
				}

				System.out.println("Write the trademark of the processors: ");
				System.out.println("1. Intel");
				System.out.println("2. Amd");
				processorsTrademark = sc.nextInt();
				sc.nextLine();

				while(processorsTrademark!=1 && processorsTrademark!=2){
					System.out.println("Write a valid trademark of the processors: ");
					processorsTrademark = sc.nextInt();
					sc.nextLine();
				}

				System.out.println("Write the amount of ram memory (GB): ");
				ramMemory = sc.nextDouble();
				sc.nextLine();

				while(ramMemory<0){
					System.out.println("Write a valid amount of ram memory (GB): ");
					ramMemory = sc.nextDouble();
					sc.nextLine();
				}

				System.out.println("Write the amount of disks: ");
				disksAmount = sc.nextInt();
				sc.nextLine();

				while(processorsAmount<0){
					System.out.println("Write a valid amount of disks: ");
					disksAmount = sc.nextInt();
					sc.nextLine();
				}

				System.out.println("Write the disks capacity (TB): ");
				disksCapacity = sc.nextDouble();
				sc.nextLine();

				while(disksCapacity<0){
					System.out.println("Write a valid disks capacity (TB: ");
					disksCapacity = sc.nextDouble();
					sc.nextLine();
				}

				asigned = myDataCenter.asignToExistingCompany(companyOption, roomId, serversAmount, day, month, year, cacheMemory, processorsAmount, processorsTrademark, ramMemory, disksAmount, disksCapacity);

				if(asigned){
					System.out.println("\nRENT SUCESSFUL\n");
				}
				else{
					System.out.println("\nRENT UNSUCESSFUL. You probably added an existing company or entered a repeated project id\n");
				}

			
			}

			if(rentOption==2){
				System.out.println("\nRENT UNSUCESSFUL\n");
			}

		}

		else{
			System.out.println("There are not existing companies.");
		}

	}

	/**
	 * Cancels the rent of a mini room or of all mini rooms that belongs to a company or a project
	 */

	public void cancelRent(){


		int companyOption, cancelOption, roomId;

		if(myDataCenter.getRentingCompanies().size()>0){
			System.out.println(myDataCenter.showRentingCompanies());

			System.out.println("\nChoose the company: ");
			companyOption = sc.nextInt();
			sc.nextLine();

			while(companyOption<1 || companyOption>myDataCenter.getRentingCompanies().size()){
				System.out.println("\nChoose a valid company: ");
				companyOption = sc.nextInt();
				sc.nextLine();
			}

			System.out.println("\n----------SELECT AN OPTION----------");
			System.out.println("\n1. Cancel the rent of one room of the company");
			System.out.println("\n2. Cancel the rent of all rooms of the company");
			cancelOption = sc.nextInt();
			sc.nextLine();

			while(cancelOption!=1 && cancelOption!=2){
				System.out.println("Enter a valid option: ");
				cancelOption = sc.nextInt();
				sc.nextLine();
			}

			if(cancelOption==1){
				System.out.println("Write the id of the room to cancel: ");
				roomId = sc.nextInt();
        		sc.nextLine();

				while(roomId<1 || roomId>400){
					System.out.println("\nWrite a valid id number: ");
        			roomId = sc.nextInt();
        			sc.nextLine();
				}

				System.out.println(myDataCenter.cancelRentOfARoom(companyOption, roomId));
			}
			if(cancelOption==2){
				System.out.println(myDataCenter.cancelRentOfAllRooms(companyOption));
			}

		}
		else{
			System.out.println("There are not renting companies");
		}
	}

	/**
	 * Shows the map of the data center with the mini rooms that are on (green) or of (red)
	 */

	public void showMap(){
		String red="\033[31m"; 
   		String green="\033[32m";
		String reset="\u001B[0m";

		System.out.println("\n");
		for(int i=0; i<8; i++){
			for(int j=0; j<50; j++){
				if(myDataCenter.miniRoomOn(i,j)){
					System.out.print(green+myDataCenter.getIdOfRoom(i,j)+reset+"  ");
				}
				else{
					System.out.print(red+myDataCenter.getIdOfRoom(i,j)+reset+"  ");
				}
				
			}
			System.out.println("\n");
		}

	}

	/**
	 * Initializes the simulation of shutdown protocols
	 */

	public void simulation(){
		String option=".";
		int n, m;

		myDataCenter.turnOnSimulation();

		while(option.equalsIgnoreCase("B")==false){

			System.out.println(
					"\n------------------Simulation, choose an option-------------\n" +
					"L: Turns off the first mini room of all corridors, along with the mini rooms of the first corridor.\n" +
					"Z: Turn off the mini rooms of the first and last corridor, along with the mini rooms of the reverse diagonal.\n" +
					"H: Turn off the mini rooms located in the odd-numbered corridors\n"+
					"O: Turn off the mini-rooms located in the windows\n"+
					"M: Asks for column N and turns off all mini rooms in column N\n"+
					"P: Turn off the mini-rooms of a corridor\n"+
                	"B: Back\n"
					);
		
			option = sc.nextLine();

			while(option.equalsIgnoreCase("L")==false && option.equalsIgnoreCase("Z")==false && option.equalsIgnoreCase("H")==false && option.equalsIgnoreCase("O")==false && option.equalsIgnoreCase("M")==false && option.equalsIgnoreCase("P")==false && option.equalsIgnoreCase("B")==false ){
				System.out.println("\nEnter a valid option: ");
				option = sc.nextLine();
			}

			if(option.equalsIgnoreCase("L")){
				myDataCenter.simulationL();
				showSimulationMap();
				myDataCenter.turnOnSimulation();
			}

			if(option.equalsIgnoreCase("Z")){
				myDataCenter.simulationZ();
				showSimulationMap();
				myDataCenter.turnOnSimulation();
			}

			if(option.equalsIgnoreCase("H")){
				myDataCenter.simulationH();
				showSimulationMap();
				myDataCenter.turnOnSimulation();
			}

		if(option.equalsIgnoreCase("O")){
			myDataCenter.simulationO();
			showSimulationMap();
			myDataCenter.turnOnSimulation();
		}

			if(option.equalsIgnoreCase("M")){
				System.out.println("Write the number of the column to turn of (1 to 50): ");
				n = sc.nextInt();
				sc.nextLine();

				while(n<1 || n>50){
					System.out.println("Write a valid number: ");
					n = sc.nextInt();
					sc.nextLine();
				}

				myDataCenter.simulationM(n);
				showSimulationMap();
				myDataCenter.turnOnSimulation();

			}

			if(option.equalsIgnoreCase("P")){
				System.out.println("Write the number of the corridor to turn of (1 to 8): ");
				m = sc.nextInt();
				sc.nextLine();

				while(m<1 || m>8){
					System.out.println("Write a valid number: ");
					m = sc.nextInt();
					sc.nextLine();
				}

				myDataCenter.simulationP(m);
				showSimulationMap();
				myDataCenter.turnOnSimulation();
			}
		}
	}

	/**
	 * Show the map of the simulation
	 */

	public void showSimulationMap(){
		String red="\033[31m"; 
   		String green="\033[32m";
		String reset="\u001B[0m";

		System.out.println("\n");
		for(int i=0; i<8; i++){
			for(int j=0; j<50; j++){
				if(myDataCenter.simulationMiniRoomOn(i,j)){
					System.out.print(green+myDataCenter.getIdOfSimulationRoom(i,j)+reset+"  ");
				}
				else{
					System.out.print(red+myDataCenter.getIdOfSimulationRoom(i,j)+reset+"  ");
				}
				
			}
			System.out.println("\n");
		}
	}

}

