package model;

public class Subscriber {
    private String idNumber;
    private String name;
    private int age;
    private double hoursWillingToWatch;
    private Type clientType;
    private SubscriberState clientState;

	/**
	 * Constructor of subscriber class
	 * @param idNumber, id number of the subscriber
	 * @param name, name of the subscribe
	 * @param age, age of the subscriber
	 * @param hoursWillingToWatch, hours that the subscriber is willing to watch
	 * @param clientType, type of the subsciber
	 */

    public Subscriber(String idNumber, String name, int age, double hoursWillingToWatch, Type clientType){
        this.idNumber = idNumber;
        this.name = name;
        this.age = age;
        this.hoursWillingToWatch = hoursWillingToWatch;
        this.clientType = clientType;
        clientState = SubscriberState.ACTIVE;
    }

	/**
	 * Returns the id number of the subscriber
	 * @return idNumber, String
	 */

	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * Set a new id number for the subscriber
	 * @param idNumber, String, new id number entered by the user
	 */

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * Returns the name of the subscriber
	 * @return name, String
	 */

	public String getName() {
		return name;
	}

	/**
	 * Set a new name for the subscriber
	 * @param name, new name entered by the user
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the age of the subscriber
	 * @return, int
	 */

	public int getAge() {
		return age;
	}

	/**
	 * Set a new age for the subscriber
	 * @param age, int, age entered by the user
	 */

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the hours that the subscriber is willing to watch
	 * @return hoursWillingToWatch, double
	 */

	public double getHoursWillingToWatch() {
		return hoursWillingToWatch;
	}

	/**
	 * Set a new number of hours that the subscriber is willing to watch
	 * @param hoursWillingToWatch, double
	 */

	public void setHoursWillingToWatch(double hoursWillingToWatch) {
		this.hoursWillingToWatch = hoursWillingToWatch;
	}

	/**
	 * Returns the type of the client
	 * @return clientType, Type
	 */

	public Type getClientType() {
		return clientType;
	}

	/**
	 * This method allow us to change the type of the client
	 * @param clientType, Type
	 */

	public void setClientType(Type clientType) {
		this.clientType = clientType;
	}

	/**
	 * Returns the state of the client
	 * @return clientState, State
	 */

	public SubscriberState getClientState() {
		return clientState;
	}

	/**
	 * This method allow us to change the state of the client
	 * @param clientState, State
	 */

	public void setClientState(SubscriberState clientState) {
		this.clientState = clientState;
	}


    



}