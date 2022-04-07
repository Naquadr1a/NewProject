import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Method {
    private WebDriver driver;

    public Method(WebDriver driver) {
        this.driver = driver;
    }

    public void asserts(String expected, String actual) {
        String element = driver.findElement(By.xpath(expected)).getText();
        Assert.assertEquals(element, actual);
    }

}
