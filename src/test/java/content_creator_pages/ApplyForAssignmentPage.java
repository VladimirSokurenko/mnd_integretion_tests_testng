package content_creator_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ApplyForAssignmentPage {

    WebDriver driver;

    public ApplyForAssignmentPage(WebDriver driver){ this.driver = driver;}

    @FindBy(how = How.NAME, using = "subject")
    WebElement subject_field;

    @FindBy(how = How.NAME, using = "message")
    WebElement message_field;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/div/div[3]/footer/div/button[2]")
    WebElement btn_contact;

    public void fill_in_subject_field(String text){ subject_field.sendKeys(text); }

    public void fill_in_message_field(String text){ message_field.sendKeys(text); }

    public void click_on_contact_button(){ btn_contact.click(); }




}
