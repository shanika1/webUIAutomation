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

    public static boolean checkItemName(){
        return ogmCartPage.isDisplayedItemName();
    }

    public static boolean checkItemPrice(){
        return ogmCartPage.isDisplayedItemPrice();
    }

    public static void clickCheckout(){
        ogmCartPage.clickCheckOut();
    }

    public static String isDisplayedZeroInCart() {
        return  ogmCartPage.isDisplayedZeroInCart();
    }
}
