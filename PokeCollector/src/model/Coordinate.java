package model;

public class Coordinate{
    private double degree;
    private double minutes;
    private double seconds;

    public Coordinate(double degree, double minutes, double seconds){
        this.degree = degree;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void setDegree(double degree){
        this.degree = degree;
    }

    public void setMinutes(double minutes){
        this.minutes = minutes;
    }

    public void setSeconds(double seconds){
        this.seconds = seconds;
    }

    public double getDegree(){
        return degree;
    }

    public double getMinutes(){
        return minutes;
    }

    public double getSeconds(){
        return seconds;
    }

    public String toString(){
        return degree+" , "+minutes+" , "+seconds;
    }
}