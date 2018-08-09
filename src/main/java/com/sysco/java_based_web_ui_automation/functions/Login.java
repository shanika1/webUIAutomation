package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.common.Constants;
import com.sysco.java_based_web_ui_automation.pages.LoginPage;
import com.sysco.java_based_web_ui_automation.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class Login  {

    public static LoginPage ogmLoginPage = new LoginPage();


    public static void loadLoginPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            ogmLoginPage.loadLoginPage(capabilities, Constants.APP_URL);
        } else {
            ogmLoginPage.loadLoginPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }


    public static void quiteDriver() {
        ogmLoginPage.quitDriver();
    }

    public static void loginToFtr() {

    }

    public static void setInvalidBirthday(){
        ogmLoginPage.clickDate();
        ogmLoginPage.selectInvalidDate();
        ogmLoginPage.clickMonth();
        ogmLoginPage.selectInvalidMonth();
        ogmLoginPage.clickYear();
        ogmLoginPage.selectInvalidYear();
        ogmLoginPage.clickEnter();
    }

    public static void setBirthday(){
        ogmLoginPage.clickDate();
        ogmLoginPage.selectDate();
        ogmLoginPage.clickMonth();
        ogmLoginPage.selectMonth();
        ogmLoginPage.clickYear();
        ogmLoginPage.selectYear();
        ogmLoginPage.clickEnter();
    }

    public static String returnErrorMsg(){
        return ogmLoginPage.returnErrorMsg();
    }


}
