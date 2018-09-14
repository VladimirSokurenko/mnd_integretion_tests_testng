package content_creator_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")
    WebElement log_in_btn;

    public void verify_login_button_present(String text){
        Assert.assertEquals(log_in_btn.getText(), text);
    }
}
