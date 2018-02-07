package com.daitangroup;

import com.daitangroup.interfaces.Vehicle;
import com.daitangroup.vehicleImplementations.VWSaveiroCross;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        Vehicle vei = new VWSaveiroCross();

        vei.changeToNextGear();



    }
}
