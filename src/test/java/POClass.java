import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class POClass {
    private WebDriverWait wait;
    private WebDriver driver;

    private String adress = "https://mail.ru";
    private String name = "firstsecond.name";
    private String password = "FirstSecond";
    private String topicMessage = "Topic message";
    private String loginButton = "//button[@data-testid='enter-mail-primary']";
    private String iframe = "//iframe[@class='ag-popup__frame__layout__iframe']";
    private String inputName = "//input[@name='username']";
    private String buttonPassword = "//span[text()='Ввести пароль']";
    private String inputPassword = "//input[@name='password']";
    private String loginButton1 = "//span[text()='Войти']";
    private String writeMessage = "//span[text()='Написать письмо']";
    private String email = "//span[@class='ph-project__user-name svelte-1hiqrvn']";
    private String inputEmailAdress = "//input[@class='container--H9L5q size_s_compressed--2c-eV'][1]";
    private String inputTopicMessage = "//input[@name='Subject']";
    private String messageField = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[2]";
    private String sendMessage = "//span[text()='Отправить']";

    public POClass(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public  void enter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginButton)));
        driver.findElement(By.xpath(loginButton)).click();
    }

    public void login(String login, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputName)));
        driver.findElement(By.xpath(inputName)).sendKeys(login);
        driver.findElement(By.xpath(buttonPassword)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPassword)));
        driver.findElement(By.xpath(inputPassword)).sendKeys(pass);
        driver.findElement(By.xpath(loginButton1)).click();
    }

    public void page(){
        driver.get(adress);
        driver.manage().window().maximize();
    }

    public void switchto() throws InterruptedException {
        Thread.sleep(5000);
        WebElement frame = driver.findElement(By.xpath(iframe));
        driver.switchTo().frame(frame);
    }

    public void switchback() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
    }

    public void WriteMessage(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(writeMessage)));
        driver.findElement(By.xpath(writeMessage)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputEmailAdress)));
        String element = driver.findElement(By.xpath(email)).getText();
        driver.findElement(By.xpath(inputEmailAdress)).sendKeys(element);
        driver.findElement(By.xpath(inputTopicMessage)).sendKeys(topicMessage);
        driver.findElement(By.xpath(messageField)).sendKeys(message);
        driver.findElement(By.xpath(sendMessage)).click();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}