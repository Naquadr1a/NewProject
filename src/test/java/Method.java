import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Method {
    private WebDriverWait wait;
    private WebDriver driver;

    public Method(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openPage(String string) {
        this.driver.get(string);
        this.driver.manage().window().maximize();
    }

    public void asserts(String expected, String actual) {
        String element = driver.findElement(By.xpath(expected)).getText();
        Assert.assertEquals(element, actual);
    }
}
