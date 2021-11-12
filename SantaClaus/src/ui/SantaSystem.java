package ui;

import java.util.Scanner;

import model.ListManager;

public class SantaSystem {

    private Scanner sc;
    private ListManager santaListManager;

    public SantaSystem(){
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {

		SantaSystem giftsSystem = new SantaSystem();
		
	
		System.out.println("Initializing Santa's system. Ho ho ho");

        giftsSystem.initializeListManager();
		
		int option=0;
		
		do{
			
			option= giftsSystem.showMenu();
			giftsSystem.executeOperation(option);
			
		}while (option!=0);
		
	}

    public void initializeListManager(){
        santaListManager = new ListManager();
    }


    public int showMenu() {
		int option=0;

		System.out.println(
				"------------------Main menu, choose an option-------------\n" +
				"(1) Register a child \n" +
				"(2) Change a child of list \n" +
				"(3) Show a list \n"+
                "(0) Exit"
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
			registerChild() ;
			break;
		case 2:
			changeChildOfList() ;
			break;
		case 3:
			showList();
			break;
		default:
			System.out.println("Error, choose a valid option.");
		
		}
	}

    public void registerChild(){
        String name, lastName, completeName, christmasWhish, address, city, country, completeAddress;
        int age, behavior;
        boolean added;

        System.out.println("\nWrite the name: ");
        name = sc.nextLine();

        while(name.equals("")){
            System.out.println("\nThe name can't be empty. Write a valid one: ");
            name = sc.nextLine();
        }

        System.out.println("\nWrite the last name");
        lastName = sc.nextLine();

        while(lastName.equals("")){
            System.out.println("\nThe last name can't be empty. Write a valid one: ");
            lastName = sc.nextLine();
        }

        completeName = name+" "+lastName;

        System.out.println("\nWrite the christmas wish of the child: ");
        christmasWhish = sc.nextLine();

        while(christmasWhish.equals("")){
            System.out.println("\nThe christmas wish can't be empty. Write a valid one: ");
            christmasWhish = sc.nextLine();
        }

        System.out.println("\nWrite the address of the child's house: ");
        address = sc.nextLine();

        while(address.equals("")){
            System.out.println("\nThe address can't be empty. Write a valid one: ");
            address = sc.nextLine();
        }

        System.out.println("\nWrite the city where the child lives: ");
        city = sc.nextLine();

        while(city.equals("")){
            System.out.println("\nThe city can't be empty. Write a valid one: ");
            city = sc.nextLine();
        }

        System.out.println("\nWrite the country where the child lives: ");
        country = sc.nextLine();

        while(country.equals("")){
            System.out.println("\nThe country can't be empty. Write a valid one: ");
            country = sc.nextLine();
        }

        completeAddress = address+", "+city+", "+country;

        System.out.println("\nWrite the age of the child: ");
        age = sc.nextInt();
        sc.nextLine();

        while(age<0 || age>17){
            if(age<0){
                System.out.println("\nWrite a valid age: ");
                age = sc.nextInt();
                sc.nextLine();
            }
            if(age>17){
                System.out.println("\nIs that a child? Ho ho ho. Write a valid one: ");
                age = sc.nextInt();
                sc.nextLine();
            }
        }

        System.out.println("\nHow was the behavior of the child? Select an option.");
        System.out.println("\n(1) Good");
        System.out.println("\n(2) Bad");

        behavior = sc.nextInt();
        sc.nextLine();

        while(behavior!=1 && behavior!=2){
            System.out.println("\nSelect a valid option: ");
            behavior = sc.nextInt();
            sc.nextLine();
        }

        added = santaListManager.addChild(completeName, christmasWhish, completeAddress, age, behavior);

        if(added){
            System.out.println("Child added succesfully");
        }
        else{
            System.out.println("Couldn't add the child");
        }
    }

    public void changeChildOfList(){
        String completeName;
        int list;
        boolean changed;

        System.out.println("\nWrite the complete name (names and last names) of the child: ");
        completeName = sc.nextLine();

        while(completeName.equals("")){
            System.out.println("\nThe complete name can't be empty. Write a valid one: ");
            completeName = sc.nextLine();
        }

        System.out.println("\nWrite the list that the child already is: ");
        System.out.println("\n(1) Good childs");
        System.out.println("\n(2) Bad childs");

        list = sc.nextInt();
        sc.nextLine();

        while(list!=1 && list!=2){
            System.out.println("\nSelect a valid option: ");
            list = sc.nextInt();
            sc.nextLine();
        }

        changed = santaListManager.changeChild(completeName, list);

        if(changed){
            System.out.println("Child changed succesfully");
        }
        else{
            System.out.println("Couldn't change the child. Maybe the name does not exist or is in the other list");
        }
    }

    public void showList(){
        int listToSee;
        String resultList;

        System.out.println("\nWhat list do you want to see? Select an option: ");
        System.out.println("\n(1) Good childs");
        System.out.println("\n(2) Bad childs");
        listToSee = sc.nextInt();
        sc.nextLine();

        while(listToSee!=1 && listToSee!=2){
            System.out.println("\nSelect a valid option: ");
            listToSee = sc.nextInt();
            sc.nextLine();
        }

        resultList = santaListManager.showList(listToSee);

        System.out.println(resultList);
    }
}
