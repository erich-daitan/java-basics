package com.daitangroup.vehicleImplementations;

import com.daitangroup.vehiclesTypes.Motorcycle;
import java.util.Objects;

public class YamahaMT07 extends Motorcycle {

    private final String ignitionType = "Eletric";
    private final int cylinderCapacity = 689;
    private final String fuelType = "Gasoline";

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof YamahaMT07) ) return false;
        if (!super.equals(o)) return false;
        YamahaMT07 that = (YamahaMT07) o;
        return cylinderCapacity == that.cylinderCapacity &&
                Objects.equals(ignitionType, that.ignitionType) &&
                Objects.equals(fuelType, that.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ignitionType, cylinderCapacity, fuelType);
    }
}
