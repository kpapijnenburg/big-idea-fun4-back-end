package selenium;

import static junit.framework.TestCase.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

    private static SeleniumMethods selenium;

    @BeforeClass
    public static void setup(){
        selenium = new SeleniumMethods();
    }

    @AfterClass
    public static void tearDown(){
        selenium.closeWindow();
    }

    @Test
    public void WhenPageHasLoaded_thenLoginHeaderIsAvailable(){
        assertTrue(selenium.isLoginHeaderAvailable());
    }
}
