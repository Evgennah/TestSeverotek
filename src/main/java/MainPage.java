import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addEntryButton = By.xpath("//*[@id=\"module_2\"]/div/ul[1]/li[1]/ul/li[1]/a");
    private By heading = By.xpath("//*[@id=\"content\"]/h1");

    public String getMainPageHeading() {
        return driver.findElement(heading).getText();
    }

    void clickAddEntry() {
        driver.findElement(addEntryButton).click();
    }


}
