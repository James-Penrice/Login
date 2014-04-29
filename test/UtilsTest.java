

import junit.framework.Assert;
import junit.framework.TestCase;
import login.utils.Utils;

/**
 *
 * @author James-Penrice
 */
public class UtilsTest extends TestCase {
    
    public UtilsTest(String testName) {
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
    public void test_isEmptyString001() {
        Assert.assertEquals(Utils.isEmptyString(null), true);
    }

    public void test_isEmptyString002() {
        Assert.assertEquals(Utils.isEmptyString(""), true);
    }

    public void test_isEmptyString003() {
        Assert.assertEquals(Utils.isEmptyString("www"), false);
    }
}
