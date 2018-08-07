package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewPortfolioItemPage {

    WebDriver driver;

    public NewPortfolioItemPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(how = How.NAME, using = "title")
    WebElement title_field;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/textarea")
    WebElement description_field;

    @FindBy(how = How.NAME, using = "url")
    WebElement url_field;

    @FindBy(how = How.NAME, using = "imageUrls")
    WebElement add_portfolio_image_field;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/form/div[2]/div/div/div/div/button[2]")
    WebElement btn_save_portfolio_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/form/div[2]/div/div/div/div/button[1]")
    WebElement btn_cancel;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/div/div/article[2]/div/div/div/button[1]")
    WebElement btn_remove_portfolio_item_image;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/form/div[2]/div/div/div[1]/button")
    WebElement btn_delete_portfolio_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app-overlay\"]/div/div/article/div[3]/button[2]")
    WebElement btn_confirm_deleting;

    public void fill_in_title(String title_text){ title_field.sendKeys(title_text); }

    public void fill_in_description(String description_text){ description_field.sendKeys(description_text); }

    public void fill_in_url(String url_text){ url_field.sendKeys(url_text); }

    public void upload_portfolio_item_image(String path) throws InterruptedException{
        add_portfolio_image_field.sendKeys(path);
        Thread.sleep(2000);
    }

    public void click_save_portfolio_item_btn() throws InterruptedException{
        ((JavascriptExecutor)driver).executeScript("scroll(0, 700)");
        if(btn_save_portfolio_item.isEnabled()){
            btn_save_portfolio_item.click();
        } else {
            Thread.sleep(3000);
            btn_save_portfolio_item.click();
        }
    }

    public void click_cancel_btn(){
        ((JavascriptExecutor)driver).executeScript("scroll(0, 700)");
        btn_cancel.click();
    }

    public void remove_text_fom_title(){
        title_field.clear();
    }

    public void remove_text_fom_description(){
        description_field.clear();
    }

    public void remove_text_fom_url(){
        url_field.clear();
    }

    public void remove_portfolio_item_image_if_present(){ // need to be modified
           try {
               do {
                   btn_remove_portfolio_item_image.click();
               } while (btn_remove_portfolio_item_image.isDisplayed());
           }catch (org.openqa.selenium.NoSuchElementException e){
               System.out.println("All images are removed");
           }


    }

    public void click_delete_btn(){ btn_delete_portfolio_item.click(); }

    public void click_delete_confirmation_btn(){ btn_confirm_deleting.click();}










}
