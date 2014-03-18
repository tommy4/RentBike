/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentbike.logic;

import rentbike.models.reservation.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author tomciu
 */
public class ReservationLogic {
    private static List<Reservation> ReservationRegister = new ArrayList();
    
    public static void addReservation(Reservation r) {
        ReservationRegister.add(r);
    }
    
    public static void removeReservation(int id) {
        ReservationRegister.remove(id);
    }
    
    public static Reservation getReservationInfo(int id) {
        return ReservationRegister.get(id);
    }
    
    public static int getSize() {
        return ReservationRegister.size();
    }
    
}
