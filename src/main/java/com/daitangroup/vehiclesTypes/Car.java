package com.daitangroup.vehiclesTypes;

import com.daitangroup.exceptions.EngineException;
import com.daitangroup.interfaces.Vehicle;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Car implements Vehicle {

    /**
     * slf4j var for logging
     */
    final static Logger LOGGER = LoggerFactory.getLogger(Car.class);

    /**
     * Attributes for Car
     */
    private float fuel;
    private int numberOfGears;
    private int actualGear;
    private float loadCapacity;
    private int numberOfDoors;
    private int maxNumberOfOccupants;
    private Set<String> occupantsNames = Collections.emptySet();
    private boolean engineIsOn;

    /**
     * Class constructor
     * @param fuel Fuel of car in liters
     * @param numberOfGears Number of shift gears
     * @param loadCapacity Trunk load capacity
     * @param numberOfDoors Numeber of doors in the car
     * @param maxNumberOfOccupants Maximum number of occupants
     */
    public Car(float fuel, int numberOfGears, float loadCapacity, int numberOfDoors, int maxNumberOfOccupants) {
        this.fuel = fuel;
        this.numberOfGears = numberOfGears;
        this.loadCapacity = loadCapacity;
        this.numberOfDoors = numberOfDoors;
        this.maxNumberOfOccupants = maxNumberOfOccupants;
        this.actualGear = 0;
    }

    //Implementation for vehicle interface
    @Override
    public void accelerateVehicle() {
        System.out.println("Vrum");
    }

    @Override
    public void breakVehicle() {
        System.out.println("Break");
    }

    @Override
    public void turnLeft() {
        System.out.println("Turning Left");
    }

    @Override
    public void turnRight() {
        System.out.println("Turning Right");
    }

    @Override
    public float checkFuel() {

        return fuel;
    }

    @Override
    public void turnVehicleOn() throws EngineException {
        System.out.println("Vehicle Turned On");
        if(engineIsOn) {
            throw new EngineException("Engine is already on.");
        } else {
            engineIsOn = true;
            System.out.println("Vehicle Turned On");
        }
    }

    @Override
    public void turnVehicleOff() throws EngineException {
        if(!engineIsOn) {
            throw new EngineException("Engine is already Off.");
        } else {
            engineIsOn = false;
            System.out.println("Vehicle Turned Off");
        }
    }

    @Override
    public int changeToNextGear() {
        if(actualGear < numberOfGears) {
            actualGear++;
            LOGGER.warn("Changing gear.");
        } else {
            LOGGER.warn("No more gears left to change");
        }
        return actualGear;
    }

    @Override
    public int changeToPreviousGear() {
        if(actualGear > 1) {
            actualGear--;
            LOGGER.warn("Changing gear.");
        } else {
            LOGGER.warn("No more gears left to change");
        }
        return actualGear;
    }

    @Override
    public void putOnNeutral() {
        actualGear = 0;
        System.out.println("Putting on neutral");
    }

    @Override
    public void addOccupant(String name) {
        if (occupantsNames.size() < maxNumberOfOccupants) {
            try {
                occupantsNames.add(name);
            } catch (Exception e) {
                LOGGER.error("Fail to insert new occupant. Already in car. " + e);
            }
        } else {
            LOGGER.error("The car is full!");
        }
    }

    @Override
    public void removeOccupant(String name) {
        if(occupantsNames.size() > 0) {
            try {
                occupantsNames.remove(name);
            } catch (Exception e) {
                LOGGER.error("Fail to remove the occupant. Not in car.", e);
            }
        } else {
            LOGGER.error("There is no more occupants in the car");
        }
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

    @Override
    public String toString() {
        return "Car{" +
                "fuel=" + fuel +
                ", numberOfGears=" + numberOfGears +
                ", actualGear=" + actualGear +
                ", loadCapacity=" + loadCapacity +
                ", numberOfDoors=" + numberOfDoors +
                ", maxNumberOfOccupants=" + maxNumberOfOccupants +
                ", occupantsNames=" + occupantsNames +
                ", engineIsOn=" + engineIsOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof Car) ) return false;
        Car car = (Car) o;
        return Float.compare(car.fuel, fuel) == 0 &&
                numberOfGears == car.numberOfGears &&
                actualGear == car.actualGear &&
                Float.compare(car.loadCapacity, loadCapacity) == 0 &&
                numberOfDoors == car.numberOfDoors &&
                maxNumberOfOccupants == car.maxNumberOfOccupants &&
                engineIsOn == car.engineIsOn &&
                Objects.equals(occupantsNames, car.occupantsNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuel, numberOfGears, actualGear, loadCapacity, numberOfDoors, maxNumberOfOccupants, occupantsNames, engineIsOn);
    }
}
