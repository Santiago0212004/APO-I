package model;

public class Channel {
	
	private final int MAX_PRODUCTS = 85;
    private final int MAX_SUBSCRIBERS = 50;
	
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

        subscriberList = new Subscriber[MAX_SUBSCRIBERS];
		productCatalog = new Product[MAX_PRODUCTS];
    }


    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebPage() {
        return webPage;
    }

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

    public boolean avaliableSpaceForSubscribers(){
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
        
        Type clientType = Type.NONE;
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

    /**
     * This method returns true if there is a position that is null, because this means that we have
     * disponible space to register more products
     * @return available, boolean
     */

    public boolean availableSpaceForProducts(){
        boolean available = false;

        for(int i=0; i<50 && !available; i++){
            if(productCatalog[i]==null){
                available = true;
            }
        }

        return available;
    }

    /**
     * This method checks if we have a product with the same title as the one we are creating.
     * @param title, it is the title of the product we are creating
     * @return repeated, boolean
     */


    public boolean repeatedTitle(String title){
        boolean repeated = false;

        for(int i=0; i<85 && !repeated; i++){
            if(productCatalog[i]!=null){
                if(title.equals(productCatalog[i].getTitle())){
                    repeated = true;
                }
            }
        }

        return repeated;
    }

    /**
     * This method allow us to create a serie. First, it makes sure that the title is not repeated, then it looks for a null
     * position in the product array, wich is the one where the method executes the constructor with all the necesary data
     * @param title, title of the serie
     * @param synopsis, synopsis of the serie, it is an opinion.
     * @param directorName, name of the director of the serie
     * @param day, day of the release date
     * @param month, month of the release date
     * @param year, year of the release date
     * @param protagonistNames, the name of the protagonist of the serie separated by commas
     * @param state, state of the serie. Can be censored or uncesored
     * @param reasonOfCensored, the reason of why the serie is censored in case it is
     * @param programmedEpisodesQuantity, the programmed episodes quantity of the first season
     * @param publishedEpisodesQuantity, the published episodes quantity of the first season
     * @param trailer, the trailer URL of the first season
     * @return added, boolean.
     */

    public boolean addSerie(String title, String synopsis, String directorName, int day, int month, int year, String protagonistNames, int state, String reasonOfCensored, int programmedEpisodesQuantity, int publishedEpisodesQuantity, String trailer){
        boolean added = false;

        StateOfSerie serieState = StateOfSerie.NONE;

        if(repeatedTitle(title)==false){
            switch(state){
                case 1:
                    serieState = StateOfSerie.CENSORED;
                    break;
                case 2:
                    serieState = StateOfSerie.UNCENSORED;
                    break;
            }

            for(int i=0; i<85 && !added; i++){
                if(productCatalog[i]==null){
                    productCatalog[i] = new Serie(title, synopsis, directorName, day, month, year, protagonistNames, serieState, reasonOfCensored, programmedEpisodesQuantity, publishedEpisodesQuantity, trailer);
                    added = true;
                }
            }

        }  

        return added;

    }

    /**
     * This method creates a movie, making sure the title is not repeated in any product. Then, executes de constructor in
     * the first null position it finds.
     * @param title, title of the movie
     * @param synopsis, synopsis of the movie
     * @param directorName, name of the director of the movie
     * @param day, date of the release date of the movie
     * @param month, month of the release date of the movie
     * @param year, year of the release date of the movie
     * @param productor, name of the productor of the movie
     * @param minimumAge, the recommended minimum age to watch the movie
     * @param category, the category of the movie
     * @return, added, boolean
     */

    public boolean addMovie(String title, String synopsis, String directorName, int day, int month, int year, String productor, int minimumAge, int category){
        boolean added = false;

        Category movieCategory = Category.NONE;

        if(repeatedTitle(title)==false){
            switch(category){
                case 1:
                    movieCategory = Category.ROMANTIC;
                    break;
                case 2:
                    movieCategory = Category.ACTION;
                    break;
                case 3:
                    movieCategory = Category.SUSPENSE;
                    break;
                case 4:
                    movieCategory = Category.HORROR;
                    break;
                case 5:
                    movieCategory = Category.COMEDY;
                    break;
            }

            for(int i=0; i<85 && !added; i++){
                if(productCatalog[i]==null){
                    productCatalog[i] = new Movie(title, synopsis, directorName, day, month, year, productor, minimumAge, movieCategory);
                    added = true;
                }
            }
        }

        return added;
    }

    /**
     * This method executes the toString method of a product with the same title as the one we entered.
     * @param title, title of the product
     * @return information, String with the information of the product
     */

    public String informationOfAProduct(String title){
        String information="\nThere wasn't a product with that title";
        boolean found = false;
        
        for(int i=0; i<85 && !found; i++){
            if(productCatalog[i]!=null){
                if(productCatalog[i].getTitle().equalsIgnoreCase(title)){
                    information = productCatalog[i].toString();
                    found = true;
                }
            }  
        }
        return information;
    }

    /**
     * This method add a season in the serie we want using its title
     * @param title, title of the serie that we are going to add the season
     * @param programedEpisodesQuantity, the programmed episodes quantity of the season
     * @param publishedEpisodesQuantity, the published episodes quantity of the season
     * @param trailer, the trailer URL of the season
     * @param day, the release day of the season
     * @param month, the release month of the season
     * @param year, the release year of the season
     * @return added, boolean
     */

    public boolean addSeason(String title, int programedEpisodesQuantity, int publishedEpisodesQuantity, String trailer, int day, int month, int year){
        boolean added = false;

        for(int i=0; i<85 && !added; i++){
            if(productCatalog[i]!=null){
                if(productCatalog[i].getTitle().equalsIgnoreCase(title) && (productCatalog[i] instanceof Serie)){
                    added = ((Serie) productCatalog[i]).addSeason(programedEpisodesQuantity, publishedEpisodesQuantity, trailer, day, month, year);
                }
            }  
        }

        return added;
    }

    /**
     * This method makes a list of movie of a given category.
     * @param category, it is the category of movies we want to make a list
     * @return movieList, String
     */

    public String listMovies(int category){
        String movieList="---------LIST OF MOVIES----------";
        int count=1;

        Category movieCategory = Category.NONE;

        switch(category){
            case 1:
                movieCategory = Category.ROMANTIC;
                break;
            case 2:
                movieCategory = Category.ACTION;
                break;
            case 3:
                movieCategory = Category.SUSPENSE;
                break;
            case 4:
                movieCategory = Category.HORROR;
                break;
            case 5:
                movieCategory = Category.COMEDY;
                break;
        }

        for(int i=0; i<85; i++){
            if(productCatalog[i]!=null){
                if(((Movie) productCatalog[i]).getMovieCategory()==movieCategory && (productCatalog[i] instanceof Movie)){
                    movieList += "\n"+count+". "+productCatalog[i].getTitle();
                    count++;
                }
            }  
        }

        return movieList;
    }

    /**
     * It makes a list of series with their last season
     * @return list, String
     */

    public String listSeries(){
        String list = "";
        int count = 1;
        for(int i=0; i<85; i++){
            if(productCatalog[i]!=null){
                if(productCatalog[i] instanceof Serie){
                    list += "-------------------------------Serie number "+count+"------------------------\n"+((Serie) productCatalog[i]).serieWithLastSeason();
                }
            }
        }
        return list;
    }


}
