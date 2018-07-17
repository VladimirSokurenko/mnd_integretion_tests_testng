package integrationTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.ContentMarketMenuPage;
import pages.LoginPage;
import pages.PortfolioPage;
import web_driver_setup.WebDriverSetup;


public class ContentCreatorTests extends WebDriverSetup {

    @Test(priority = 1, description = "This test will verify login feature for Content Creator")
    public void login_as_content_creator(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);

        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.check_heading_text("Your portfolio page");
    }

}
