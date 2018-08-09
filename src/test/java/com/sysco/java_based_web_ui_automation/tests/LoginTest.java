package com.sysco.java_based_web_ui_automation.tests;


import com.sysco.java_based_web_ui_automation.data.LoginData;
import com.sysco.java_based_web_ui_automation.functions.Account;
import com.sysco.java_based_web_ui_automation.functions.Home;
import com.sysco.java_based_web_ui_automation.functions.Login;
import com.sysco.java_based_web_ui_automation.utils.ExcelUtil;
import com.sysco.java_based_web_ui_automation.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test(description = "login")
    public void testLogin() throws Exception {

        SoftAssert softAssert = new SoftAssert();
        // Sample way to retrive data from excel
        LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        Login.loadLoginPage();
        Login.setInvalidBirthday();
        softAssert.assertEquals(Login.returnErrorMsg(),"Sorry, your age or location does not permit you to enter at this time.");
        Login.setBirthday();
        softAssert.assertAll();

        //Login.quiteDriver();

    }

    @Test(dependsOnMethods = "testLogin", description = "Account")
    public void checkMyAccount() throws Exception {

        Home.clickMyAccount();


    }

    @Test(dependsOnMethods = "checkMyAccount", description = "Account Creation")
    public void accountCreation() throws Exception {

        Account.accountCreation();


    }
}