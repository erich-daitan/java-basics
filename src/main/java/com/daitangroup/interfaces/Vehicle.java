package com.daitangroup.interfaces;

import com.daitangroup.exceptions.EngineException;

public interface Vehicle {


    //Basic actions that is executed by all kind of vehicles
    void accelerateVehicle();
    void breakVehicle();
    void turnLeft();
    void turnRight();
    float checkFuel();
    void turnVehicleOn() throws EngineException;
    void turnVehicleOff() throws EngineException;
    int changeToNextGear();
    int changeToPreviousGear();
    void putOnNeutral();

}
