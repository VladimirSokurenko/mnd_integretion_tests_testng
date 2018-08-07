package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AssignmentsPage {

    WebDriver driver;

    public AssignmentsPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/h1")
    WebElement assignments_section_heading;

    public void verify_heading_text(String heading_text){
        Assert.assertEquals(assignments_section_heading.getText(), heading_text);
    }
}
