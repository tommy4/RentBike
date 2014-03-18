/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentbike.models.bike;

import java.util.*;
import rentbike.models.client.*;

/**
 *
 * @author tomciu
 */

public class Bike {
    protected List<Client> UsersList = new ArrayList();
    
    protected static int idManager = 0;
    protected int id;
    protected boolean busy = false;
    
    protected float LastInspection;
    protected float InspectionPeriod;
    protected float CurrentMilage;
    
    protected int WheelSize;
    protected float RentPrice; 
    
    public Bike(int WheelSize) {
        this.WheelSize = WheelSize;       
        this.setParams(20, 5000, 0);
        
        this.id = idManager;
        idManager++;
    }
    
    
    protected final void setParams(int RentPrice, float InspectionPeriod, float CurrentMilage) {
        this.RentPrice = RentPrice;
        this.InspectionPeriod = InspectionPeriod;
        this.CurrentMilage = CurrentMilage;
    }
    
    public final void setBusy() throws BikeException{
        if(this.busy == false) {
            this.busy = true;
        } else {
            throw new BikeException("Rower jest już wyporzyczony!");
        }       
    }
    
    public final float getCurrentMilage(){
        return this.CurrentMilage;
    }
    
    public final float getLastInspection(){
        return this.LastInspection;
    }
    
    public final float getInspectionPeriod(){
        return this.InspectionPeriod;
    }
    
    public final void setFree(){
        this.busy = false;
    }
    
    public final void updateMilage(float km) {
        this.CurrentMilage += km;
    }       
     
    public final static int getBikeCount() {
        return idManager;
    }
    
    public final void setInpection() {
        this.LastInspection = this.CurrentMilage;
    }
    
    
    @Override
    public String toString() {
        return "Rower standardowy: rozmiar kół - " + this.WheelSize + ", przebieg: " + this.CurrentMilage;
    }
}
