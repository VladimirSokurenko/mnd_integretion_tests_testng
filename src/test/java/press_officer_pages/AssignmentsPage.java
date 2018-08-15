package press_officer_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AssignmentsPage {

    WebDriver driver;

    public AssignmentsPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div[1]/h1")
    WebElement assignments_main_heading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div[2]/div/div/button")
    WebElement btn_create_assignment;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/ul/li[1]/div[2]/div[1]/button[1]")
    WebElement btn_view_job_assignment;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/ul/li[1]/div[2]/div[1]/button[2]")
    WebElement btn_edit_job_assignment;

    public void verify_assignments_heading_displayed(){
        if(assignments_main_heading.isDisplayed()){
            System.out.println("Assignments main heading is displayed");
        } else {
            System.out.println("Assignments main heading is NOT displayed");
        }
    }

    public void verify_create_assignment_btn_is_present(){
        if(btn_create_assignment.isDisplayed()){
            System.out.println("Create assignment button is displayed");
        } else {
            System.out.println("Create assignment button is NOT displayed");
        }
    }

    public void click_on_create_assignment_btn(){ btn_create_assignment.click(); }



}
