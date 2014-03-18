/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentbike.logic;

import java.util.*;
import rentbike.models.bike.*;
/**
 *
 * @author tomciu
 */
public class BikeLogic {
    private static ArrayList<Bike> BikeRegister = new ArrayList();
    
    public static void addBike(Bike b) {
        BikeRegister.add(b);
    }
    
    public static void removeBike(int id) {
        BikeRegister.remove(id);
    }
    
    public static Bike getBikeInfo(int id) {
        return BikeRegister.get(id);
    }
    
    public static int getSize() {
        return BikeRegister.size();
    }
    
}
