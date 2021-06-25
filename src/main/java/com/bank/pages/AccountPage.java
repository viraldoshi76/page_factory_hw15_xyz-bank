package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;

public class AccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(AccountPage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement textOnLogoutButton;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement clickOnDepositButton;

    @FindBy(xpath = "//input[@type='number']")
    WebElement enterTheAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickOnDepositAfterAmountSelected;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement gettingTextAmountSuccessful;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement clickOnWithdrawlButton;

    @FindBy(xpath = "//input[@type='number']")
    WebElement enterTheAmountOnWithdrawlField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickOnWindrawButtonAfterAmountSelected;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement gettingTextWithrawlSuccessful;

    public String gettingTextOnLogoutButton(){
        log.info("Getting text from Logout Button"+ textOnLogoutButton.toString());
        return getTextFromElement(textOnLogoutButton);
    }

    public void clickOnLogoutButton(){
        clickOnElement(textOnLogoutButton);
        log.info("click on Logout button"+ textOnLogoutButton.toString());
    }

    public void clickOnDepositButton(){
        clickOnElement(clickOnDepositButton);
        log.info("Clicking on Deposit Button"+ clickOnDepositButton.toString());
    }

    public void enterTheAmountOnDepositField(String value){
        sendTextToElement(enterTheAmount,value);
        log.info("enter the amount"+ value+ "to deposit field"+ enterTheAmount.toString());
    }

    public void clickOnDepositButtonAfterAmountSelected(){
        clickOnElement(clickOnDepositAfterAmountSelected);
        log.info("Click On Deposit amount Button after Amount Selected "+ clickOnDepositAfterAmountSelected.toString());
    }

    public String gettingTextFromConfirmMessage(){
        log.info("Getting Text deposited successfully"+ gettingTextAmountSuccessful.toString());
        return getTextFromElement(gettingTextAmountSuccessful);

    }

    public void clickingOnWithdrawlButton(){
        clickOnElement(clickOnWithdrawlButton);
        log.info("clicking on Withdrawl button"+ clickOnWithdrawlButton.toString());
    }

    public void enterWithdrawlAmount(String value){
        sendTextToElement(enterTheAmountOnWithdrawlField,value);
        log.info("enter the amount"+ value+ "on the Withdrawl field"+ enterTheAmountOnWithdrawlField.toString());
    }

    public void clickWithdrawButtonAfterAmountEntered(){
        clickOnElement(clickOnWindrawButtonAfterAmountSelected);
        log.info("Clicking on Withdraw Button After Amount Entered"+ clickOnWindrawButtonAfterAmountSelected.toString());
    }

    public String gettingTextFromWithdrawlConfirmation(){
        log.info("getting text from Withdrawl Successful message"+ gettingTextWithrawlSuccessful.toString());
        return getTextFromElement(gettingTextWithrawlSuccessful);
    }

}
