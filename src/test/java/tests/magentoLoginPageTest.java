package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.MagentoForgotPasswordPage;
import pages.MagentoLoginPage;
import pages.BasePage;
import pages.MagentoHomePage;

public class magentoLoginPageTest extends BasePage {

    @Test(priority = 0)
    public void navigateToLoginPage() {
        MagentoHomePage magentoHomePage = new MagentoHomePage(driver);
        Assert.assertTrue(magentoHomePage.verifyPageUrl());
        Assert.assertTrue(magentoHomePage.verifyPageTitle());
        magentoHomePage.clickSigninLink();
        logger.log(LogStatus.INFO, "Clicking the 'Sign in' link");
    }
    @Test(priority = 1)
    public void verifyLoginPageUrlAndTitle() {
        MagentoLoginPage login = new MagentoLoginPage(driver);
        Assert.assertTrue(login.verifyPageUrl());
        Assert.assertTrue(login.verifyPageTitle());

            }
    @Test(priority = 2)
    public void verifyLoginSectionElements() {
        MagentoLoginPage login = new MagentoLoginPage(driver);
        Assert.assertTrue(login.checkEmailFieldDisplayed());
        Assert.assertTrue(login.checkPasswordFieldDisplayed());
        Assert.assertTrue(login.checksignInButtonDisplayed());
    }
    @Test(priority = 3)
    public void verifyLoginSectionErrorValidation() {
        MagentoLoginPage login = new MagentoLoginPage(driver);
        login.waitUntilSignInButtonDisplayed();
        login.clickSignIn();
        Assert.assertTrue(login.checkUsernameErrorContainerDisplayed());
        Assert.assertTrue(login.checkpasswordErrorContainerDisplayed());
        Assert.assertTrue(login.getUsernameErrorContainerText().contains("This is a required field."));
        Assert.assertTrue(login.getpasswordErrorContainerText().contains("This is a required field."));
    }

    @Test(priority = 4)
    public void verifyForgotPasswordLinkDisplay() {
        MagentoLoginPage login = new MagentoLoginPage(driver);
        Assert.assertTrue(login.checkfortgotPasswordLinkDisplayed());
    }
    @Test(priority = 5)
    public void verifyForgotPasswordLinkNavigation() {
        MagentoLoginPage login = new MagentoLoginPage(driver);
        login.clickfortgotPasswordLink();
        MagentoForgotPasswordPage forgotPasswordPage = new MagentoForgotPasswordPage(driver);
        forgotPasswordPage.verifyPageTitle();
        forgotPasswordPage.verifyPageUrl();
    }
    @Test(priority = 6)
    public void verifyForgotPasswordPageElements() {
        MagentoForgotPasswordPage forgotPasswordPage = new MagentoForgotPasswordPage(driver);
        forgotPasswordPage.checkresetMyPasswordButtonDisplayed();
        forgotPasswordPage.checkEmailFieldDisplayed();
    }
    @Test(priority = 7)
    public void verifyForgotPasswordPageBrowserBackFunctionality() {
        MagentoForgotPasswordPage forgotPasswordPage = new MagentoForgotPasswordPage(driver);
        forgotPasswordPage.performBrowserBack();
        MagentoLoginPage login = new MagentoLoginPage(driver);
        Assert.assertTrue(login.verifyPageUrl());
        Assert.assertTrue(login.verifyPageTitle());
    }

    //	//* Test invalid login attempts using data from DataProvider
    @DataProvider(name = "accounts")
    public Object[][] getData() {
        return new Object[][]{
                {"magento1.user@gmail.com", "testing123"}, // Invalid email, correct password
                {"testuser@yahoo.com", "magento@123"} // Correct email, Invalid password
        };
    }

    @Test(priority = 8, dataProvider = "accounts")
    public void verifyInvalidLoginCredentials(String testUsername, String testPassword) throws InterruptedException {
        MagentoLoginPage login = new MagentoLoginPage(driver);
        login.typeUsername(testUsername);
        logger.log(LogStatus.INFO, "Entering invalid username");
        login.typePassword(testPassword);
        logger.log(LogStatus.INFO, "Entering invalid password");
        login.clickSignIn();
        logger.log(LogStatus.INFO, "Clicking Sign in button");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(login.pageError));
		Assert.assertTrue(login.verifyPageError("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."));
        logger.log(LogStatus.PASS, "Log in with invalid crendentials failed");
    }

    @Test(priority = 9)
    @Parameters({"username", "password"})
    public void verifyLogin(String username, String password) {
        MagentoLoginPage login = new MagentoLoginPage(driver);
        login.typeUsername(username);
        logger.log(LogStatus.INFO, "Entering valid username");
        login.typePassword(password);
        logger.log(LogStatus.INFO, "Entering valid password");
        login.clickSignIn();
        logger.log(LogStatus.INFO, "Clicking Sign in button");
        Assert.assertTrue(login.verifyNewPage());
    }
    @Test(priority = 10)
    public void verifySignOutFeature() {
        MagentoHomePage magentoHomePage = new MagentoHomePage(driver);
        magentoHomePage.clickSignoutLink();
        logger.log(LogStatus.INFO, "Clicking Sign out link");
        magentoHomePage.checkSigninLink();
        logger.log(LogStatus.INFO, "Verified Sign in link after logout");
    }
}	
