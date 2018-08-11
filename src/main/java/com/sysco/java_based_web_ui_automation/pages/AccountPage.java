package com.sysco.java_based_web_ui_automation.pages;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class AccountPage extends LoginPage{

    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnLogin = By.id("send2");
    private By txtLogin = By.xpath("//*[@id=\"send2\"]/span/span");
    private By invalidLoginMsg = By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/ul/li/ul/li");
    private By invalidEmailMesg = By.xpath("//*[@id=\"advice-validate-email-email\"]");
    private By emptyCredentialMesg = By.xpath("//*[@id=\"advice-required-entry-email\"]");

    public boolean btnLoginEnable(){
        return syscoLabUIOgm.isClickable(txtLogin);
    }

    public void clickEmail(){
        syscoLabUIOgm.click(txtEmail);
    }

    public void sendInvalidEmail(String invalidEmail){
        syscoLabUIOgm.sendKeys(txtEmail, invalidEmail);
    }

    public void sendInvalidPassword(String invalidPassword){
        syscoLabUIOgm.sendKeys(txtPassword, invalidPassword);
    }

    public void sendEmailAddress(String email){

        syscoLabUIOgm.sendKeys(txtEmail, email);
    }

    public void sendPassword(String password){
        syscoLabUIOgm.sendKeys(txtPassword, password);
    }

    public void clickLogin(){

        syscoLabUIOgm.click(btnLogin);
        syscoLabUIOgm.sleep(3);
    }

    public String returnInvalidEmailMsg(){
        return  syscoLabUIOgm.getText(invalidEmailMesg);
    }

    public String returnInvaildPasswordMsg(){
        return syscoLabUIOgm.getText(invalidLoginMsg);
    }

    public String returnEmptyCredentialMesg(){
        return syscoLabUIOgm.getText(emptyCredentialMesg);
    }
}
