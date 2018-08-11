package com.sysco.java_based_web_ui_automation.pages;

import org.openqa.selenium.By;

public class PaymentPage extends LoginPage {

    private By radiobtnCC = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div[1]/dt/label");
    private By fldCardNumber = By.id("braintree_cc_number");
    private By fldCVV = By.id("braintree_cc_cid");
    private By expireDate = By.xpath("//*[@id=\"payment_form_braintree\"]/li[4]/div/div[1]/div/div[1]/div[2]");
    private By btnPurchase = By.id("payment-method-button");
    private By requiredCardNoMesg = By.id("advice-required-entry-braintree_cc_number");
    private By requiredCVVMesg = By.id("advice-required-entry-braintree_cc_cid");
    private By validationCardMesg = By.id("advice-validate-cc-number-braintree_cc_number");
    private By validateCardTypeMesg = By.id("advice-validate-cc-type-autodetect-braintree_cc_number");
    private By expireDatefromDropdown = By.xpath("//*[@id=\"payment_form_braintree\"]/li[4]/div/div[1]/div/div[2]/ul/li[2]");


    public void selectRadioBtn(){
        syscoLabUIOgm.click(radiobtnCC);
    }

    public void selectCardNoField(){
        syscoLabUIOgm.click(fldCardNumber);
    }

    public void clickPurchaseBtn(){
        syscoLabUIOgm.click(btnPurchase);
    }

    public String isDisplayedRequiredCardNoMesg(){
        return syscoLabUIOgm.getText(requiredCardNoMesg);
    }

    public String isDisplayedRequiredCVVMesg(){
        return syscoLabUIOgm.getText(requiredCVVMesg);
    }

    public String isDisplayedValidationMesg(){
        return syscoLabUIOgm.getText(validationCardMesg);
    }

    public void selectCardNo(){
        syscoLabUIOgm.click(fldCardNumber);
    }

    public void addCardNumber(String cardNo){
        syscoLabUIOgm.sendKeys(fldCardNumber, cardNo);
        syscoLabUIOgm.sleep(2);
    }

    public String isDisplayedTypeValidationMesg(){
        return syscoLabUIOgm.getText(validateCardTypeMesg);
    }

    public void clickExpireDate(){
        syscoLabUIOgm.click(expireDate);
    }

    public void selectExpireDate(){
        syscoLabUIOgm.click(expireDatefromDropdown);
    }

    public void clearCardNo(){
        syscoLabUIOgm.clear(fldCardNumber);
    }
}
