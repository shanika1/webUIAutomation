package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.pages.CartPage;

public class Cart {

    public static CartPage ogmCartPage = new CartPage();

    public static String getAccountTitle(){
        return ogmCartPage.getAccountTitle();
    }

    public static void clickCartIcon(){
        ogmCartPage.clickCartIcon();
    }

    public static void removeCartItem() {
        ogmCartPage.removeCartItem();
    }

    public static void addItemtoCart(){
        ogmCartPage.selectProduct();
        ogmCartPage.selectBundleOffers();
        ogmCartPage.selectBundleOfferItem();
        ogmCartPage.addItemToCart();
    }

    public static String checkItemName(){
        return ogmCartPage.isDisplayedItemName();
    }

    public static String checkItemPrice(){
        return ogmCartPage.isDisplayedItemPrice();
    }

    public static void clickCheckout(){
        ogmCartPage.clickCheckOut();
    }

    public static void clickProceedtocheckout(){
        ogmCartPage.clickProceedtoCheckoutBtn();
    }

    public static String isDisplayedFirstName(){
       return ogmCartPage.isDisplayedFirstName();
    }

    public static String isDisplayedLastName(){
        return ogmCartPage.isDisplayedLastName();
    }

    public static void clearFirstName(){
        ogmCartPage.clearFirstName();
    }

    public static void clearLastName(){
        ogmCartPage.clearLastName();
    }

    public static void clearAddress1(){
        ogmCartPage.clearAddress1();
    }

    public static void clearAddress2(){
        ogmCartPage.clearAddress2();
    }

    public static void clearContactNumber(){
        ogmCartPage.clearContactnumber();
    }

    public static void clickContinuebtn(){
        ogmCartPage.clickContinueBtn();
    }

    public static void removePostCode(){
        ogmCartPage.removePostCode();
    }

    public static void selectPostCode(){
        ogmCartPage.selectPostCode();
    }

    public static void addFirstName(String firstName){
        ogmCartPage.addFirstName(firstName);
    }

    public static void addLastName(String lastName){
        ogmCartPage.addLastName(lastName);
    }

    public static void addAddress1(String address1){
        ogmCartPage.addAddress1(address1);
    }

    public static void addAdress2(String address2){
        ogmCartPage.addAddress2(address2);
    }

    public static void addPostalCode(String validPostCode){
        ogmCartPage.addPostCode(validPostCode);
    }

    public static void selectPostalCodeFromDropdown(){
        ogmCartPage.selectPostCodeFromDropDown();
    }

    public static void addContactNumber(String contactNo){
        ogmCartPage.addContactNumber(contactNo);
    }

    public static String isDisplayedRequiredMesg(){
        return ogmCartPage.isDisplayedRequiredMesg();
    }

    public static String isDisplayedZeroInCart() {
        return  ogmCartPage.isDisplayedZeroInCart();
    }

    public static String isDisplayedDeliveryOptions(){
        return ogmCartPage.isDisplayedDeliveryOptions();
    }

    public static void clickContinueButton(){
        ogmCartPage.clickContinueButton();
    }
}
