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
public class ProffesionalBike extends MountainBike{
    private Variant typ;
    
    public enum Variant {
        BMX, Street, Downhill, Damka;
    }
    
    public ProffesionalBike(int WheelSize, int derailleur, Variant type) {
        super(WheelSize, derailleur);
        this.typ = type;
        this.setParams(50, 1000, 0);
    }
    
    @Override
    public String toString() {
        return "Rower profesjonalny: " + this.typ + ", rozmiar kół - " + this.WheelSize + ", przebieg: " + this.CurrentMilage + ", ilość przerzutek: " + this.derailleur;
    }      
}
