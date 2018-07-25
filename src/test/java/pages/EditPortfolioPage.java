package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPortfolioPage {

    WebDriver driver;

    public EditPortfolioPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(how = How.NAME, using = "avatarUrl")
    WebElement input_avatar_image;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[1]/div/div/div[2]/div/div/div/button")
    WebElement btn_remove_avatar;

    @FindBy(how = How.NAME, using = "coverImageUrl")
    WebElement input_cover_inage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[2]/div/div/div[2]/div/div/div/button")
    WebElement btn_remove_cover_iamge;

    @FindBy(how = How.NAME, using = "name")
    WebElement input_name_text;

    @FindBy(how = How.NAME, using = "title")
    WebElement input_title_text;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[4]/div/div/div[1]/div/div/div[2]/div/label[1]")
    WebElement btn_available_for_job_yes;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[4]/div/div/div[1]/div/div/div[2]/div/label[2]")
    WebElement btn_available_for_job_no;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/button[1]")
    WebElement get_digest_yes;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/button[2]")
    WebElement get_digest_no;

    @FindBy(how = How.NAME, using = "bio")
    WebElement input_about_text;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/footer/div/button")
    WebElement btn_save_portfolio;




    public void upload_avatar_image(String path) throws InterruptedException{
        input_avatar_image.sendKeys(path);
        //Thread.sleep(5000);

    }

    public void remove_avatar_image(){
        btn_remove_avatar.click();
    }

    public void upload_cover_image(String path) throws InterruptedException{
        input_cover_inage.sendKeys(path);
        //Thread.sleep(5000);
    }

    public void remove_cover_image(){
        btn_remove_cover_iamge.click();
    }

    public void agile_cover_image_upload(String path) throws InterruptedException {
        if(is_remove_cover_btn_present()){
            remove_cover_image();
            upload_cover_image(path);
        } else {
            upload_cover_image(path);
        }
    }

    public void agile_avatar_upload(String path) throws InterruptedException{
        if(is_remove_avatar_btn_present()){
            remove_avatar_image();
            upload_avatar_image(path);
        } else {
            upload_avatar_image(path);
        }
    }

    public boolean is_remove_avatar_btn_present() {
        try {
            btn_remove_avatar.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    } //hack

    public boolean is_remove_cover_btn_present() {
        try {
            btn_remove_cover_iamge.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }  //hack

    public void fill_in_name_field(String name){

        input_name_text.clear();
        input_name_text.sendKeys(name);

    }

    public void fill_in_title_filed(String title){

        input_title_text.clear();
        input_title_text.sendKeys(title);

    }

    public void fill_in_about_field(String about){

        input_about_text.clear();
        input_about_text.sendKeys(about);

    }

    public void click_available_for_job_yes(){
        if(btn_available_for_job_yes.isEnabled()){
            btn_available_for_job_yes.click();
        } else {
            System.out.println("Your profile is already available");
        }
    }

    public void click_available_for_job_no(){
        if(btn_available_for_job_no.isEnabled()){
            btn_available_for_job_no.click();
        } else {
            System.out.println("You profile is already unavailable");
        }
    }

    public void click_get_digest_yes(){

        if(get_digest_yes.isEnabled()){
            get_digest_yes.click();
        } else {
            System.out.println("You are already have subscribed");
        }

    }

    public void click_get_digest_no(){
        if(get_digest_no.isEnabled()){
            get_digest_no.click();
        } else {
            System.out.println("You are already unsubscribe");
        }
    }

    public void click_save_portfolio_btn() throws InterruptedException{

        if(btn_save_portfolio.isEnabled()){
            btn_save_portfolio.click();
        } else {
            Thread.sleep(5000);
            btn_save_portfolio.click();
        }

    }






}
