import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.logging.Logger;

// Проверка адресса электронной почты

public class Test {
    private WebDriver driver;
    private String adress = "https://andersenlab.com";
    Method method;

    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        method = new Method(driver);
    }

    @BeforeTest
    public void beforeTest(){
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void beforeClass(){
        driver.get(adress);
    }

    //Проверка адресса электронной почты
    @org.testng.annotations.Test
    public void test1() {
        method.asserts("//span[@class='contacts-module--mail--CKUwL']", "vn@andersenlab.com");
    }

    //Проверка кнопки skype
    @org.testng.annotations.Test
    public void test2(){
        method.asserts("//a[@href='https://join.skype.com/aM8R4P4dNJdy']", "skype");
    }

    @AfterMethod
    public void log() {
        Logger logger = Logger.getLogger(Test.class.getName());
        logger.info("Done!");
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }
}
