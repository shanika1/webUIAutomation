package com.sysco.java_based_web_ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CartPage extends LoginPage {


    public RemoteWebDriver driver = null;

    private By cartbtn = By.id("cartHeader");
    private By cartquantity =By.xpath("//li[2]/ul/li[3]/div/div[1]/span[2]");
    private By btnRemove = By.xpath("//a[@title='Remove']");
    private By accountTitle = By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[1]/h2");
    private By lblProducts = By.xpath("//div[@id='nav-wrapper']/div/ul[1]/li[@class='link-product']");
    private By lbloffer = By.xpath("//*[@id=\"nav-wrapper\"]/div/div[4]/div[1]/div[1]/ul/li/ul/li[6]/a");
    private By lblofferItem = By.xpath("//*[@id=\"main-image\"]/img");
    private By btnAddtoCart = By.xpath("//*[@id=\"bundleSummary\"]/div/div[3]/button");
    private By selectedItemPrice = By.xpath("//*[@id=\"topCartContent\"]/div/div/p/span[2]");
    private By selectedItemName = By.xpath("//*[@id=\"mini-cart\"]/li/div/p/a");
    private By btnCheckout = By.xpath("//*[@id=\\\"topCartContent\\\"]/div/div/div/button");
    private By cartZeroValue = By.xpath("//*[@id=\"quick-access-list\"]/li[2]/ul/li[3]/div/div[1]/span[2]");


    public String getAccountTitle(){
        return syscoLabUIOgm.getText(accountTitle);
    }


    public WebElement findElement(By by){
        return this.driver.findElement(by);
    }

    public String getText (By by){
        WebElement element = this.findElement(by);
        return element.getText();
    }

    public void clickCartIcon() {
        syscoLabUIOgm.sleep(1);
        syscoLabUIOgm.click(cartbtn);
        syscoLabUIOgm.sleep(3);
    }

    public void removeCartItem() {
        int i = 0;
        while (Integer.parseInt(syscoLabUIOgm.getText(cartquantity)) != 0) {
            syscoLabUIOgm.click(cartbtn);
            //syscoLabUIOgm.sleep(3);
            syscoLabUIOgm.click(btnRemove);
            syscoLabUIOgm.sleep(3);
            syscoLabUIOgm.isAlertDisplayed();
            syscoLabUIOgm.sleep(3);
            syscoLabUIOgm.clickOkInWindowsAlert();
            syscoLabUIOgm.sleep(3);
        }
    }

    public void selectProduct(){
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.mouseHover(lblProducts);
        syscoLabUIOgm.sleep(3);
    }

    public void selectBundleOffers(){
        syscoLabUIOgm.mouseHover(lblProducts);
        syscoLabUIOgm.click(lbloffer);
        syscoLabUIOgm.sleep(3);
    }
    public void selectBundleOfferItem(){
        syscoLabUIOgm.mouseHover(lblofferItem);
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.click(lblofferItem);
        syscoLabUIOgm.sleep(3);
    }

    public void addItemToCart(){
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.mouseHover(btnAddtoCart);
        syscoLabUIOgm.click(btnAddtoCart);
    }

    public boolean isDisplayedItemPrice(){
        return syscoLabUIOgm.isDisplayed(selectedItemPrice);
    }

    public boolean isDisplayedItemName(){
        return syscoLabUIOgm.isDisplayed(selectedItemName);
    }

    public void clickCheckOut(){
        syscoLabUIOgm.mouseHover(btnCheckout);
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.click(btnCheckout);
        syscoLabUIOgm.sleep(2);
    }

    public String isDisplayedZeroInCart() {
        return (syscoLabUIOgm.getText(cartZeroValue));
    }

}
