package com.sysco.java_based_web_ui_automation.pages;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class AccountPage extends LoginPage{

    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnLogin = By.id("send2");

    public void clickEmail(){
        syscoLabUIOgm.click(txtEmail);
    }

    public void sendEmailAddress(){
        syscoLabUIOgm.sendKeys(txtEmail, "williamjacob802@gmail.com");
    }

    public void sendPassword(){
        syscoLabUIOgm.sendKeys(txtPassword, "12345678");
    }

    public void clickLogin(){
        syscoLabUIOgm.click(btnLogin);
    }
}
