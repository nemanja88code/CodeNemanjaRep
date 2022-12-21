package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void setup (){
        System.setProperty("webdriver.chromedriver", "C:\\Users\\QA37\\Desktop\\TestProject\\TestProject\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @After
    public void teardown(){
        driver.quit();
        }
}