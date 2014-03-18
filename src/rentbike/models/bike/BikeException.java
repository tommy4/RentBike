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
public class BikeException extends Exception{
    public BikeException(){};
    public BikeException(String str){ super(str); }   
}
