package com.bank.testsuite;

import com.bank.basepage.BasePage;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import com.bank.utility.Utility;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.AccessibleObject;

public class BankTest extends TestBase {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    SoftAssert softAssert;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;
    AccountPage accountPage;

    @BeforeMethod
    public void setUp(){

        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        softAssert = new SoftAssert();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        accountPage = new AccountPage();
    }

    @Test//(groups = {"sanity"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManagerLoginPage.clickOnAddCustommerButton();
        addCustomerPage.sendingTextToFirstNameField("julian");
        addCustomerPage.sendingTextToLastNameField("campbell");
        addCustomerPage.sendingTextToPostCodeField("w25 2rg");
        addCustomerPage.clickOnAddCustomerButton();
        Thread.sleep(4000);
        String expectedAlertMessage = "Customer added successfully";
        String actualAlertMessage = addCustomerPage.gettingTextFromAlertMessage();
        softAssert.assertEquals(expectedAlertMessage,actualAlertMessage);
        softAssert.assertAll();
        Thread.sleep(2000);
        addCustomerPage.clickOnAlertMessage();
    }

    @Test
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManagerLoginPage.clickOnOpenAccountButton();
        openAccountPage.selectOnDrowpDownList("6");
        openAccountPage.selectCurrencyFromDropDownList("Pound");
        Thread.sleep(1000);
        openAccountPage.clickOnProcessButton();
        String expectedAlertMessage = "Account created successfully";
        String actualAlertMessage = openAccountPage.gettingTextFromAlertMessage();
        softAssert.assertEquals(expectedAlertMessage,actualAlertMessage);
        softAssert.assertAll();
        openAccountPage.clickOnAlertMessage();
    }


    @Test
    public void customerShouldLoginAndLogoutSuceessfully(){
        homePage.clickOnCustomerLoginButton();
        customersPage.selectCustomerFromDropDownList("6");
        customersPage.clickOnLoginButton();
        String expectedLogOutText = "Logout";
        String actualLogOutText = accountPage.gettingTextOnLogoutButton();
        softAssert.assertEquals(expectedLogOutText,actualLogOutText);
        softAssert.assertAll();
        accountPage.clickOnLogoutButton();
        customersPage.customerDropDownList("6");
        String expectedCustomerName = "Viral Doshi";
        String actualCustomerName = customersPage.verifyTextSelected();
        softAssert.assertEquals(expectedCustomerName,actualCustomerName);
        softAssert.assertAll();

    }

    @Test
    public void customerShouldDepositMoneySuccessfully(){
        homePage.clickOnCustomerLoginButton();
        customersPage.selectCustomerFromDropDownList("5");
        customersPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.enterTheAmountOnDepositField("100");
        accountPage.clickOnDepositButtonAfterAmountSelected();
        String expectedDepositMessage = "Deposit Successful";
        String actualDepositMessage = accountPage.gettingTextFromConfirmMessage();
        softAssert.assertEquals(expectedDepositMessage,actualDepositMessage);
        softAssert.assertAll();
    }

    @Test
    public void customerShouldWithdrawMoneySuccessfully(){
        homePage.clickOnCustomerLoginButton();
        customersPage.selectCustomerFromDropDownList("5");
        customersPage.clickOnLoginButton();
        accountPage.clickingOnWithdrawlButton();
        accountPage.enterWithdrawlAmount("50");
        accountPage.clickWithdrawButtonAfterAmountEntered();
        String expectedWithdrawMessage = "Transaction successful";
        String actualWithdrawMessage   = accountPage.gettingTextFromWithdrawlConfirmation();
        softAssert.assertEquals(expectedWithdrawMessage,actualWithdrawMessage);
        softAssert.assertAll();
    }
}
