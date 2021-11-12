package model;

public class Child implements Comparable<Child>{
    private String completeName;
    private String christmasWish;
    private String completeAddress;
    private int age;
    private Behavior childBehavior;

    public Child(String completeName, String christmasWish, String completeAddress, int age, Behavior childBehavior){
        this.completeName = completeName;
        this.christmasWish = christmasWish;
        this.completeAddress = completeAddress;
        this.age = age;
        this.childBehavior = childBehavior;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getChristmasWish() {
        return christmasWish;
    }

    public void setChristmasWish(String christmasWish) {
        this.christmasWish = christmasWish;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Behavior getChildBehavior() {
        return this.childBehavior;
    }

    public void setChildBehavior(Behavior childBehavior) {
        this.childBehavior = childBehavior;
    }

    public String toString(){
        return "\nComplete name: "+completeName+
               "\nChristmas wish: "+christmasWish+
               "\nComplete address: "+completeAddress+
               "\nAge: "+age;
    }

    @Override

    public int compareTo(Child otherChild){
        return this.age - otherChild.age;
    }

}
