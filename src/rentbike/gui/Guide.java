/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentbike.gui;

import java.util.Scanner;

/**
 *
 * @author tomciu
 */
public class Guide {
    public static void generateMenu(){
        Scanner odczyt = new Scanner(System.in);
        
        while(true) {
            System.out.println("");
            System.out.println("Menu wyboru:");
            System.out.println("1. Zarządzaj rowerami");
            System.out.println("2. Zarządzaj klientami");
            System.out.println("3. Zarządzaj rezerwacjami");
            System.out.println("----------------");
            
            int read = odczyt.nextInt();
            
            switch(read) {
                case 1:
                    BikeAdmin();
                    break;
                case 2:
                    ClientAdmin();
                    break;
                case 3:
                    ReservationAdmin();
                    break;
                default:
                    break;                                                 
            }
                    
                  
        }
             
    }
    
    private static void BikeAdmin() {
           System.out.println("----------");
           System.out.println("Wybierz rodzaj czynności:");
           System.out.println("1. Dodaj rower");
           System.out.println("2. Usuń rower");
           System.out.println("3. Wyświetl info");
           System.out.println("4. Podaj ilość rowerów");
           
           Scanner read = new Scanner(System.in);
           switch(read.nextInt()) {
               case 1:
                   
           }
          
           
    }
    
    private static void ClientAdmin() {
           System.out.println("----------");
           System.out.println("Wybierz rodzaj czynności:");
           System.out.println("1. Dodaj klienta");
           System.out.println("2. Usuń klienta");
           System.out.println("3. Wyświetl info");
           System.out.println("4. Podaj ilość klientów");
    }
        
    private static void ReservationAdmin() {
           System.out.println("----------");
           System.out.println("Wybierz rodzaj czynności:");
           System.out.println("1. Dodaj rezerwację");
           System.out.println("2. Usuń rezerwację");
           System.out.println("3. Wyświetl info");
           System.out.println("4. Podaj ilość rezerwacji");
    }    
}
