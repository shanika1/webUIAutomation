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
    private By selectedItemPrice = By.xpath("//ol[@id='mini-cart']/li[@class='item odd']//table//span[@class='price']");
    private By selectedItemName = By.xpath("//ol[@id='mini-cart']//p[@class='product-name']/a[@href='https://www.bundabergrum.com.au/royal-liqueur-mixed-pack-4']");
    private By btnCheckout = By.xpath("//*[@id=\"topCartContent\"]/div/div/div/button");
    private By cartZeroValue = By.xpath("//*[@id=\"quick-access-list\"]/li[2]/ul/li[3]/div/div[1]/span[2]");
    private By btnProceedtoCheckout = By.xpath("/html/body/div[2]/div[3]/div[2]/div/div[1]/div[1]/div/ul/li[2]/button");
    private By fldFirstName = By.id("billing:firstname");
    private By fldLastName = By.id("billing:lastname");
    private By btnContinue = By.id("delivery-address-button");
    private By requiredErrorMesg = By.id("advice-required-entry-billing:firstname");
    String value = "value";
    private By txtAddress1 = By.id("billing:street1");
    private By txtAddress2 = By.id("billing:street2");
    private By contactNumber = By.id("billing:telephone");
    private By postCode = By.id("billing:postcodesuburbremove");
    private By selectPostCode = By.id("billing:postcodesuburb");
    private By postCodeFromDropdown = By.xpath("//*[@id=\"Autocomplete_billing:postcodesuburb\"]/div[1]");
    private By txtDeliveryOptions = By.xpath("//*[@id=\"opc-shipping_method\"]/div[1]/h2");
    private By btnNewContinue = By.id("shipping-method-button");

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

    public String isDisplayedItemPrice(){
        syscoLabUIOgm.sleep(1);
        return (syscoLabUIOgm.getText(selectedItemPrice));
    }

    public String isDisplayedItemName(){
        syscoLabUIOgm.sleep(1);
        return (syscoLabUIOgm.getText(selectedItemName));
    }

    public void clickCheckOut(){
        syscoLabUIOgm.mouseHover(btnCheckout);
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.click(btnCheckout);
        syscoLabUIOgm.sleep(2);
    }

    public void clickProceedtoCheckoutBtn(){
        syscoLabUIOgm.click(btnProceedtoCheckout);
    }

    public String isDisplayedFirstName(){
        return (syscoLabUIOgm.getAttribute(fldFirstName,value));
    }

    public String isDisplayedLastName(){
        return (syscoLabUIOgm.getAttribute(fldLastName,value));
    }

    public void clearFirstName(){
        syscoLabUIOgm.clear(fldFirstName);
        syscoLabUIOgm.sleep(2);
    }

    public void clearLastName(){
        syscoLabUIOgm.clear(fldLastName);
        syscoLabUIOgm.sleep(2);
    }

    public void clearAddress1(){
        syscoLabUIOgm.clear(txtAddress1);
    }

    public void clearAddress2(){
        syscoLabUIOgm.clear(txtAddress2);
    }

    public void clearContactnumber(){
        syscoLabUIOgm.clear(contactNumber);
    }

    public void clickContinueBtn(){
        syscoLabUIOgm.click(btnContinue);
    }

    public void removePostCode(){
        syscoLabUIOgm.click(postCode);
        syscoLabUIOgm.sleep(3);
    }

    public void selectPostCode(){
        syscoLabUIOgm.click(selectPostCode);
    }

    public void addFirstName(String firstName){
        syscoLabUIOgm.sendKeys(fldFirstName, firstName);
        syscoLabUIOgm.sleep(2);
    }

    public void addLastName(String lastName){
        syscoLabUIOgm.sendKeys(fldLastName, lastName);
        syscoLabUIOgm.sleep(2);
    }

    public void addAddress1(String address1){
        syscoLabUIOgm.sendKeys(txtAddress1, address1);
        syscoLabUIOgm.sleep(2);
    }

    public void addAddress2(String address2){
        syscoLabUIOgm.sendKeys(txtAddress2, address2);
        syscoLabUIOgm.sleep(2);
    }

    public void addContactNumber(String contactNo){
        syscoLabUIOgm.sendKeys(contactNumber, contactNo);
        syscoLabUIOgm.sleep(2);
    }

    public void addPostCode(String validPostCode){
        syscoLabUIOgm.sendKeys(selectPostCode, validPostCode);
        syscoLabUIOgm.sleep(2);
    }

    public void selectPostCodeFromDropDown(){
        syscoLabUIOgm.click(postCodeFromDropdown);
    }

    public String isDisplayedRequiredMesg(){
        return syscoLabUIOgm.getText(requiredErrorMesg);
    }

    public String isDisplayedZeroInCart() {
        return (syscoLabUIOgm.getText(cartZeroValue));
    }

    public String isDisplayedDeliveryOptions(){
        return syscoLabUIOgm.getText(txtDeliveryOptions);
    }

    public void clickContinueButton(){
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.click(btnNewContinue);
        syscoLabUIOgm.sleep(2);
    }

}
