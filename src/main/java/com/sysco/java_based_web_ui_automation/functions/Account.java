package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.pages.AccountPage;

public class Account {

    public static AccountPage ogmAccountPage = new AccountPage();

    public static void accountCreation(){
        ogmAccountPage.clickEmail();
        ogmAccountPage.sendEmailAddress();
        ogmAccountPage.sendPassword();
        ogmAccountPage.clickLogin();
    }
}
