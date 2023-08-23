package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MagentoCreateAccountPage {
    By pageTitle = By.cssSelector("h1.page-title");
    By firstnameField = By.id("firstname");
    By lastnameField = By.id("lastname");
    By passwordField = By.id("password");
    By passwordconfirmationField = By.id("password-confirmation");
    By emailaddressField = By.id("email_address");
    By createAccountButton = By.cssSelector("button.action.submit.primary");
   public By pageError = By.cssSelector("div.message-error.error.message");
    WebDriver driver;

    Faker faker = new Faker();
    public MagentoCreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkfirstnameFieldDisplayed() {
        return driver.findElement(firstnameField).isDisplayed();
    }

    public boolean checklastnameFieldDisplayed() {
        return driver.findElement(lastnameField).isDisplayed();
    }

    public boolean checkPasswordFieldDisplayed() {
        return driver.findElement(passwordField).isDisplayed();
    }

    public boolean checkPasswordconfirmationFieldDisplayed() {
        return driver.findElement(passwordconfirmationField).isDisplayed();
    }

    public boolean checkEmailaddressFieldDisplayed() {
        return driver.findElement(emailaddressField).isDisplayed();
    }

    public boolean checkcreateAccountButtonDisplayed() {
        return driver.findElement(createAccountButton).isDisplayed();
    }



    public String[] CreateAccount() {
        String[] values = new String[2];
        String email_address= faker.internet().emailAddress();
        String password= "magento@123";
        values[0]= email_address;
        values[1]= password;
        driver.findElement(firstnameField).sendKeys(faker.name().firstName());
        driver.findElement(lastnameField).sendKeys(faker.name().lastName());
        driver.findElement(emailaddressField).sendKeys(email_address);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordconfirmationField).sendKeys(password);
        driver.findElement(createAccountButton).click();
        return values;
    }

      public boolean verifyPageUrl() {
        return driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/customer/account/login/referer");
    }

    public boolean verifyPageTitle() {
        return driver.getTitle().contains("Create New Customer Account");
    }

}
