package ui;

import java.util.Scanner;

import model.DataCenter;

public class DataCenterSystem {
    private Scanner sc;
    private DataCenter myDataCenter;

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

    public void initializeDataCenter(){
        myDataCenter = new DataCenter();
    }

    public int showMenu(){
		int option=0;

		System.out.println(
				"------------------Main menu, choose an option-------------\n" +
				"(1) Show disponible mini rooms\n" +
				"(2) Rent a mini room\n" +
				"(3)  \n"+
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
			break;
		default:
			System.out.println("Error, choose a valid option.");
		
		}
    }

	public String showAvailableMinirooms(){
		return myDataCenter.showAvailableMiniRooms();
	}

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


		System.out.println("Price of this miniroom: "+myDataCenter.showPriceOfMiniroom(roomId));
		System.out.println("Overrun: "+overrun+"    (If there is an overrun it is because there is being rented less than four servers)");
		System.out.println("\nThe TOTAL price of this mini room is: "+price);

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

		if(rentOption==1){
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

}
