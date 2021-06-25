package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement clickOnCustomerLoginButton;

    public void clickOnBankManagerLoginButton(){
        clickOnElement(bankManagerLoginButton);
        log.info("Clicking on Bank Manager Button"+ bankManagerLoginButton.toString());
    }

    public void clickOnCustomerLoginButton(){
        clickOnElement(clickOnCustomerLoginButton);
    }

}
