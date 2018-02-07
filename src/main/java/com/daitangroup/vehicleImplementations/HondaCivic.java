package com.daitangroup.vehicleImplementations;

import com.daitangroup.vehiclesTypes.Car;

public class HondaCivic extends Car {


    private int horsePower = 150;
    private String engineDescription = "2.0 flex fuel";
    private boolean parkAssist = true;


    public HondaCivic() {
        super(50, 6, 525, 4, 5);
    }


    @Override
    public String toString() {
        return "HondaCivic{" +
                "horsePower=" + horsePower +
                ", engineDescription='" + engineDescription + '\'' +
                ", parkAssist=" + parkAssist +
                '}' + super.toString();
    }
}
