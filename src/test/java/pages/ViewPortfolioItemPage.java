package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ViewPortfolioItemPage {

    WebDriver driver;

    public ViewPortfolioItemPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/div/div/a")
    WebElement link_profile_breadcrumbs;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[2]/div/div/div/div[1]/div/div/h1")
    WebElement portfolio_item_title;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[2]/div/div/div/div[2]/img")
    WebElement profile_avatar_image;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[2]/div/div/div/a")
    WebElement url_link;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[2]/div/div/div/p")
    WebElement potfolio_item_description;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/a/div/img")
    WebElement image_thumbnail;

    @FindBy(how = How.XPATH, using = "/html/body/div[8]/div/button[1]")
    WebElement btn_close_gallery;

    @FindBy(how = How.XPATH, using = "/html/body/div[8]/div/button[3]")
    WebElement btn_next_image;

    @FindBy(how = How.XPATH, using = "/html/body/div[8]/div/button[2]")
    WebElement btn_previous_image;

    @FindBy(how = How.XPATH, using = "//*[@id=\"sign_up_form_submit\"]")
    WebElement codeacademy_logo;

    public void verify_title_is_present(){
        if(portfolio_item_title.isDisplayed()){
            System.out.println("portfolio item title is displayed");
        } else {
            System.out.println("portfolio item title is NOT displayed");
        }
    }

    public void verify_title_text(String text){
        Assert.assertEquals(portfolio_item_title.getText(), text);
    }

    public void verify_description_text(String text){
        Assert.assertEquals(potfolio_item_description.getText(), text);
    }

    public void click_profile_bradcrumbs(){ link_profile_breadcrumbs.click(); }

    public void click_on_image_thumbnail(){ image_thumbnail.click(); }

    public void click_on_close_gallery(){ btn_close_gallery.click(); }

    public void click_on_next_image_btn(){ btn_next_image.click(); }

    public void click_on_previous_image_btn(){ btn_previous_image.click(); }

    public void click_on_url_link(){ url_link.click(); }

    public void switch_to_new_browser_tab(){
        for(String other_site_window : driver.getWindowHandles()){
            driver.switchTo().window(other_site_window);
        }
    }

    public void verify_link_transferring(String title){
        Assert.assertEquals(driver.getTitle(), title);
    }

    public void wait_for_transfer(){
        codeacademy_logo.isDisplayed();
    }

    public void navigate_to_tab(String window){
        driver.switchTo().window(window);
    }


}
