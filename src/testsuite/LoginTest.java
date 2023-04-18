package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest { //Extended class

    String baseUrl = "https://courses.ultimateqa.com/";//Baseurl for WebPage

    @Before

    public void setUp(){   //Set Up for Open Browser
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //find loginLink and click on loginLink
        WebElement signInLink = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        signInLink.click();

        //Verify the text 'Welcome Back'
       String expectedMessage = "Welcome Back!";
       WebElement actualTextMessage = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualMessage = actualTextMessage.getText();
       Assert.assertEquals("Message Display",expectedMessage,actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        //click Sign In Link
        WebElement signInLink = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        signInLink.click();
        //Input Email Field
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='user[email]']"));
        userEmailField.sendKeys("123dcfrs");
        //Input password Field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='user[password]']"));
        passwordField.sendKeys("xdesf1sd");
        //Click on Login Button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']"));
        loginBtn.click();

        //To verify the Error Message
        String expectedTextMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid email or password.",expectedTextMessage,actualMessage);

        driver.close();



    }

}
