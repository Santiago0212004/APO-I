package model;

import java.util.ArrayList;

public class ListManager {
    

    private ArrayList<Child> goodChilds;
    private ArrayList<Child> badChilds;

    /**
     * Initializes both lists
     */

    public ListManager(){
        goodChilds = new ArrayList<Child>();
        badChilds = new ArrayList<Child>();
    }

    /**
     * Add a child
     * @param completeName, complete name of the child
     * @param christmasWish, the wish that the child wants for christmas
     * @param completeAddress, the complete address of the child
     * @param age, age of the child
     * @param behavior, number with the behavior of the child
     * @return added, true if added was sucessfully
     */

    public boolean addChild(String completeName, String christmasWish, String completeAddress, int age, int behavior){
        boolean added = false;
        Behavior childBehavior = Behavior.NONE;


        switch (behavior) {
            case 1:
                childBehavior = Behavior.GOOD;
                break;
            case 2:
                childBehavior = Behavior.BAD;
                break;
        }

        Child childToAdd = new Child(completeName, christmasWish, completeAddress, age, childBehavior);

        if(behavior==1){
            for(int i=0; i<goodChilds.size() && !added; i++){
                if(goodChilds.get(i).compareTo(childToAdd)>=0){
                    goodChilds.add(i, childToAdd);
                    added = true;
                }
            }
            if(!added){
                goodChilds.add(childToAdd);
                added = true;
            }
        }

        if(behavior==2){
            for(int i=0; i<badChilds.size() && !added; i++){
                if(badChilds.get(i).compareTo(childToAdd)>=0){
                    badChilds.add(i, childToAdd);
                    added = true;
                }
            }
            if(!added){
                badChilds.add(childToAdd);
                added = true;
            }
        }

        return added;
    }

    /**
     * Change a child of list
     * @param completeName, complete name of the child
     * @param list, the list of children that the child already is
     * @return changed, true if changing was sucessfully
     */

    public boolean changeChild(String completeName, int list){
        boolean changed = false;

        if(list==1){
            for(int i=0; i<goodChilds.size() && !changed; i++){
                if(goodChilds.get(i).getCompleteName().equalsIgnoreCase(completeName)){
                    addChild(goodChilds.get(i).getCompleteName(), goodChilds.get(i).getChristmasWish(), goodChilds.get(i).getCompleteAddress(), goodChilds.get(i).getAge(), 2);
                    goodChilds.remove(i);
                    changed = true;
                }
            }
        }

        if(list==2){
            for(int i=0; i<badChilds.size() && !changed; i++){
                if(badChilds.get(i).getCompleteName().equalsIgnoreCase(completeName)){
                    addChild(badChilds.get(i).getCompleteName(), badChilds.get(i).getChristmasWish(), badChilds.get(i).getCompleteAddress(), badChilds.get(i).getAge(), 1);
                    badChilds.remove(i);
                    changed = true;
                }
            }
        }

        return changed;
    }
    
    /**
     * Show the list the user wants to see
     * @param listToSee, number of the list
     * @return String, all data of the children in the selected list
     */

    public String showList(int listToSee){
        String list="";
        if(listToSee==1){
            for(int i=0;i<goodChilds.size();i++){
                list += "\n-------------------Child number "+(i+1)+"-------------------\n"+goodChilds.get(i).toString();
            }
        }
        if(listToSee==2){
            for(int i=0;i<badChilds.size();i++){
                list += "\n-------------------Child number "+(i+1)+"-------------------\n"+badChilds.get(i).toString();
            }
        }

        return list;
    }

    
}
