package com.daitangroup;

import implementations.VWSaveiroCross;
import org.apache.log4j.BasicConfigurator;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //log4j configuration
        BasicConfigurator.configure();


        System.out.println( "Hello World!" );

        ArrayList<String> test = new ArrayList<String>();
        test.add("Wood");
        test.add("Metal");

        VWSaveiroCross saveiro = new VWSaveiroCross(50,1,200,2,test,"1.6 16V engine");

        saveiro.checkFuel();

        System.out.println(saveiro.toString());


    }
}
