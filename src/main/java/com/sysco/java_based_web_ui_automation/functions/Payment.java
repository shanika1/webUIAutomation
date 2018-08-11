package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.pages.PaymentPage;

public class Payment {

    public static PaymentPage ogmPaymentPage = new PaymentPage();

    public static void selectRadioBtn(){
        ogmPaymentPage.selectRadioBtn();
    }

    public static void clickPurchaseBtn(){
        ogmPaymentPage.clickPurchaseBtn();
    }

    public static String isDisplayedRequiredCardNoMesg(){
        return ogmPaymentPage.isDisplayedRequiredCardNoMesg();
    }

    public static String isDisplayedRequiredCVVMesg(){
        return ogmPaymentPage.isDisplayedRequiredCVVMesg();
    }

    public static String isDisplayedValidationMesg(){
        return ogmPaymentPage.isDisplayedValidationMesg();
    }

    public static void SelectCardNo(){
        ogmPaymentPage.selectCardNo();
    }

    public static void addCardNumber(String cardNo){
        ogmPaymentPage.addCardNumber(cardNo);
    }

    public static String isDisplayedTypeValidationMesg(){
        return ogmPaymentPage.isDisplayedTypeValidationMesg();
    }

    public static void clickExpireDate(){
        ogmPaymentPage.clickExpireDate();
    }

    public static void selectExpireDate(){
        ogmPaymentPage.selectExpireDate();
    }

    public static void clearCardNumber(){
        ogmPaymentPage.clearCardNo();
    }

}
