import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameField = By.xpath("//*[@id=\"id_username\"]");
    private By passwordField = By.xpath("//*[@id=\"id_password\"]");
    private By submitButton = By.xpath("//*[@id=\"login-form\"]/div[3]/input");

    public void open() {
        driver.get("https://igorakintev.ru/admin/");
    }

    private void enterUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
    }

    private void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void login(String username, String password) {
        this.enterUserName(username);
        this.enterPassword(password);
        this.clickSubmit();
    }

}

