package abstracts;

import interfaces.*;
import org.apache.log4j.Logger;

public abstract class Car implements Vehicle {

    //log4j var for logging
    final static Logger logger = Logger.getLogger(Car.class);


    //Attributes for Car
    private float fuel;
    private int numberOfGears;
    private int actualGear = 0;
    private float loadCapacity;
    private int numberOfDoors;
    private int maxNumberOfOccupants;


    public void accelerateVehicle() {
        System.out.println("Vrum");
    }

    public void breakVehicle() {
        System.out.println("Break");
    }

    public void turnLeft() {
        System.out.println("Turning Left");
    }

    public void turnRight() {
        System.out.println("Turning Right");
    }

    public float checkFuel() {

        return fuel;
    }

    public void turnVehicleOn() {
        System.out.println("Vehicle Turned On");
    }

    public void turnVehicleOff() {
        System.out.println("Vehicle Turned Off");
    }

    public int changeToNextGear() {
        if(actualGear <= numberOfGears){
            actualGear++;
        }else {
            logger.warn("No more gears left to change");
        }
        return actualGear;
    }

    public int changeToPreviousGear() {
        if(actualGear>=1){
            actualGear--;
        }else {
            logger.warn("No more gears left to change");
        }
        return actualGear;
    }

    public void putOnNeutral() {
        actualGear = 0;
        System.out.println("Putting on neutral");
    }


    public Car(float fuel, int numberOfGears, float loadCapacity, int numberOfDoors, int maxNumberOfOccupants) {
        this.fuel = fuel;
        this.numberOfGears = numberOfGears;
        this.loadCapacity = loadCapacity;
        this.numberOfDoors = numberOfDoors;
        this.maxNumberOfOccupants = maxNumberOfOccupants;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public int getActualGear() {
        return actualGear;
    }

    public void setActualGear(int actualGear) {
        this.actualGear = actualGear;
    }

    public float getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(float loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getMaxNumberOfOccupants() {
        return maxNumberOfOccupants;
    }

    public void setMaxNumberOfOccupants(int maxNumberOfOccupants) {
        this.maxNumberOfOccupants = maxNumberOfOccupants;
    }
}
