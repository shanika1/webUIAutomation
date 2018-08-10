package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.pages.CartPage;

public class Cart {

    public static CartPage ogmCartPage = new CartPage();

    public static String getAccountTitle(){
        return ogmCartPage.getAccountTitle();
    }

    public static void clickCartItems(){
        ogmCartPage.getCartItems();
    }

    public static void removeCartItem(){
        ogmCartPage.removeCartItems();
    }

    public static void addItemtoCart(){
        ogmCartPage.selectProduct();
        ogmCartPage.selectBundleOffers();
        ogmCartPage.selectBundleOfferItem();
        ogmCartPage.addItemToCart();
    }
}
