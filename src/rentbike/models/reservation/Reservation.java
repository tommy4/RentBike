/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentbike.models.reservation;

import rentbike.models.client.*;
import rentbike.models.bike.*;
import java.util.Date;

/**
 *
 * @author tomciu
 */

public class Reservation {
    private static int idManagement = 0;
    private int id;
    
    private final Bike bike;
    private final Client client;
    private Date rentDate;
    private Date returnDate;
    
    public Reservation(Client client, Bike bike, Date initDate) { 
        this.bike = bike;
        this.client = client;
        this.rentDate = initDate;
                
        this.id = idManagement;
        idManagement++;      
    }
    
    public Bike getBike() {
        return bike;
    }
    
    public void setReturnDate(Date d) {
        this.returnDate = d;
    }
    
    public void setRentDate(Date d) {
        this.rentDate = d;
    }
    
    public int getTimePeriod() {
        int temp;
        int difference = this.returnDate.getHours() - this.rentDate.getHours();
        
        if(difference % 24 != 0) {
            temp = difference/24 + 1;
        } else {
            temp = difference/24;
        }
        return temp;
    }
    
    
}
