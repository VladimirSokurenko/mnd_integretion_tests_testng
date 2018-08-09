package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentsPage {

    WebDriver driver;

    public AssignmentsPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/h1")
    WebElement assignments_section_heading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mnd-c-tags-select-serviceIds\"]")
    WebElement services_selector;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/ul/li[1]/button")
    WebElement pr_content_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mnd-c-tags-select-languageIds\"]")
    WebElement languages_selector;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/ul/li[1]/button")
    WebElement swedish_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/ul/li[6]/button")
    WebElement finish_item;

    public void verify_heading_text(String heading_text){
        Assert.assertEquals(assignments_section_heading.getText(), heading_text);
    }

    public void click_on_services_selector(){
        services_selector.click();
    }

    public void verify_pr_content_present(String text){ Assert.assertEquals(pr_content_item.getText(), text); }

    public void click_on_languages_selector(){ languages_selector.click(); }

    public void verify_main_languages(String language1, String language2){
        Assert.assertEquals(swedish_item.getText(),language1);
        Assert.assertEquals(finish_item.getText(), language2);
    }







}
