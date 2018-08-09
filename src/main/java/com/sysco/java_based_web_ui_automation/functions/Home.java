package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.pages.HomePage;

public class Home {

    public static HomePage ogmHomePage = new HomePage();

    public static void clickMyAccount(){
        ogmHomePage.clickMyAccount();
    }
}
