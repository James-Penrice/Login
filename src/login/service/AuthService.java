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
public interface AuthService {
    
    public void auth(String account, String password) throws AuthenticationException;
}
