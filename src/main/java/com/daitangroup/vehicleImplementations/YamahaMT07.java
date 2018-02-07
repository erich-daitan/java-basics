package com.daitangroup.vehicleImplementations;

import com.daitangroup.vehiclesTypes.Motorcycle;

public class YamahaMT07 extends Motorcycle {


    private String ignitionType = "Eletric";
    private int cylinderCapacity = 689;
    private String fuelType = "Gasoline";


    public YamahaMT07() {
        super(14, 6, 2);
    }


    @Override
    public String toString() {
        return "YamahaMT07{" +
                "ignitionType='" + ignitionType + '\'' +
                ", cylinderCapacity=" + cylinderCapacity +
                ", fuelType='" + fuelType + '\'' +
                '}' + super.toString();
    }
}
