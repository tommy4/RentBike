/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentbike;

import rentbike.models.bike.*;
import rentbike.models.client.Client;
import rentbike.models.reservation.Reservation;

import java.util.Date;

/**
 *
 * @author tomciu
 */
public class RentBike {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        //Guide.generateMenu();      
        Bike b1 = new Bike(25);
        Bike b2 = new MountainBike(24, 7);
        Bike b3 = new ProffesionalBike(28, 4, ProffesionalBike.Variant.BMX);
        Bike b4 = new ProffesionalBike(30,8,ProffesionalBike.Variant.Downhill);
        
        Client c1 = new Client("Tomasz","Partyka");
        Client c2 = new Client("Kamil", "Mazurek");
        Client c3 = new Client("Maciej","Kochan");
        
        try {
            c1.rentBike(b1, new Date(2014,12,30));     
        } catch (BikeException b) {
            System.out.println(b);
        }
        try {
            c1.rideBike(b1, 10);     
        } catch (BikeException b) {
            System.out.println(b);
        }
        try {
            c1.rideBike(b1, 10000);     
        } catch (BikeException b) {
            System.out.println(b);
        }
        try {
            c1.makeInspection(b1);     
        } catch (BikeException b) {
            System.out.println(b);
        }   
    }   
}
