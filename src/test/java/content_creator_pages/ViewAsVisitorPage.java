package content_creator_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewAsVisitorPage {

    WebDriver driver;

    public ViewAsVisitorPage(WebDriver driver){

        this.driver = driver;

    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div/div/button")
    WebElement btn_back;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[2]/div[1]/a/div/div")
    WebElement portfolio_item_card;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[3]/ul/li[2]/a")
    WebElement pagination_one_btn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[3]/ul/li[3]/a")
    WebElement pagination_two_btn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[2]/div[1]/a/div/div/a/h3")
    WebElement first_portfolio_item_heading;


    public void click_back_btn(){ btn_back.click(); }

    public void click_on_portfolio_item_card(){ portfolio_item_card.click(); }

    public void click_on_pagination_button_one(){
        pagination_one_btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.elementToBeClickable(portfolio_item_card));
    }

    public void click_on_pagination_button_two(){
        pagination_two_btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.elementToBeClickable(portfolio_item_card));
    }



    public void compare_headings_of_different_second_page() {
        String first_heading = first_portfolio_item_heading.getText();
        System.out.println(first_heading);
        click_on_pagination_button_two();
        String second_heading = first_portfolio_item_heading.getText();
        System.out.println(second_heading);
        Assert.assertNotEquals(first_heading,second_heading);
    }

    public void compare_headings_of_different_first_page() {
        String first_heading = first_portfolio_item_heading.getText();
        System.out.println(first_heading);
        click_on_pagination_button_one();
        String second_heading = first_portfolio_item_heading.getText();
        System.out.println(second_heading);
        Assert.assertNotEquals(first_heading,second_heading);
    }










}
