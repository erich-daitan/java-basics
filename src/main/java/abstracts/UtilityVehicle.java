package abstracts;

import interfaces.*;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Objects;


public abstract class UtilityVehicle implements Vehicle {

    /**
     * log4j var for logging
     */
    final static Logger logger = Logger.getLogger(UtilityVehicle.class);

    /**
     * Attributes for UtilityVehicle
     */
    private float fuel;
    private int numberOfGears;
    private int actualGear = 0;
    private float loadCapacity;
    private int numberOfDoors;
    private List<String> kindOfLoads;


    //Implementation for vehicle interface
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
        logger.warn("Checking fuel");
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
        if(actualGear >= 1){
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


    /**
     * Class constructor
     * @param fuel Fuel of vehicle in liters
     * @param numberOfGears Number of shift gears
     * @param loadCapacity Back load capacity
     * @param numberOfDoors Numeber of doors in the vehicle
     * @param kindOfLoads Kinds of loads accepted in the truck bed
     */
    public UtilityVehicle(float fuel, int numberOfGears, float loadCapacity, int numberOfDoors, List<String> kindOfLoads) {
        this.fuel = fuel;
        this.numberOfGears = numberOfGears;
        this.loadCapacity = loadCapacity;
        this.numberOfDoors = numberOfDoors;
        this.kindOfLoads = kindOfLoads;
    }


    //getters and setters
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

    public List<String> getKindOfLoads() {
        return kindOfLoads;
    }

    public void setKindOfLoads(List<String> kindOfLoads) {
        this.kindOfLoads = kindOfLoads;
    }


    @Override
    public String toString() {
        return "UtilityVehicle{" +
                "fuel=" + fuel +
                ", numberOfGears=" + numberOfGears +
                ", actualGear=" + actualGear +
                ", loadCapacity=" + loadCapacity +
                ", numberOfDoors=" + numberOfDoors +
                ", kindOfLoads=" + kindOfLoads +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilityVehicle that = (UtilityVehicle) o;
        return Float.compare(that.fuel, fuel) == 0 &&
                numberOfGears == that.numberOfGears &&
                actualGear == that.actualGear &&
                Float.compare(that.loadCapacity, loadCapacity) == 0 &&
                numberOfDoors == that.numberOfDoors &&
                Objects.equals(kindOfLoads, that.kindOfLoads);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fuel, numberOfGears, actualGear, loadCapacity, numberOfDoors, kindOfLoads);
    }
}
