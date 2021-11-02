package model;


public class Channel {
	
	private final int MAX_PRODUCTS = 85;
	
    private String nit;
    private String address;
    private String webPage;

    private Subscriber[] subscriberList;
	private Product[] productCatalog;

    /**
     * Constructor of Channel class
     * @param nit, nit of the channel
     * @param address, address of the channel
     * @param webPage, url of the website that the channel belongs
     */


    public Channel(String nit, String address, String webPage){
        this.nit = nit;
        this.address = address;
        this.webPage = webPage;

        subscriberList = new Subscriber[50];
		productCatalog = new Product[85];
    }

    /**
     * Returns the nit of the channel
     * @return nit, String
     */

    public String getNit() {
        return nit;
    }

    /**
     * Set a new nit for the channel
     * @param nit nit of the channel
     */

    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Returns the address of the channel
     * @return address, String
     */

    public String getAddress() {
        return address;
    }

    /**
     * Set a new address for the channel
     * @param address, address of the channel
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the web page link of the channel
     * @return webPage, String
     */

    public String getWebPage() {
        return webPage;
    }

    /**
     * Set a new web page link for the channel
     * @param webPage, link of the channel
     */

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    /**
     * This method disactivates a subscriber, for this, the method uses the id number of the subscriber
     * and look for it in the subscriber list, when the method finds it, changes the state to INACTIVE and
     * the type to NORMAL, also returns true. In the other case, the method doesn't change anything and 
     * returns false
     * @param idNumber, String, id number of the subscriber that is going to be disactivated
     * @return disactivated, boolean
     */
    
    public boolean disactivateSubscriber(String idNumber){
        boolean disactivated = false;

        for(int i=0; i<50 && !disactivated; i++){
            if(subscriberList[i]!=null){
                if(idNumber.equals(subscriberList[i].getIdNumber())){
                    subscriberList[i].setClientState(SubscriberState.INACTIVE);
                    subscriberList[i].setClientType(Type.NORMAL);
                    disactivated = true;
                }
            }
        }

        return disactivated;
    }
    
    /**
     * This method returns true if there is a position that is null, because this means that we have
     * disponible space to register more subscribers
     * @return available, boolean
     */

    public boolean avaliableSpace(){
        boolean available = false;

        for(int i=0; i<50 && !available; i++){
            if(subscriberList[i]==null){
                available = true;
            }
        }

        return available;
    }

    /**
     * This method compares a new id number of a new subscriber with the ones in the list. If it finds
     * one id number that is the same, stop searching and returns true.
     * @param idNumber, id of the new subscriber that the user is creating
     * @return out, boolean
     */

    public boolean repeatedId(String idNumber){
        boolean repeated = false;

        for(int i=0; i<50 && !repeated; i++){
            if(subscriberList[i]!=null){
                if(idNumber.equals(subscriberList[i].getIdNumber())){
                    repeated = true;
                }
            }
        }

        return repeated;
    }

    /**
     * This method only works if reapetedId is false. Then, depending on the number that the user 
     * has chosen for the type, assign a type value to the clientType variable. Finally, in a cycle, 
     * it looks for an available space and in that position it creates a subscriber type object with the 
     * data that the user indicated.
     * @param idNumber, id number of the subscriber
     * @param name, name of the subscriber
     * @param age, age of the subscriber
     * @param hoursWillingToWatch, hours that the subscriber is willing to watch
     * @param type, type of subscriber
     * @return added, true if added, else if not
     */

    public boolean addSubscriber(String idNumber, String name, int age, double hoursWillingToWatch, int type){        
        
        Type clientType = Type.NORMAL;
        boolean added = false;

        if(repeatedId(idNumber)==false){
            switch(type){
                case 1:
                    clientType = Type.NORMAL;
                    break;
                case 2:
                    clientType = Type.GOLD;
                    break;
                case 3:
                    clientType = Type.PLATINUM;
                    break;
                case 4:
                    clientType = Type.DIAMOND;
                    break;
            }

            for(int i=0; i<50 && !added; i++){
                if(subscriberList[i]==null){
                    subscriberList[i] = new Subscriber(idNumber, name, age, hoursWillingToWatch, clientType);
                    added = true;
                }
            }

        }  
        
        return added;
    }
    
