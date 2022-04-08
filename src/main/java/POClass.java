import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class POClass extends BasePage {

    @FindBy(xpath ="//button[@data-testid='enter-mail-primary']")
    WebElement loginButton;
    @FindBy(xpath ="//iframe[@class='ag-popup__frame__layout__iframe']")
    WebElement iframe;
    @FindBy(xpath ="//input[@name='username']")
    WebElement inputName;
    @FindBy(xpath ="//span[text()='Ввести пароль']")
    WebElement buttonPassword;
    @FindBy(xpath ="//input[@name='password']")
    WebElement inputPassword;
    @FindBy(xpath ="//span[text()='Войти']")
    WebElement loginButton1;
    @FindBy(xpath ="//span[text()='Написать письмо']")
    WebElement writeMessage;
    @FindBy(xpath ="//span[@class='ph-project__user-name svelte-1hiqrvn']")
    WebElement email;
    @FindBy(xpath ="//input[@class='container--H9L5q size_s_compressed--2c-eV'][1]")
    WebElement inputEmailAdress;
    @FindBy(xpath ="//input[@name='Subject']")
    WebElement inputTopicMessage;
    @FindBy(xpath ="//div[@role='textbox']/div")
    WebElement messageField;
    @FindBy(xpath ="//span[text()='Отправить']")
    WebElement sendMessage;

    public POClass(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void enter () throws Exception{
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }
    public void login (String login, String pass) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(login);
        buttonPassword.click();
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys(pass);
        loginButton1.click();
    }
    public void switchto () throws Exception{
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
    }
    public void switchback () {
        driver.switchTo().defaultContent();
    }
    public void write (String topicMessage, String message) throws Exception{
        wait.until(ExpectedConditions.visibilityOf(writeMessage));
        writeMessage.click();
        String element = email.getText();
        wait.until(ExpectedConditions.visibilityOf(inputEmailAdress));
        inputEmailAdress.sendKeys(element);
        inputTopicMessage.sendKeys(topicMessage);
        messageField.sendKeys(message);
        sendMessage.click();
    }
}