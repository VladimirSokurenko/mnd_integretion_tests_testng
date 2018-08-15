package content_creator_pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ViewAssignmentPage {

    WebDriver driver;

    public ViewAssignmentPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div/div/button")
    WebElement btn_apply_for_assignment;

    public void scroll_to_apply_for_assignment_btn(){ ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btn_apply_for_assignment); }

    public void click_on_apply_for_assignment_btn(){ btn_apply_for_assignment.click(); }
}
