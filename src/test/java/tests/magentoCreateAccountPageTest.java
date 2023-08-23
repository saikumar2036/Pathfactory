package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class magentoCreateAccountPageTest extends BasePage {
    @Test(priority = 0)
    public void createAccountAndLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MagentoHomePage magentoHomePage = new MagentoHomePage(driver);
        Assert.assertTrue(magentoHomePage.verifyPageUrl());
        Assert.assertTrue(magentoHomePage.verifyPageTitle());
        magentoHomePage.clickCreateAccountLink();
        logger.log(LogStatus.INFO, "Clicking the 'Create Account' link");
        MagentoCreateAccountPage CreateAccountPage = new MagentoCreateAccountPage(driver);
        String[] values = CreateAccountPage.CreateAccount();
        MagentoHomePage HomePage = new MagentoHomePage(driver);
        HomePage.clickSignoutLink();
        HomePage.waitUntilSignInButtonDisplayed();
        HomePage.clickSigninLink();
        MagentoLoginPage login = new MagentoLoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(login.usernameField));
        login.typeUsername(values[0]);
        logger.log(LogStatus.INFO, "Entering valid username");
        login.typePassword(values[1]);
        logger.log(LogStatus.INFO, "Entering valid password");
        login.clickSignIn();
        logger.log(LogStatus.INFO, "Clicking Sign in button");
        MagentoMyAccountPage accountPage = new MagentoMyAccountPage(driver);
        Assert.assertTrue(accountPage.verifyPageTitle());
        logger.log(LogStatus.INFO, "Clicking My account title");
        Assert.assertTrue(accountPage.verifyPageUrl());
        logger.log(LogStatus.INFO, "Clicking My account url");
    }
}
