import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Logger;

public class MailRuTest {
        private WebDriver driver;
        private String adress = "https://mail.ru";
        private WebDriverWait wait;
        private Logger log;
        private Data data;
        POClass poClass;
        String message = "Message";
        String topicMessage = "Topic message";

        @BeforeSuite
        public void beforeSuite(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            poClass = new POClass(driver, wait);
            log = Logger.getLogger(MailRuTest.class.getName());
            data = new Data();
            PageFactory.initElements(driver, poClass);
        }
        @BeforeTest
        public void beforeTest(){
            driver.manage().window().maximize();
        }
        @Test
        public void test() throws Exception {
            poClass.enter();
            poClass.switchto();
            poClass.login(data.getLogin(), data.getPass());
            poClass.switchback();
            poClass.write(topicMessage, message);
        }
        @BeforeClass
        public void beforeClass(){
            driver.get(adress);
        }
        @AfterMethod
        public  void log(){
            log.info("Done!");
        }
        @AfterClass
        public void close() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }

    }

