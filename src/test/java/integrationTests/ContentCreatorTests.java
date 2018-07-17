package integrationTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import web_driver_setup.WebDriverSetup;


public class ContentCreatorTests extends WebDriverSetup {

    @Test
    public void login_as_content_creator(){

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        go_to_the_site("staging");
        loginPage.fill_in_username("test3");
        loginPage.fill_in_password("123123qwe");
        loginPage.click_login_btn();

    }

}
