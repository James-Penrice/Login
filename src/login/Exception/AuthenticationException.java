/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login.Exception;

/**
 *
 * @author James-Penrice
 */
public class AuthenticationException extends Exception {
    
    public static enum ErrorCode {ACCOUNT_NOT_FOUND, WRONG_PASSWORD, ACCOUNT_FROZEN};
    
    private final ErrorCode mCode;
    
    public AuthenticationException(ErrorCode code) {
        super(code.name());
        this.mCode = code;
    }
    
    public ErrorCode getErrorCode() {
        return this.mCode;
    }
}
