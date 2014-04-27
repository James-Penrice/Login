/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import junit.framework.TestCase;
import login.AuthService;

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
        Assert.assertNotNull(AuthService.getInstance());
    }
    
    public void test_auth001() {
        Assert.assertEquals(AuthService.getInstance().auth("test", "1"), false);
    }
    
    public void test_auth002() {
        Assert.assertEquals(AuthService.getInstance().auth("test1", "test"), false);
    }
    
    public void test_auth003() {
        Assert.assertEquals(AuthService.getInstance().auth("test", "test"), true);
    }
}
