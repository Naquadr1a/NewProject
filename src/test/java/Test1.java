import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.logging.Logger;

// Проверка адресса электронной почты

public class Test1 {
    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Method method = new Method(driver, wait);
        try{
            method.openPage("https://andersenlab.com");
            method.asserts("//span[@class='contacts-module--mail--CKUwL']", "vn@andersenlab.com");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(5000L);
            driver.quit();
        }
    }
    @AfterTest
    public void log() {
        Logger logger = Logger.getLogger(Test1.class.getName());
        logger.info("Done!");
    }
}
