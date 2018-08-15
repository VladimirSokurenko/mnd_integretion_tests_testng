package content_creator_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SubNavigationMenuPage {

    WebDriver driver;

    public SubNavigationMenuPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"subnav-journalist\"]/div/ul/li[1]/a")
    WebElement assignments_subnavigation_tab;

    @FindBy(how = How.XPATH, using = "//*[@id=\"subnav-journalist\"]/div/ul/li[2]/a")
    WebElement portfolio_subnavigation_tab;

    @FindBy(how = How.XPATH, using = "//*[@id=\"subnav-journalist\"]/div/ul/li[3]/a")
    WebElement about_subnavigation_tab;

    public void click_on_assignments_tab(){ assignments_subnavigation_tab.click(); }

    public void click_on_portfolio_tab(){ portfolio_subnavigation_tab.click(); }

    public void click_on_about_tab(){ about_subnavigation_tab.click(); }


}
