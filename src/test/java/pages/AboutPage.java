package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AboutPage {

    WebDriver driver;

    public AboutPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/div/h1")
    WebElement about_heading_section;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[2]")
    WebElement about_infobox;

    public void verify_heading_text(String heading_text){
        Assert.assertEquals(about_heading_section.getText(), heading_text);
    }

    public void verify_infobox_present(){
        about_infobox.isDisplayed();

    }
}
