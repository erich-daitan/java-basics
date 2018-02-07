package com.daitangroup.interfaces;

import com.daitangroup.exceptions.EngineException;

public interface Vehicle {

    //Basic actions that is executed by all kind of vehicles

    /**
     * Accelerates the vehicle and print vrum
     */
    void accelerateVehicle();

    /**
     * Breaks the vehicle and print break
     */
    void breakVehicle();

    /**
     * Turn the vehicle left and print that is turning
     */
    void turnLeft();

    /**
     * Turn the vehicle right and print that is turning
     */
    void turnRight();

    /**
     * Returns the ammount of fuel in the vehicle
     */
    float checkFuel();

    /**
     * Try to turn the engine on, if is already on, throws an exception
     */
    void turnVehicleOn() throws EngineException;

    /**
     * Try to turn the engine off, if is already off, throws an exception
     */
    void turnVehicleOff() throws EngineException;

    /**
     * Returns the gear after changed.
     */
    int changeToNextGear();

    /**
     * Returns the gear after changed.
     */
    int changeToPreviousGear();

    /**
     * Change the gear to neutral
     */
    void putOnNeutral();

    /**
     *Check if the vehicle is already full and try to add the occupant. If the occupant is already in the vehicle it gets error.
     *
     * @param name name of occupant that will enter in the vehicle
     */
    void addOccupant(String name);

    /**
     * Check if has at least one occupant and try to remove. If the ocuppant is not in the vehicle, show an error.
     * @param name name of occupant that will exit in the car
     */
    void removeOccupant(String name);

}
