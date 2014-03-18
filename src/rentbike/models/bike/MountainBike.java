/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentbike.models.bike;

/**
 *
 * @author tomciu
 */
public class MountainBike extends Bike{
    protected int derailleur;
    
    public MountainBike(int WheelSize, int derailleur) {
        super(WheelSize);
        this.derailleur = derailleur;
        this.setParams(30, 2000, 0);       
    }
    
    @Override
    public String toString() {
        return "Rower górski: rozmiar kół - " + this.WheelSize + ", przebieg: " + this.CurrentMilage + ", ilość przerzutek: " + this.derailleur;
    }
}
