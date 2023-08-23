package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MagentoMyAccountPage {

    WebDriver driver;
    public MagentoMyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean verifyPageUrl() {
        return driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/customer/account/");
    }

    public boolean verifyPageTitle() {
        return driver.getTitle().contains("My Account");
    }


}
