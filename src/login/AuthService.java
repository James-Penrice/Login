/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

/**
 *
 * @author James-Penrice
 */
public class AuthService {
    private AuthService() {
        //
    }
    
    private static AuthService singleton;
    
    public static AuthService getInstance() {
        if (singleton == null) {
            singleton = new AuthService();
        }
        
        return singleton;
    }
    
    public boolean auth(String account, String password) {
        return ("test".equals(account) && "test".equals(password));
    }
}
