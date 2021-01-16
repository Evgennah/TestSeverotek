import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage {

    private WebDriver driver;

    public BlogPage(WebDriver driver) {

        this.driver = driver;
    }

    private By newEntry = By.xpath("//*[@id=\"module_2\"]/div/ul/li[1]/a");
    private By entriesChangeButton = By.xpath("//*[@id=\"module_1\"]/div/ul/li[1]/ul/li[2]/a");

    public String getNewEntryName() {
        return driver.findElement(newEntry).getText();
    }

    void clickEntryChangeButton() {
        driver.findElement(entriesChangeButton).click();
    }




}
