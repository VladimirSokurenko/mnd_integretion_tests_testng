package press_officer_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateJobAssignmentPage {

    WebDriver driver;

    public CreateJobAssignmentPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[1]/div/div[2]/div/input")
    WebElement title_field;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[2]/div/div[2]/div/textarea")
    WebElement description_field;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-select-4--value\"]/div[1]")
    WebElement services_selector;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-select-4--option-0\"]")
    WebElement pr_content_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[3]/div/div[2]/div/div[1]/span[3]")
    WebElement btn_services_selector_arrow;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[4]/div/div[2]/div/div[1]/span[3]")
    WebElement btn_language_selector_arrow;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-select-5--value\"]/div[1]")
    WebElement language_selector;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-select-5--option-0\"]")
    WebElement swedish_item;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mnd-c-select-projectScope\"]")
    WebElement project_scope_selector;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[5]/div[1]/div[1]/div/div[2]/div/ul/li[5]/button")
    WebElement other_project_scope;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[5]/div[1]/div[2]/div/div[2]/div/input")
    WebElement other_scope_field;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[5]/div[2]/div/div/div/div[2]/div/div/div/input")
    WebElement deadline_field;

    public void fill_in_assignment_title(String title_text){ title_field.sendKeys(title_text); }

    public void fill_in_assignment_description(String description_text){ description_field.sendKeys(description_text); }

    public void click_on_services_selector(){ services_selector.click(); }

    public void click_on_languages_selector(){ language_selector.click(); }

    public void select_pr_content_item(){
        click_on_services_selector();
        pr_content_item.click();
        btn_services_selector_arrow.click();
    }

    public void select_swedish_item(){
        click_on_languages_selector();
        swedish_item.click();
        btn_language_selector_arrow.click();
    }

    public void click_on_project_scope_selector(){ project_scope_selector.click(); }

    public void select_other_scope(){
        click_on_project_scope_selector();
        other_project_scope.click();
    }

    public void fill_in_other_scope_filed(String other_scope_text){ other_scope_field.sendKeys(other_scope_text); }

    public void fill_in_deadline_date(String date){ description_field.sendKeys(date); }











}
