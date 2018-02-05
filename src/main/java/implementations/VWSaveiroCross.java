package implementations;

import abstracts.UtilityVehicle;

import java.util.ArrayList;

public class VWSaveiroCross extends UtilityVehicle {


    private String description;


    public VWSaveiroCross(float fuel, int numberOfGears, float loadCapacity, int numberOfDoors, ArrayList<String> kindOfLoads, String description) {
        super(fuel, numberOfGears, loadCapacity, numberOfDoors, kindOfLoads);
        this.description = description;
    }


    @Override
    public String toString() {

        return super.toString() + "VWSaveiroCross{" +
                "description='" + description + '\'' +
                '}';
    }
}