    /**
     * It goes through the subscriberList in a cycle, and if it finds any subscriber that is active, 
     * it adds 1 to the counter.
     * @return activeSubscribers, int
     */

    public int getActiveSubscribers(){

        int activeSubscribers=0;

        for(int i=0; i<50; i++){
            if(subscriberList[i]!=null){
                if(subscriberList[i].getClientState()==SubscriberState.ACTIVE){
                    activeSubscribers++;
                }
            }
        }

        return activeSubscribers;
    }

    /**
     * It goes through the subscriberList in a cycle, and if it finds any subscriber that is active and normal, 
     * it adds 1 to the counter.
     * @return normalSubscribers, int
     */

    public int getNormalSubscribers(){

        int normalSubscribers=0;

        for(int i=0; i<50; i++){
            if(subscriberList[i]!=null){
                if(subscriberList[i].getClientState()==SubscriberState.ACTIVE && subscriberList[i].getClientType()==Type.NORMAL){
                    normalSubscribers++;
                }
            }
        }

        return normalSubscribers;
    }

    /**
     * It goes through the subscriberList in a cycle, and if it finds any subscriber that is active and gold, 
     * it adds 1 to the counter.
     * @return goldSubscribers, int
     */

    public int getGoldSubscribers(){

        int goldSubscribers=0;

        for(int i=0; i<50; i++){
            if(subscriberList[i]!=null){
                if(subscriberList[i].getClientState()==SubscriberState.ACTIVE && subscriberList[i].getClientType()==Type.GOLD){
                    goldSubscribers++;
                }
            }
        }

        return goldSubscribers;
    }
    
    /**
     * It goes through the subscriberList in a cycle, and if it finds any subscriber that is active and platinum, 
     * it adds 1 to the counter.
     * @return platinumSubscribers, int
     */

    public int getPlatinumSubscribers(){

        int platinumSubscribers=0;

        for(int i=0; i<50; i++){
            if(subscriberList[i]!=null){
                if(subscriberList[i].getClientState()==SubscriberState.ACTIVE && subscriberList[i].getClientType()==Type.PLATINUM){
                    platinumSubscribers++;
                }
            }
        }

        return platinumSubscribers;
    }

    /**
     * It goes through the subscriberList in a cycle, and if it finds any subscriber that is active and diamond, 
     * it adds 1 to the counter.
     * @return diamondSubscribers, int
     */

    public int getDiamondSubscribers(){

        int diamondSubscribers=0;

        for(int i=0; i<50; i++){
            if(subscriberList[i]!=null){
                if(subscriberList[i].getClientState()==SubscriberState.ACTIVE && subscriberList[i].getClientType()==Type.DIAMOND){
                    diamondSubscribers++;
                }
            }
        }

        return diamondSubscribers;
    }

    /**
     * It goes through the subscriberList in a cycle, and looks for underage subscribers, 
     * and chooses the one that is willing to see the most hours, replacing the variable 
     * with the name of the one that meets the conditions
     * @return name, String
     */

    public String findBestUnderageSubscriber(){
        String name = "";
        double hours=0;
        for(int i=0; i<50; i++){
            if(subscriberList[i]!=null){
                if(subscriberList[i].getClientState()==SubscriberState.ACTIVE && subscriberList[i].getAge()<18 && subscriberList[i].getHoursWillingToWatch()>hours){
                    hours = subscriberList[i].getHoursWillingToWatch();
                    name = subscriberList[i].getName();
                }
            }
        }
        return name;
    }

}
