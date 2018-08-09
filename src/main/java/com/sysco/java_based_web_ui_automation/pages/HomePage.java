package com.sysco.java_based_web_ui_automation.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class HomePage extends LoginPage{

    private By myAccount = By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul");


    public void clickMyAccount(){
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.click(myAccount);

    }


}
