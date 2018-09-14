package web_driver_setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class WebDriverSetup {

    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("chromedriver", "/home/alexander/IdeaProjects/mnd_integration_tests");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    public void go_to_the_site(String instance){
        if(instance == "staging"){
            driver.get("https://www.mnd-staging-sloboda.com/user/signin");
        } else if (instance == "production") {
            driver.get("https://www.mynewsdesk.com/user/signin");
        } else {
            System.out.println("incorrect instance chosen");
        }
    }

    public String get_random_text(String text){
        int random = (int )(Math.random() * 50 + 1);
        String random_text = text + random;
        return random_text;
    }


    @AfterTest
    public void quit(){
        driver.quit();
    }



}
