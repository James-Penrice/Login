import junit.framework.Assert;
import junit.framework.TestCase;
import login.Exception.AuthenticationException;
import login.service.AuthService;

/**
 *
 * @author James-Penrice
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
        try {
            AuthService.getInstance().auth("test2", "test");
            Assert.fail();
        } catch (AuthenticationException ex) {
            Assert.assertEquals(ex.getErrorCode(), AuthenticationException.ErrorCode.ACCOUNT_FROZEN);
        }
    }
    
    public void test_auth002() {
        try {
            AuthService.getInstance().auth("test1", "test");
            Assert.fail();
        } catch (AuthenticationException ex) {
            Assert.assertEquals(ex.getErrorCode(), AuthenticationException.ErrorCode.ACCOUNT_NOT_FOUND);
        }
    }
    
    public void test_auth003() {
        try {
            AuthService.getInstance().auth("test", "test2");
            Assert.fail();
        } catch (AuthenticationException ex) {
            Assert.assertEquals(ex.getErrorCode(), AuthenticationException.ErrorCode.WRONG_PASSWORD);
        }
    }
    
    public void test_auth004() {
        try {
            AuthService.getInstance().auth("test", "test");
        } catch (AuthenticationException ex) {
            Assert.fail();
        }
    }
}
