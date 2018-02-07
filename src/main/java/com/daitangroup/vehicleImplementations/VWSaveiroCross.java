package com.daitangroup.vehicleImplementations;

import com.daitangroup.vehiclesTypes.UtilityVehicle;

public class VWSaveiroCross extends UtilityVehicle {

   private String engineType = "1.6 16V engine";
   private String torque = "10,51 kgfm/litro";
   private boolean tracctionControl = true;
   private boolean courtesyLight = true;
   private String interiorDescription = "All black with a big multimedia screen.";


    public VWSaveiroCross() {
        super(50, 5, 734, 2,2);
    }


    @Override
    public String toString() {
        return "VWSaveiroCross{" +
                "engineType='" + engineType + '\'' +
                ", torque='" + torque + '\'' +
                ", tracctionControl=" + tracctionControl +
                ", courtesyLight=" + courtesyLight +
                ", interiorDescription='" + interiorDescription + '\'' +
                '}'+ super.toString();
    }


}
