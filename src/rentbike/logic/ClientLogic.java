/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentbike.logic;

import java.util.ArrayList;
import java.util.List;
import rentbike.models.client.*;

/**
 *
 * @author tomciu
 */
public class ClientLogic {
    private static List<Client> ClientRegister = new ArrayList();
    
    public static void addClient(Client c) {
        ClientRegister.add(c);
    }
    
    public static void removeClient(int id) {
        ClientRegister.remove(id);
    }
    
    public static Client getClientInfo(int id) {
        return ClientRegister.get(id);
    }
    
    public static int getSize() {
        return ClientRegister.size();
    }
}
