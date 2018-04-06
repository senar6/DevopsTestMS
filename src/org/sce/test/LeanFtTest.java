package org.sce.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.*;
import com.hp.lft.sdk.utils.AlmUtils;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.verifications.*;

import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
//    	AlmRunInfo runInfo = AlmUtils.getAlmRunInfo();
//    	AlmRunInfo almRunInfo = AlmUtils.getAlmRunInfo();
//    	if (almRunInfo != null) {
//    		BusinessComponentRunInfo bcRunInfo = almRunInfo.getBusinessComponentRunInfo();
//    	}
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
    	Browser browser = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER); 
    	browser.navigate("http://172.25.74.116:3040/");
    	
    	try {
    		
			TimeUnit.SECONDS.sleep(5);
			
			EditField usernameEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
	    			.name("username")
	    			.tagName("INPUT")
	    			.build());
	    	usernameEditField.setValue("John");
	    	
	    	TimeUnit.SECONDS.sleep(5);
	    	
	    	EditField passwordEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
	    			.name("password")
	    			.tagName("INPUT")
	    			.type("password").build());
	    	passwordEditField.setValue("Tcs@123");
	    	
	    	TimeUnit.SECONDS.sleep(5);
	    	
	    	Button loginButton = browser.describe(Button.class, new ButtonDescription.Builder()
	    			.buttonType("submit")
	    			.name("Login")
	    			.tagName("BUTTON").build());
	    	loginButton.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}