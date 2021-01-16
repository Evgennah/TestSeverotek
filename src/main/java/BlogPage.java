import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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

    public void newEntryTitleVerifying() {
        Assert.assertEquals(this.getNewEntryName(), "Entry Title" + EntryPage.randomNumber, "There is no new entry on the page");
    }

    public void clickEntryChangeButton() {
        driver.findElement(entriesChangeButton).click();
    }

}

