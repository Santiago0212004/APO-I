package model;

public class APOIBycicle implements Bicycle {
	private int cadence ;
    private int speed ;
    private int gear;

    public APOIBycicle(){

    	cadence = 1 ;
    	speed= 4;
    	gear= 2;

    }



    public void changeCadence(int newValue) {
         cadence = newValue;
    }

    public void changeGear(int newValue) {
         gear = newValue;
    }

    public void speedUp(int increment) {
         speed = speed + (increment*2);   
    }

    public void applyBrakes(int decrement) {
         speed = speed - (decrement*2);
    }

    public void printStates() {
         System.out.println("cadence:" +
             cadence + " speed:" + 
             speed + " gear:" + gear);
    }

}