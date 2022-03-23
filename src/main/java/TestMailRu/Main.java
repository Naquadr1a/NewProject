package TestMailRu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://mail.ru");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='resplash-btn resplash-btn_primary resplash-btn_big svelte-y47oj9']")));

        driver.findElement(By.xpath("//button[@class='resplash-btn resplash-btn_primary resplash-btn_big svelte-y47oj9']")).click();

        Thread.sleep(3000);

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"));

        driver.switchTo().frame(frameElement);;

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@placeholder='Имя аккаунта']")));

        driver.findElement(By.xpath("//input[@placeholder='Имя аккаунта']")).sendKeys("firstsecond.name@mail.ru", Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Пароль']")));

        driver.findElement(By.xpath("//input[@placeholder='Пароль']")).sendKeys("FirstSecond", Keys.ENTER);

        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ph-project__user-name svelte-1hiqrvn']")));

        String element1 = driver.findElement(By.xpath("//span[@class='ph-project__user-name svelte-1hiqrvn']")).getText();

        System.out.println(element1);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='Написать письмо']")));

        driver.findElement(By.xpath("//span[text()='Написать письмо']")).click();

        Thread.sleep(3000);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@class='container--H9L5q size_s_compressed--2c-eV'][1]")));

        driver.findElement(By.xpath("//input[@class='container--H9L5q size_s_compressed--2c-eV'][1]")).sendKeys(element1);

        driver.findElement(By.xpath("//input[@name='Subject']")).sendKeys("Письмо");

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[2]")).sendKeys("Привет");

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='button2__txt'][1]")));

        driver.findElement(By.xpath("//span[@class='button2__txt'][1]")).click();

        Thread.sleep(3000);

        System.out.println("Done!");

        driver.quit();
    }
}
