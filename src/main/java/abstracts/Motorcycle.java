package abstracts;

import interfaces.*;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import org.apache.log4j.Logger;

public abstract class Motorcycle implements Vehicle {

    /**
     * log4j var for logging
     */
    final static Logger logger = Logger.getLogger(Motorcycle.class);


    /**
     * Attributes for Motorcycle
     */
    private float fuel;
    private int numberOfGears;
    private int actualGear = 0;
    private int maxNumberOfOccupants;
    private Set<String> occupantsNames = Collections.emptySet();



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
        return fuel;
    }

    public void turnVehicleOn() {
        System.out.println("Vehicle Turned On");
    }

    public void turnVehicleOff() {
        System.out.println("Vehicle Turned Off");
    }

    public int changeToNextGear() {
        if(actualGear<=numberOfGears){
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


    /**
     * Class constructor
     * @param fuel Fuel of motorcycle in liters
     * @param numberOfGears Number of shift gears
     * @param maxNumberOfOccupants Maximum number of occupants in the motorcycle
     */
    public Motorcycle(float fuel, int numberOfGears, int maxNumberOfOccupants) {
        this.fuel = fuel;
        this.numberOfGears = numberOfGears;
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


    public int getMaxNumberOfOccupants() {
        return maxNumberOfOccupants;
    }

    public void setMaxNumberOfOccupants(int maxNumberOfOccupants) {
        this.maxNumberOfOccupants = maxNumberOfOccupants;
    }

    /**
     *Check if the car is already full and try to add the occupant. If the occupant is already in the car it gets error.
     *
     * @param name name of occupant that will enter in the motorcycle
     */
    public void addOccupant(String name){

        if (occupantsNames.size() < maxNumberOfOccupants){
            try {
                occupantsNames.add(name);
            }catch (Exception e){
                logger.error("Fail to insert new occupant. Already in motorcycle. " + e);
            }
        }else {
            logger.error("The motorcycle is full!");
        }
    }


    /**
     * Check if has at least one occupant and try to remove. If the ocuppant is not in the motorcycle, show an error.
     * @param name name of occupant that will exit in the motorcycle
     */
    public void removeOccupant(String name){

        if(occupantsNames.size() > 0){
            try{
                occupantsNames.remove(name);
            }catch (Exception e){
                logger.error("Fail to remove the occupant. Not in motorcycle. " + e);
            }
        }else {
            logger.error("There is no more occupants in the motorcycle");
        }
    }


    @Override
    public String toString() {
        return "Motorcycle{" +
                "fuel=" + fuel +
                ", numberOfGears=" + numberOfGears +
                ", actualGear=" + actualGear +
                ", maxNumberOfOccupants=" + maxNumberOfOccupants +
                ", occupantsNames=" + occupantsNames +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return Float.compare(that.fuel, fuel) == 0 &&
                numberOfGears == that.numberOfGears &&
                actualGear == that.actualGear &&
                maxNumberOfOccupants == that.maxNumberOfOccupants &&
                Objects.equals(occupantsNames, that.occupantsNames);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fuel, numberOfGears, actualGear, maxNumberOfOccupants, occupantsNames);
    }
}
