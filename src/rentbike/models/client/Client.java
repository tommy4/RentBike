/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentbike.models.client;

import java.util.*;
import java.util.logging.Logger;
import rentbike.models.reservation.*;
import rentbike.models.bike.*;

/**
 *
 * @author tomciu
 */

public class Client {
    private final static Logger LOGGER = Logger.getLogger(Client.class.getName());
    
    private List<Reservation> RentHistory = new ArrayList();
    private List<Reservation> CurrentRent = new ArrayList();
    
    private static int idManager = 0;
    private int id;
    
    protected String name;
    protected String surname;
    
    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
        
        this.id = idManager;
        idManager++;
    }
    
    public String getPersonalData() {
        return this.name + " " + this.surname;
    }
    
    public List<Reservation> getReservationHistory() {
        return this.RentHistory;
    }
    
    public List<Reservation> getCurrentRent() {
        return this.CurrentRent;
    }
    
    private boolean hasBike(Bike b) {
        for(int z = 0; z < this.CurrentRent.size(); z++) {
            if(CurrentRent.get(z).getBike() == b) {
                return true;
            }      
        }
        return false;
    }
    
    // Funkcja wypożyczająca rower
    public void rentBike(Bike b, Date date) throws BikeException {
        if(CurrentRent.size() < 3) {         
            try {
                b.setBusy();                                                    // Oznacz rower jako wypożyczony
            
                Reservation x = new Reservation(this, b, date);                 // Utwórz nową rezerwację
            
                RentHistory.add(x);                                             // Dodaj do historii klienta
                CurrentRent.add(x);                                             // Dodaj do aktualnie wypożyczonych
                
                System.out.println("Szerokiej drogi, wypożyczyłeś rower: " + b);
                
            } catch (BikeException x) {       
                System.out.println(x);           
            }
            
        } else {
            throw new BikeException("Przkroczyłeś limit rezerwacji! (Max 3)");
        }
    }
    
    // Funkcja oddająca rower
    public void returnBike(Bike b, Date date) throws BikeException {
        for(int i = 0; i < CurrentRent.size(); i++)
        {
            if(CurrentRent.get(i).getBike() == b) {  
                for(int q = RentHistory.size(); q != 0; q--) {                  // -- aby zwiększyć wydajność
                    if(RentHistory.get(q-1) == CurrentRent.get(i)) {
                        CurrentRent.remove(CurrentRent.get(i));                 // Usuwamy rezerwację z aktualnie wypożyczonych
                        RentHistory.get(q-1).setReturnDate(date);               // Wpisujemy datę oddania do historii
                        b.setFree();                                            // Oznaczamy rower jako oddany
                        System.out.println("Oddałeś rower: " + b + " ... gratz, idz do kasy!");
                        return;
                    }
                }
            }
            else {
                throw new BikeException("Nie masz takiej rezerwacji!");
            }
        }        
    }   
    
        
    // Jeżdzenie rowerem
    public void rideBike(Bike b, float km) throws BikeException{
        if(this.hasBike(b)) {
            if((b.getCurrentMilage() - b.getLastInspection()) < b.getInspectionPeriod()) {
            b.updateMilage(km);
            System.out.println("Bruuuum..... przejechałeś " + km + " kilometrów rowerem: " + b);
            }
            else {
                throw new BikeException("Rower " + b + " wymaga przeglądu.");
            }
        } 
        else {
            throw new BikeException("Nie posiadasz takiego roweru. Jak chcesz nim jeździć?");
        }
    }
    
    // Robienie przeglądu
    public void makeInspection(Bike b) throws BikeException {
        if(this.hasBike(b)){
            b.setInpection();
            System.out.println("Zrobiłeś przegląd! Następny za " + b.getInspectionPeriod() + "km.");
        }
        else {
            throw new BikeException("Nie posiadasz takiego roweru. Jak chcesz zrobić przegląd?");
        }
        
    }
}
