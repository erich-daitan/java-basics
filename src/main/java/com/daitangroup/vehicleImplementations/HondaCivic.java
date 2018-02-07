package com.daitangroup.vehicleImplementations;

import com.daitangroup.vehiclesTypes.Car;
import java.util.Objects;

public class HondaCivic extends Car {

    private final int horsePower = 150;
    private final String engineDescription = "2.0 flex fuel";
    private final boolean parkAssist = true;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof HondaCivic) ) return false;
        if (!super.equals(o)) return false;
        HondaCivic that = (HondaCivic) o;
        return horsePower == that.horsePower &&
                parkAssist == that.parkAssist &&
                Objects.equals(engineDescription, that.engineDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), horsePower, engineDescription, parkAssist);
    }
}
