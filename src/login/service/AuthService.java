/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login.service;

import login.Exception.AuthenticationException;

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
    
    public void auth(String account, String password) throws AuthenticationException {
        if ("test2".equals(account)) {
            throw new AuthenticationException(AuthenticationException.ErrorCode.ACCOUNT_FROZEN);
        }

        if (!"test".equals(account)) {
            throw new AuthenticationException(AuthenticationException.ErrorCode.ACCOUNT_NOT_FOUND);
        }

        if (!"test".equals(password)) {
            throw new AuthenticationException(AuthenticationException.ErrorCode.WRONG_PASSWORD);
        }

    }
}
