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
				"(1)  \n" +
				"(2)  \n" +
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
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			System.out.println("Error, choose a valid option.");
		
		}
    }

}
