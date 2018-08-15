package press_officer_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContentMarketMenuPage {

    WebDriver driver;

    public ContentMarketMenuPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[4]/div/span")
    WebElement content_market_tab;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[4]/div/div/div/a[1]")
    WebElement content_creators_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[4]/div/div/div/a[2]")
    WebElement assignments_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[4]/div/div/div/a[3]")
    WebElement about_item;

    public void click_on_content_creators_item(){ content_creators_item.click(); }

    public void click_on_content_market_tab(){ content_market_tab.click(); }

    public void click_on_assignments_item(){ assignments_item.click(); }

    public void click_on_about_item(){ about_item.click(); }

    public void navigate_to(String section){
        click_on_content_market_tab();
        if(section == "creators"){
            click_on_content_creators_item();
        } else if(section == "assignments"){
            click_on_assignments_item();
        } else if(section == "about"){
            click_on_about_item();
        } else {
            System.out.println("no such section");
        }
    }
}
