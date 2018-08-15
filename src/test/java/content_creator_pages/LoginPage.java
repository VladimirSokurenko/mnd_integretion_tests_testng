package content_creator_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    @FindBy(how = How.ID, using = "username")
    @CacheLookup
    WebElement field_username;



    @FindBy(how = How.ID, using = "password")
    @CacheLookup
    WebElement field_password;

    @FindBy(how = How.ID, using = "login-button")
    @CacheLookup
    WebElement btn_login;

    public void fill_in_username(String username){ field_username.sendKeys(username); }

    public void fill_in_password(String password){ field_password.sendKeys(password); }

    public void click_login_btn(){ btn_login.click(); }

    public void login_as(String username, String password){
        field_username.sendKeys(username);
        field_password.sendKeys(password);
        btn_login.click();
    }


}
