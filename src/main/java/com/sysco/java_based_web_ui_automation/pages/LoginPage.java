package com.sysco.java_based_web_ui_automation.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class LoginPage {
    protected static SyscoLabUI syscoLabUIOgm;
    private By txtGoogleSearch = By.id("lst-ib");
    private By drpDay = By.id("age_select_day");
    private By selectDay = By.xpath("//*[@id=\"age_select_day\"]/option[5]");
    private By drpMonth = By.id("age_select_month");
    private By selectMonth = By.xpath("//*[@id=\"age_select_month\"]/option[2]");
    private By drpYear = By.id("age_select_year");
    private By selectYear = By.xpath("//*[@id=\"age_select_year\"]/option[14]");
    private By btnEnter = By.id("age_confirm_btn");


    public static void loadLoginPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }


    public void enterText(String searchString) {
        syscoLabUIOgm.sendKeys(txtGoogleSearch, searchString);
    }

    public void clickDate(){
        syscoLabUIOgm.click(drpDay);
    }

    public void selectDate(){
        syscoLabUIOgm.click(selectDay);
    }

    public void clickMonth(){
        syscoLabUIOgm.click(drpMonth);
    }

    public void selectMonth(){
        syscoLabUIOgm.click(selectMonth);
    }

    public void clickYear(){
        syscoLabUIOgm.click(drpYear);
    }

    public void selectYear(){
        syscoLabUIOgm.click(selectYear);
    }

    public void clickEnter(){
        syscoLabUIOgm.click(btnEnter);
    }

}
