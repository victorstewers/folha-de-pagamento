package entities;

public class Employee {
    private String name;
    private double valuePerHour;
    private int hours;


    public Employee(String name, double valuePerHour, int hours){
        this.name = name;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setValuePerHour(double valuePerHour){
        this.valuePerHour = valuePerHour;
    }
    public double getValeuPerHour(){
        return this.valuePerHour;
    }

    public void setHours(int hours){
        this.hours = hours;
    }
    public int getHours(){
        return this.hours;
    }

    public double totalSalary(){
        return valuePerHour*hours;
    }
}   
