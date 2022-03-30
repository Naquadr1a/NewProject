import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MailRuTest {

    @Test
    public static void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        POClass poClass = new POClass(driver, wait);
        try {
            poClass.page();
            poClass.enter();
            poClass.switchto();
            poClass.login(poClass.getName(), poClass.getPassword());
            poClass.switchback();
            poClass.WriteMessage("Text");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Done!");
    }
}
