package content_creator_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ViewAsVisitorPage {

    WebDriver driver;

    public ViewAsVisitorPage(WebDriver driver){

        this.driver = driver;

    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div/div/button")
    WebElement btn_back;

    public void click_back_btn(){ btn_back.click(); }








}
