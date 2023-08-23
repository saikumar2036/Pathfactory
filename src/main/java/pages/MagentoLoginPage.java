package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagentoLoginPage {

    public By usernameField = By.id("email");
    By passwordField = By.id("pass");
    By signInButton = By.id("send2");
    By forgotPasswordLink = By.cssSelector("a.action.remind");
    By usernameErrorContainer = By.id("email-error");
    By passwordErrorContainer = By.id("pass-error");
   public By pageError = By.cssSelector("div.message-error.error.message");
    WebDriver driver;
    WebDriverWait wait;


    public MagentoLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkEmailFieldDisplayed() {
        return driver.findElement(usernameField).isDisplayed();
    }

    public boolean checkPasswordFieldDisplayed() {
        return driver.findElement(passwordField).isDisplayed();
    }

    public boolean checksignInButtonDisplayed() {
        return driver.findElement(signInButton).isDisplayed();
    }

    public boolean checkfortgotPasswordLinkDisplayed() {
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public void clickfortgotPasswordLink() {
         driver.findElement(forgotPasswordLink).click();
    }
    public boolean verifyPageError(String name) {
        return (driver.findElement(pageError).getText()).equals(name);
    }


    public void typeUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void typePassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

      public boolean verifyPageUrl() {
        return driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/customer/account/login/referer");
    }

    public boolean verifyPageTitle() {
        return driver.getTitle().contains("Customer Login");
    }

    public boolean verifyNewPage() {
        ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/customer/account/");
        return driver.getTitle().contains("Home Page");
    }

    public boolean checkUsernameErrorContainerDisplayed() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameErrorContainer));
        return driver.findElement(usernameErrorContainer).isDisplayed();
    }
    public void waitUntilSignInButtonDisplayed(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
    }
    public boolean checkpasswordErrorContainerDisplayed() {
        return driver.findElement(passwordErrorContainer).isDisplayed();
    }
    public String getUsernameErrorContainerText() {
        return driver.findElement(usernameErrorContainer).getText();
    }
    public String getpasswordErrorContainerText() {
        return driver.findElement(passwordErrorContainer).getText();
    }

}
