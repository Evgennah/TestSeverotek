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

    void enterUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);

    }

    void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);

    }

    void  clickSubmit() {
        driver.findElement(submitButton).click();

    }

    void login(String username, String password) {
        this.enterUserName(username);
        this.enterPassword(password);
        this.clickSubmit();
    }

    boolean atPage() {
        return driver.getTitle().equals("");
    }
}
