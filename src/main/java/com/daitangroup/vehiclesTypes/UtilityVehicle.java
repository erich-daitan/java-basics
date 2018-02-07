package com.daitangroup.vehiclesTypes;

import com.daitangroup.exceptions.EngineException;
import com.daitangroup.interfaces.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public abstract class UtilityVehicle implements Vehicle {

    /**
     * slf4j var for logging
     */
    final static Logger LOGGER = LoggerFactory.getLogger(UtilityVehicle.class);


    /**
     * Attributes for UtilityVehicle
     */
    private float fuel;
    private int numberOfGears;
    private int actualGear;
    private float loadCapacity;
    private int numberOfDoors;
    private List<String> kindOfLoads;
    private int maxNumberOfOccupants;
    private Set<String> occupantsNames = Collections.<String>emptySet();
    private boolean engineIsOn;


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
        LOGGER.warn("Checking fuel");
        return fuel;
    }

    public void turnVehicleOn() throws EngineException {
        System.out.println("Vehicle Turned On");
        if(engineIsOn) {
            throw new EngineException("Engine is already on.");
        } else {
            engineIsOn = true;
            System.out.println("Vehicle Turned On");
        }
    }

    public void turnVehicleOff() throws EngineException {
        if(!engineIsOn) {
            throw new EngineException("Engine is already Off.");
        } else {
            engineIsOn = false;
            System.out.println("Vehicle Turned Off");
        }
    }

    public int changeToNextGear() {
        if(actualGear < numberOfGears) {
            actualGear++;
            LOGGER.warn("Changing gear.");
        } else {
            LOGGER.warn("No more gears left to change");
        }
        return actualGear;
    }

    public int changeToPreviousGear() {
        if(actualGear > 1) {
            actualGear--;
            LOGGER.warn("Changing gear.");
        } else {
            LOGGER.warn("No more gears left to change");
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
     */
    public UtilityVehicle(float fuel, int numberOfGears, float loadCapacity, int numberOfDoors, int maxNumberOfOccupants) {
        this.fuel = fuel;
        this.numberOfGears = numberOfGears;
        this.loadCapacity = loadCapacity;
        this.numberOfDoors = numberOfDoors;
        this.maxNumberOfOccupants = maxNumberOfOccupants;
        this.kindOfLoads = new ArrayList<String>();
        this.actualGear = 0;
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

    public void addKindOfLoad(String load) {
        this.kindOfLoads.add(load);
    }

    /**
     *Check if the car is already full and try to add the occupant. If the occupant is already in the car it gets error.
     *
     * @param name name of occupant that will enter in the motorcycle
     */
    public void addOccupant(String name) {
        if (occupantsNames.size() < maxNumberOfOccupants){
            try {
                occupantsNames.add(name);
            } catch (Exception e) {
                LOGGER.error("Fail to insert new occupant. Already in vehicle. " + e);
            }
        } else {
            LOGGER.error("The vehicle is full!" + occupantsNames.size());
        }
    }

    /**
     * Check if has at least one occupant and try to remove. If the ocuppant is not in the motorcycle, show an error.
     * @param name name of occupant that will exit in the motorcycle
     */
    public void removeOccupant(String name) {
        if(occupantsNames.size() > 0) {
            try {
                occupantsNames.remove(name);
            } catch (Exception e) {
                LOGGER.error("Fail to remove the occupant. Not in vehicle.", e);
            }
        } else {
            LOGGER.error("There is no more occupants in the vehicle");
        }
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
                ", maxNumberOfOccupants=" + maxNumberOfOccupants +
                ", occupantsNames=" + occupantsNames +
                ", engineIsOn=" + engineIsOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof UtilityVehicle) ) return false;
        UtilityVehicle that = (UtilityVehicle) o;
        return Float.compare(that.fuel, fuel) == 0 &&
                numberOfGears == that.numberOfGears &&
                actualGear == that.actualGear &&
                Float.compare(that.loadCapacity, loadCapacity) == 0 &&
                numberOfDoors == that.numberOfDoors &&
                maxNumberOfOccupants == that.maxNumberOfOccupants &&
                engineIsOn == that.engineIsOn &&
                Objects.equals(kindOfLoads, that.kindOfLoads) &&
                Objects.equals(occupantsNames, that.occupantsNames);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fuel, numberOfGears, actualGear, loadCapacity, numberOfDoors, kindOfLoads, maxNumberOfOccupants, occupantsNames, engineIsOn);
    }
}
