package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagentoHomePage {

    By signinLink = By.xpath("//a[contains(text(), 'Sign In')]");

    By createAccountLink = By.xpath("//a[contains(text(), 'Create an Account')]");
    By signoutLinkNav = By.cssSelector("button.action.switch");
    By signoutLink = By.xpath("//a[contains(text(), 'Sign Out')]");

    WebDriver driver;
    WebDriverWait wait;

    public MagentoHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }
    public void waitUntilSignInButtonDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signinLink));
    }
    public boolean checkSigninLink() {
        return driver.findElement(signinLink).isDisplayed();
    }

    public boolean verifyPageUrl() {
        return driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/");
    }

    public boolean verifyPageTitle() {
        return driver.getTitle().contains("Home Page");
    }

    public void clickSigninLink() {
        driver.findElement(signinLink).click();
    }
    public void clickSignoutLink() {
        waitUntilSignOutButtonDisplayed();
        try {
            driver.findElement(signoutLinkNav).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(signoutLink));
            driver.findElement(signoutLink).click();
        }
        catch (Exception e) {
        driver.findElement(signoutLinkNav).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(signoutLink));
        driver.findElement(signoutLink).click();
    }
    }
    public void waitUntilSignOutButtonDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signoutLinkNav));
    }

    public void clickCreateAccountLink() {
        driver.findElement(createAccountLink).click();
    }

}
	

