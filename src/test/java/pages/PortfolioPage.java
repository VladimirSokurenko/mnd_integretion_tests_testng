package pages;

import org.openqa.selenium.JavascriptExecutor;
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
    WebElement portfolio_main_heading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]/div/div/i")
    WebElement portfolio_avatar_placeholder;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[1]/img")
    WebElement portfolio_cover_iamge;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div[1]/div/button[1]")
    WebElement btn_view_as_visitor;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div[1]/div/button[2]")
    WebElement btn_edit_portfolio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[2]/a")
    WebElement btn_add_project;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[3]/div[1]/div/div[2]/div/button")
    WebElement btn_edit_portfolio_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[3]/div[1]/div/div[1]/a")
    WebElement portfolio_item_card;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[2]/h3[1]")
    WebElement about_me_title;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[2]/p[1]")
    WebElement about_me_value;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/h2")
    WebElement name_value;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/p[1]")
    WebElement title_value;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/p[2]")
    WebElement service_value;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[1]/h2")
    WebElement portfolio_items_heading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[3]/div[1]/div/div[1]/a/h3")
    WebElement portfolio_item_title;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[3]/div[1]/div/div[1]/a/span/p")
    WebElement portfolio_item_description;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[3]/div[1]/div/div[1]/a/div/img")
    WebElement portfolio_item_cover_image;


      public void verify_main_heading_present(){ Assert.assertTrue(portfolio_main_heading.isDisplayed()); }

      public void verify_about_me_present(){ Assert.assertTrue(about_me_title.isDisplayed()); }

      public void verify_portfolio_items_heading_present(){ Assert.assertTrue(portfolio_items_heading.isDisplayed()); }

      public void verify_portfolio_sections_present(){

          verify_main_heading_present();
          verify_about_me_present();
          verify_portfolio_items_heading_present();

      }

      public void click_view_as_visitor_btn(){ btn_view_as_visitor.click(); }

      public void click_edit_portfolio_btn(){ btn_edit_portfolio.click(); }

      public void verify_name_text(String name_text){
          Assert.assertEquals(name_value.getText(), name_text, "text does not match");
      }

      public void verify_title_text(String title_text){
          Assert.assertEquals(title_value.getText(), title_text, "text does not match");
      }

      public void verify_about_text(String about_text){
          Assert.assertEquals(about_me_value.getText(), about_text, "text does not match");
      }

      public void verify_avatar_is_displayed(){ portfolio_avatar_placeholder.isDisplayed(); }

      public void verify_cover_image_is_displayed(){ portfolio_cover_iamge.isDisplayed(); }

      public void click_add_project_btn(){ btn_add_project.click(); }

      public void scroll_to_portfolio_items_section(){
          ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", portfolio_item_card);
      }

      public void verify_portfolio_item_title_text(String title_text){
          Assert.assertEquals(portfolio_item_title.getText(), title_text);
      }

        public void verify_portfolio_item_description_text(String description_text){
          Assert.assertEquals(portfolio_item_description.getText(), description_text);
      }

        public void verify_portfolio_item_url_text(String url_text){
         // Assert.assertEquals();
      }

      public void verify_portfolio_item_cover_image(){
          portfolio_item_cover_image.isDisplayed();
      }











}
