package com.sysco.java_based_web_ui_automation.tests;


import com.sysco.java_based_web_ui_automation.data.LoginData;
import com.sysco.java_based_web_ui_automation.functions.Account;
import com.sysco.java_based_web_ui_automation.functions.Cart;
import com.sysco.java_based_web_ui_automation.functions.Home;
import com.sysco.java_based_web_ui_automation.functions.Login;
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
    public void testLogin() throws Exception {

        SoftAssert softAssert = new SoftAssert();
        Login.loadLoginPage();
        Login.setInvalidBirthday();
        softAssert.assertEquals(Login.returnErrorMsg(),"Sorry, your age or location does not permit you to enter at this time.");
        Login.setBirthday();
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testLogin", description = "TC_02", alwaysRun = true)
    public void checkMyAccount() throws Exception {
        Home.clickMyAccount();
    }

    @Test(dependsOnMethods = "checkMyAccount", description = "TC_03", alwaysRun = true)
    public static void isLoginbtnEnable(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Account.isLoginBtnEnable(), "Login button is enable");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "isLoginbtnEnable", description = "TC_04", alwaysRun = true)
    public static void emailValidation(){
        SoftAssert softAssert = new SoftAssert();
        Account.invalidEmailValidation("william.com", "12345678");
        softAssert.assertEquals(Account.returnInvalidEmailMsg(), "Please enter a valid email address. For example johndoe@domain.com.");
        softAssert.assertAll();

    }

    @Test(dependsOnMethods = "emailValidation", description = "TC_05", alwaysRun = true)
    public static void passwordValidation(){
        SoftAssert softAssert = new SoftAssert();
        Account.invalidPasswordValidation("williamjacob802@gmail.com", "qwertyuiop");
        softAssert.assertEquals(Account.returnInvalidPasswordMsg(), "Invalid login or password.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "passwordValidation", description = "TC_06", alwaysRun = true)
    public static void invalidCredentialsValidation(){
        SoftAssert softAssert = new SoftAssert();
        Account.invalidCredentialsLogin("william.com","qwertyuiop");
        softAssert.assertEquals(Account.returnInvalidEmailMsg(), "Please enter a valid email address. For example johndoe@domain.com.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "invalidCredentialsValidation", description = "TC_07", alwaysRun = true)
    public static void emptyCredentialsValidation(){
        SoftAssert softAssert = new SoftAssert();
        Account.emptyCredentialLogin("","");
        softAssert.assertEquals(Account.returnEmptyCredentialMesg(), "This is a required field.");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "emptyCredentialsValidation", description = "TC_08", alwaysRun = true)
    public void accountCreation() throws Exception {

        Account.accountCreation("williamjacob802@gmail.com", "12345678");

    }

    @Test(dependsOnMethods = "accountCreation", description = "TC_09", alwaysRun = true)
    public void getAccountTitle() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.getAccountTitle(), "HELLO, WILLIAM JACOB!");
        softAssert.assertAll();

    }

    @Test(dependsOnMethods = "getAccountTitle", description = "TC_10", alwaysRun = true)
    public void removeCartItems() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        Cart.clickCartIcon();
        Cart.removeCartItem();
        Cart.clickCartIcon();
        softAssert.assertEquals(Cart.isDisplayedZeroInCart(),"0","Expected value does not displayed");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "removeCartItems", description = "TC_11", alwaysRun = true)
    public void addItemtoCart() throws Exception {
        Cart.addItemtoCart();
    }

//    @Test(dependsOnMethods = "addItemtoCart", description = "TC_13", alwaysRun = true)
//    public void checkSelectedItem() throws Exception {
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(Cart.checkItemName(),"ROYAL LIQUEUR - MIXED PACK 4");
//        softAssert.assertTrue(Cart.checkItemPrice(), "$129.95");
//        softAssert.assertAll();
//    }
//
//    @Test(dependsOnMethods = "checkSelectedItem", description = "TC_14", alwaysRun = true)
//    public void clickCheckoutBtn() throws Exception {
//        Cart.clickCheckout();
//    }


}