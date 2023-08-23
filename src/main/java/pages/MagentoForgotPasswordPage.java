package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagentoForgotPasswordPage {

    By emailField = By.id("email_address");
    By resetMyPasswordButton = By.xpath("//*[@id='form-validate']//button");
    WebDriver driver;
    public MagentoForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkEmailFieldDisplayed() {
        return driver.findElement(emailField).isDisplayed();
    }

    public boolean checkresetMyPasswordButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetMyPasswordButton));
        return driver.findElement(resetMyPasswordButton).isDisplayed();
    }
    public void performBrowserBack() {
         driver.navigate().back();}


    public boolean verifyPageUrl() {
        return driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");
    }

    public boolean verifyPageTitle() {
        return driver.getTitle().contains("Forgot Your Password?");
    }



}
