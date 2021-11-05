package ui;
import model.ACMEBicycle;
import model.APOIBycicle;
import model.BMTBicycle;

public class Main {
	APOIBycicle bike;
	BMTBicycle bike2;

	public static void main(String[] args) {
		Main main= new Main();
		main.show();
	}
	
	public void show() {
		bike= new APOIBycicle();
		bike.printStates();

		bike2= new BMTBicycle();
	}

}
