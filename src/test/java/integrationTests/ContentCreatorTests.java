package integrationTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import web_driver_setup.WebDriverSetup;

    /**
    @Test(dependsOnMethods = "{test_case_1, tes_case_2}")
    this is dependence, for grouping the test cases */

    /**
    Assertion usage hint
     Assert.assertEquals(Sting a, String a1, "also some assertion description could be add, displayed in case of test failure");

     <============>

     String a = "test is the test"
     Assert.assertTrue(a.contains("test")); == true

     Soft assertion
        SoftAssert s = new SoftAssert();
        s.assertEquals(12, 13);
        s.assertAll();

     */




public class ContentCreatorTests extends WebDriverSetup {

    @Test(priority = 1, description = "This test will verify login feature for Content Creator")
    public void login_as_content_creator_test(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
    }

    @Test(priority = 2, description = "verify view as visitor feature")
    public void view_as_visitor_test() {
        ViewAsVisitorPage viewAsVisitorPage = PageFactory.initElements(driver, ViewAsVisitorPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        portfolioPage.click_view_as_visitor_btn();
        portfolioPage.verify_portfolio_sections_present();
        viewAsVisitorPage.click_back_btn();
        portfolioPage.verify_portfolio_sections_present();
    }

    @Test(priority = 3, description = "verify edit portfolio")
    public void edit_portfolio_test() throws InterruptedException{
        EditPortfolioPage editPortfolioPage = PageFactory.initElements(driver, EditPortfolioPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.click_edit_portfolio_btn();
        editPortfolioPage.agile_avatar_upload("/home/alexander/Desktop/testng.jpg");
        editPortfolioPage.agile_cover_image_upload("/home/alexander/Desktop/coverimg.jpg");
        String random_name = get_random_text("name:");
        editPortfolioPage.fill_in_name_field(random_name);
        String random_title = get_random_text("title:");
        editPortfolioPage.fill_in_title_filed(random_title);
        String random_about = get_random_text("About me:");
        editPortfolioPage.fill_in_about_field(random_about);
        editPortfolioPage.click_save_portfolio_btn();
        portfolioPage.verify_name_text(random_name);
        portfolioPage.verify_title_text(random_title);
        portfolioPage.verify_about_text(random_about);
        portfolioPage.verify_avatar_is_displayed();
        portfolioPage.verify_cover_image_is_displayed();

    }

    @Test(priority = 4, description = "verify create portfolio item")
    public void create_portfolio_item() throws InterruptedException{
        EditPortfolioPage editPortfolioPage = PageFactory.initElements(driver, EditPortfolioPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        NewPortfolioItemPage newPortfolioItemPage = PageFactory.initElements(driver, NewPortfolioItemPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.click_add_project_btn();
        String random_title = get_random_text("test: ");
        newPortfolioItemPage.fill_in_title(random_title);
        String random_description = get_random_text("description: ");
        newPortfolioItemPage.fill_in_description(random_description);
        newPortfolioItemPage.fill_in_url("www.youtube.com");
        newPortfolioItemPage.upload_portfolio_item_image("/home/alexander/Desktop/coverimg.jpg");
        newPortfolioItemPage.click_save_portfolio_item_btn();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.verify_portfolio_item_title_text(random_title);
        portfolioPage.verify_portfolio_item_description_text(random_description);
        portfolioPage.verify_cover_image_is_displayed();
    }
}
