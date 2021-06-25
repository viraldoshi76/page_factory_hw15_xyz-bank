package com.bank.testbase;


import com.bank.propertyreader.PropertyReader;
import com.bank.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Jay
 */
public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(groups = {"sanity"})
    public void openBrowser(){
        selectBrowser(browser);
    }
    @AfterMethod(groups = {"sanity"})
    public void tearDown(){
        closeBrowser();
    }
}
