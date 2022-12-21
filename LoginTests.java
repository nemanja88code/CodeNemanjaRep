package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{
    
    public LoginPage loginPage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";

    String lockedOutUser = "locked_out_user";
    String errorText = "Epic sadface: Sorry, this user has been locked out.";
    String emptyUsername = "";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPassword = "";
    String emptyPasswordError = "Epic sadface: Password is required";
    String badUsername = "test";
    String badUsernamePasswordError = "Epic sadface: Username and password do not match any user in this service";
    String badPassword = "test";


    @Test
    public void verifySuccesfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    @Test
    public void verifyUnsuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);

    loginPage.basePage();
    loginPage.login(lockedOutUser, password);
    loginPage.verifyUnsuccesfulLogin(errorText);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }

    @Test
    public void verifyUnsuccesfulLoginWithEmptyUsername(){
    LoginPage loginPage = new LoginPage(driver);

    loginPage.basePage();
    loginPage.login(emptyUsername, password);
    loginPage.verifyUnsuccesfulLogin(emptyUsernameError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }
    
    @Test
    public void verifyUnsuccesfulLoginWithEmptyPassword(){
    LoginPage loginPage = new LoginPage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, emptyPassword);
    loginPage.verifyUnsuccesfulLogin(emptyPasswordError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }


    @Test
    public void verifyUnsuccesfulLoginWithBadUsername(){
    LoginPage loginPage = new LoginPage(driver);

    loginPage.basePage();
    loginPage.login(badUsername, password);
    loginPage.verifyUnsuccesfulLogin(badUsernamePasswordError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }


    @Test
    public void verifyUnsuccesfulLoginWithBadPassword(){
    LoginPage loginPage = new LoginPage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, badPassword);
    loginPage.verifyUnsuccesfulLogin(badUsernamePasswordError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }

}
