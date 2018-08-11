package com.sysco.java_based_web_ui_automation.tests;


import com.sysco.java_based_web_ui_automation.data.LoginData;
import com.sysco.java_based_web_ui_automation.functions.*;
import com.sysco.java_based_web_ui_automation.utils.ExcelUtil;
import com.sysco.java_based_web_ui_automation.utils.TestBase;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {


    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
    }

    @Test(description = "TC_01", alwaysRun = true)
    public void invalidLogin() throws Exception {

        SoftAssert softAssert = new SoftAssert();
        Login.loadLoginPage();
        Login.setInvalidBirthday();
        softAssert.assertEquals(Login.returnErrorMsg(),"Sorry, your age or location does not permit you to enter at this time.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "invalidLogin",description = "TC_02", alwaysRun = true)
    public void validLogin() throws Exception {
        Login.setBirthday();

    }

    @Test(dependsOnMethods = "validLogin", description = "TC_03", alwaysRun = true)
    public void checkMyAccount() throws Exception {
        Home.clickMyAccount();
    }

    @Test(dependsOnMethods = "checkMyAccount", description = "TC_04", alwaysRun = true)
    public static void isLoginbtnEnable(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Account.isLoginBtnEnable(), "Login button is enable");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "isLoginbtnEnable", description = "TC_05", alwaysRun = true)
    public static void emailValidation(){
        SoftAssert softAssert = new SoftAssert();
        Account.invalidEmailValidation("william.com", "12345678");
        softAssert.assertEquals(Account.returnInvalidEmailMsg(), "Please enter a valid email address. For example johndoe@domain.com.");
        softAssert.assertAll();

    }

    @Test(dependsOnMethods = "emailValidation", description = "TC_06", alwaysRun = true)
    public static void passwordValidation(){
        SoftAssert softAssert = new SoftAssert();
        Account.invalidPasswordValidation("williamjacob802@gmail.com", "qwertyuiop");
        softAssert.assertEquals(Account.returnInvalidPasswordMsg(), "Invalid login or password.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "passwordValidation", description = "TC_07", alwaysRun = true)
    public static void invalidCredentialsValidation(){
        SoftAssert softAssert = new SoftAssert();
        Account.invalidCredentialsLogin("william.com","qwertyuiop");
        softAssert.assertEquals(Account.returnInvalidEmailMsg(), "Please enter a valid email address. For example johndoe@domain.com.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "invalidCredentialsValidation", description = "TC_08", alwaysRun = true)
    public static void emptyCredentialsValidation(){
        SoftAssert softAssert = new SoftAssert();
        Account.emptyCredentialLogin("","");
        softAssert.assertEquals(Account.returnEmptyCredentialMesg(), "This is a required field.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "emptyCredentialsValidation", description = "TC_09", alwaysRun = true)
    public void accountCreation() throws Exception {

        Account.accountCreation("williamjacob802@gmail.com", "12345678");

    }

    @Test(dependsOnMethods = "accountCreation", description = "TC_10", alwaysRun = true)
    public void getAccountTitle() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.getAccountTitle(), "HELLO, WILLIAM JACOB!");
        softAssert.assertAll();

    }

    @Test(dependsOnMethods = "getAccountTitle", description = "TC_11", alwaysRun = true)
    public void removeCartItems() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        Cart.clickCartIcon();
        Cart.removeCartItem();
        softAssert.assertEquals(Cart.isDisplayedZeroInCart(),"0","Expected value does not displayed");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "removeCartItems", description = "TC_12", alwaysRun = true)
    public void addItemtoCart() throws Exception {
        Cart.addItemtoCart();
    }

    @Test(dependsOnMethods = "addItemtoCart", description = "TC_13", alwaysRun = true)
    public void checkSelectedItem() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.checkItemName(),"royal-liqueur-mixed-pack-4");
        softAssert.assertEquals(Cart.checkItemPrice(), "$129.95");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "checkSelectedItem", description = "TC_14", alwaysRun = true)
    public void clickCheckoutBtn() throws Exception {
        Cart.clickCheckout();
    }

    @Test(dependsOnMethods = "clickCheckoutBtn", description = "TC_15", alwaysRun = true)
    public void clickProceedtoCheckoutBtn() throws Exception {
        Cart.clickProceedtocheckout();
    }

    @Test(dependsOnMethods = "clickProceedtoCheckoutBtn", description = "TC_16", alwaysRun = true)
    public void isDisplayedName() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.isDisplayedFirstName(),"william");
        softAssert.assertEquals(Cart.isDisplayedLastName(), "jacob");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "isDisplayedName", description = "TC_17", alwaysRun = true)
    public void continueBtnValidation() throws Exception {
        Cart.clearFirstName();
        Cart.clearLastName();
        Cart.clearAddress1();
        Cart.clearAddress2();
        Cart.clearContactNumber();
        Cart.clickContinuebtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.isDisplayedRequiredMesg(), "This is a required field.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "continueBtnValidation", description = "TC_18", alwaysRun = true)
    public void addDetails() throws Exception {
        Cart.addFirstName("william");
        Cart.addLastName("jacob");
        Cart.addAddress1("Abc");
        Cart.addAdress2("fgfg");
        Cart.removePostCode();
        Cart.selectPostCode();
        Cart.addPostalCode("2000");
        Cart.selectPostalCodeFromDropdown();
        Cart.addContactNumber("2222222222");
        Cart.clickContinuebtn();
    }

    @Test(dependsOnMethods = "addDetails", description = "TC_19", alwaysRun = true)
    public void clickContinuetoProceed() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.isDisplayedDeliveryOptions(), "DELIVERY OPTIONS");
        Cart.clickContinueButton();
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "clickContinuetoProceed", description = "TC_20", alwaysRun = true)
    public void validatePaymentInfo() throws Exception {
        Payment.selectRadioBtn();
        Payment.clickPurchaseBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Payment.isDisplayedRequiredCardNoMesg(),"This is a required field.");
        softAssert.assertEquals(Payment.isDisplayedRequiredCVVMesg(),"This is a required field.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "validatePaymentInfo", description = "TC_21", alwaysRun = true)
    public void validateCardNo() throws Exception {
        Payment.SelectCardNo();
        Payment.addCardNumber("11111111");
        Payment.clickPurchaseBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Payment.isDisplayedValidationMesg(),"Please enter a valid credit card number.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "validateCardNo", description = "TC_22", alwaysRun = true)
    public void validateCardType() throws Exception {
        Payment.clearCardNumber();
        Payment.addCardNumber("aaaaa");
        Payment.clickPurchaseBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Payment.isDisplayedTypeValidationMesg(),"Credit card type is not allowed for this payment method.");
        softAssert.assertAll();
    }

}