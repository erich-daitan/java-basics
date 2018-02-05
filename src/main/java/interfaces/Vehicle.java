package interfaces;

public interface Vehicle {


    //Basic actions that is executed by all kind of vehicles
    void accelerateVehicle();
    void breakVehicle();
    void turnLeft();
    void turnRight();
    float checkFuel();
    void turnVehicleOn();
    void turnVehicleOff();
    int changeToNextGear();
    int changeToPreviousGear();
    void putOnNeutral();

}
