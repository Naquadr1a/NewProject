import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

//Проверка отображения кнопки Skype
public class Test2 {
    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Method method = new Method(driver, wait);
        try {
            method.openPage("https://andersenlab.com");
            try{
                driver.findElement(By.xpath("//a[@href='https://join.skype.com/aM8R4P4dNJdy']"));
            } catch (NoSuchElementException e){
                e.printStackTrace();
            }
            method.asserts("//a[@href='https://join.skype.com/aM8R4P4dNJdy']", "skype");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000L);
            driver.quit();
        }
    }
    @AfterTest
    public void log() {
        Logger logger = Logger.getLogger(Test1.class.getName());
        logger.info("Done!");
    }
}
