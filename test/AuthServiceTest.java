/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import junit.framework.TestCase;
import login.Exception.AuthenticationException;
import login.service.AuthService;
import login.service.AuthServiceImpl;
import org.jmock.Expectations;
import org.jmock.Mockery;

/**
 *
 * @author huihuilei
 */
public class AuthServiceTest extends TestCase {
    
    public AuthServiceTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    
    public void test_getInstance() {
        Assert.assertNotNull(AuthServiceImpl.getInstance());
    }
    
    public void test_auth001() {
        try {
            AuthServiceImpl.getInstance().auth("test2", "test");
            Assert.fail();
        } catch (AuthenticationException ex) {
            Assert.assertEquals(ex.getErrorCode(), AuthenticationException.ErrorCode.ACCOUNT_FROZEN);
        }
    }
    
    public void test_auth002() {
        try {
            AuthServiceImpl.getInstance().auth("test1", "test");
            Assert.fail();
        } catch (AuthenticationException ex) {
            Assert.assertEquals(ex.getErrorCode(), AuthenticationException.ErrorCode.ACCOUNT_NOT_FOUND);
        }
    }
    
    public void test_auth003() {
        try {
            AuthServiceImpl.getInstance().auth("test", "test2");
            Assert.fail();
        } catch (AuthenticationException ex) {
            Assert.assertEquals(ex.getErrorCode(), AuthenticationException.ErrorCode.WRONG_PASSWORD);
        }
    }
    
    public void test_auth004() {
        try {
            AuthServiceImpl.getInstance().auth("test", "test");
        } catch (AuthenticationException ex) {
            Assert.fail();
        }
    }
    
    private AuthService mockAuthService() throws AuthenticationException {
    	final AuthService authService = context.mock(AuthService.class);
        context.checking(new Expectations() {   
        {   
            
            allowing(authService).auth("test", "test");
    
            allowing(authService).auth("test2", "test");
            will(throwException(new AuthenticationException(AuthenticationException.ErrorCode.ACCOUNT_FROZEN)));
    
            allowing(authService).auth("test", "test2");
            will(throwException(new AuthenticationException(AuthenticationException.ErrorCode.WRONG_PASSWORD)));
    
            allowing(authService).auth("test1", "test");
            will(throwException(new AuthenticationException(AuthenticationException.ErrorCode.ACCOUNT_NOT_FOUND)));
        }
        }); 
        
        return authService;
    }
    
    public void test_mock_auth001() {
        try {
            mockAuthService().auth("test2", "test");
            Assert.fail();
        } catch (AuthenticationException ex) {
            Assert.assertEquals(ex.getErrorCode(), AuthenticationException.ErrorCode.ACCOUNT_FROZEN);
        }
    }
    
    public void test_mock_auth002() {
        try {
            mockAuthService().auth("test1", "test");
            Assert.fail();
        } catch (AuthenticationException ex) {
            Assert.assertEquals(ex.getErrorCode(), AuthenticationException.ErrorCode.ACCOUNT_NOT_FOUND);
        }
    }
    
    public void test_mock_auth003() {
        try {
            mockAuthService().auth("test", "test2");
            Assert.fail();
        } catch (AuthenticationException ex) {
            Assert.assertEquals(ex.getErrorCode(), AuthenticationException.ErrorCode.WRONG_PASSWORD);
        }
    }
    
    public void test_mock_auth004() {
        try {
            mockAuthService().auth("test", "test");
        } catch (AuthenticationException ex) {
            Assert.fail();
        }
    }
    
    Mockery context = new Mockery();
}
