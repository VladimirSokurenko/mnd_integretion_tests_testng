package content_creator_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContentMarketMenuPage {

    WebDriver driver;

    public ContentMarketMenuPage(WebDriver driver){

        this.driver = driver;

    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[6]/div/span")
    @CacheLookup
    WebElement cm_navigation_tab;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[6]/div/div/div/a[1]")
    @CacheLookup
    WebElement assignments_drop_down;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[6]/div/div/div/a[2]")
    @CacheLookup
    WebElement portfolio_drop_down;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[6]/div/div/div/a[3]")
    @CacheLookup
    WebElement about_drop_down;

    public void open_cm_menu(){ cm_navigation_tab.click(); }

    public void navigate_to(String section){

        if (section == "portfolio"){

            portfolio_drop_down.click();

        } else if(section == "assignments") {

            assignments_drop_down.click();

        } else if(section == "about") {

            about_drop_down.click();

        } else {

            System.out.println("no such section");

        }

    }
}
