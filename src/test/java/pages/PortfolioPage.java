package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class PortfolioPage {

    WebDriver driver;

    public PortfolioPage(WebDriver driver){

        this.driver = driver;

    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[1]/h1")
    @CacheLookup
    WebElement portfolio_main_heading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div[1]/div/button[1]")
    @CacheLookup
    WebElement btn_view_as_visitor;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div[1]/div/button[2]")
    @CacheLookup
    WebElement btn_edit_portfolio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[2]/a")
    @CacheLookup
    WebElement btn_add_project;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[3]/div[1]/div/div[2]/div/button")
    @CacheLookup
    WebElement btn_edit_portfolio_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[3]/div[1]/div/div[1]/a")
    @CacheLookup
    WebElement portfolio_item_card;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[2]/h3[1]")
    @CacheLookup
    WebElement about_me_title;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[2]/p[1]")
    @CacheLookup
    WebElement about_me_value;


    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/h2")
    @CacheLookup
    WebElement name_value;


    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/p[1]")
    @CacheLookup
    WebElement title_value;

    public void check_heading_text(String text){
        String value = portfolio_main_heading.getText();
        Assert.assertTrue(value.equals(text));
    }
}
