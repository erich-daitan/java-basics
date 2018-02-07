package com.daitangroup.vehicleImplementations;

import com.daitangroup.vehiclesTypes.UtilityVehicle;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof VWSaveiroCross) ) return false;
        if (!super.equals(o)) return false;
        VWSaveiroCross that = (VWSaveiroCross) o;
        return tracctionControl == that.tracctionControl &&
                courtesyLight == that.courtesyLight &&
                Objects.equals(engineType, that.engineType) &&
                Objects.equals(torque, that.torque) &&
                Objects.equals(interiorDescription, that.interiorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineType, torque, tracctionControl, courtesyLight, interiorDescription);
    }
}
