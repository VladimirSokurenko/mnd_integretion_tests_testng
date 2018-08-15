package press_officer_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewsRoomListPage {

    WebDriver driver;

    public NewsRoomListPage(WebDriver driver){ this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[@id=\"wrapper\"]/div/div[2]/div/section/table/tbody/tr[1]/td/a")
    WebElement first_newsroom_link;

    public void click_on_first_newsroom(){ first_newsroom_link.click(); }

}
