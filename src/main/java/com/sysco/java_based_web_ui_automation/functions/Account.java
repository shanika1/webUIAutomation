package com.sysco.java_based_web_ui_automation.functions;

import com.sysco.java_based_web_ui_automation.pages.AccountPage;

public class Account {

    public static AccountPage ogmAccountPage = new AccountPage();

    public static boolean isLoginBtnEnable(){
        return ogmAccountPage.btnLoginEnable();
    }

    public static void invalidEmailValidation(String invalidEmail, String password){
        ogmAccountPage.sendInvalidEmail(invalidEmail);
        ogmAccountPage.sendPassword(password);
        ogmAccountPage.clickLogin();

    }

    public static String returnInvalidEmailMsg(){
        return ogmAccountPage.returnInvalidEmailMsg();
    }

    public static void invalidPasswordValidation(String email, String invalidPassword){
        ogmAccountPage.sendEmailAddress(email);
        ogmAccountPage.sendInvalidPassword(invalidPassword);
        ogmAccountPage.clickLogin();
    }

    public static String returnInvalidPasswordMsg(){
        return ogmAccountPage.returnInvaildPasswordMsg();
    }

    public static void emptyCredentialLogin(String email, String password){
        ogmAccountPage.sendEmailAddress(email);
        ogmAccountPage.sendPassword(password);
        ogmAccountPage.clickLogin();
    }

    public static void invalidCredentialsLogin(String invalidEmail, String invalidPassword){
        ogmAccountPage.sendInvalidEmail(invalidEmail);
        ogmAccountPage.sendInvalidPassword(invalidPassword);
        ogmAccountPage.clickLogin();
    }

    public static String returnEmptyCredentialMesg(){
        return  ogmAccountPage.returnEmptyCredentialMesg();
    }

    public static void accountCreation(String email, String password){
        ogmAccountPage.clickEmail();
        ogmAccountPage.sendEmailAddress(email);
        ogmAccountPage.sendPassword(password);
        ogmAccountPage.clickLogin();
    }
}
