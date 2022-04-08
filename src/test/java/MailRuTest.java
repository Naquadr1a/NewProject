import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
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
    @Description("Нажимаем кнопку 'Войти'")
    public void enterButton() throws Exception {
        poClass.enter();
    }
    @Test
    @Description("Заходим в iframе, и вводим данные")
    public void iframe() throws Exception {
        poClass.switchto();
        poClass.login(data.getLogin(), data.getPass());
        poClass.switchback();
    }
    @Test
    @Description("Пишем сообщение")
    public void message() throws Exception {
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
    @AfterSuite
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @AfterClass
    //Получаем логи из браузера
    public void logs(){
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if(allLogRows.size() > 0) {
            log.info("Логи браузера");
            log.info(Arrays.toString(allLogRows.toArray()));
        }
    }
}