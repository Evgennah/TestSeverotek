import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListOfEntriesPage {
    private WebDriver driver;

    public ListOfEntriesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By newEntryCheckbox = By.xpath("//*[@id=\"result_list\"]/tbody/tr[1]/td[1]/input");
    private By  entryDropDownListButton= By.xpath("//*[@id=\"changelist-form\"]/div[2]/label/select");
    private By  entryDeletionButton = By.xpath("//*[@id=\"changelist-form\"]/div[2]/label/select/option[2]");
    private By performButton = By.xpath("//*[@id=\"changelist-form\"]/div[2]/button");
    private By confirmEntryDeletionButton = By.xpath("//*[@id=\"content\"]/form/div/input[4]");

    void checkNewEntryCheckbox() {
        driver.findElement(newEntryCheckbox).click();
    }
    void chooseEntryDropDownList() {
        driver.findElement(entryDropDownListButton).click();
    }
    void chooseEntryDeletion() {
        driver.findElement(entryDeletionButton).click();
    }
    void performEntryDeletion() {
        driver.findElement(performButton).click();
    }
    void confirmEntryDeletion() {
        driver.findElement(confirmEntryDeletionButton).click();
    }
    void deleteNewEntry() {
        this.checkNewEntryCheckbox();
        this.chooseEntryDropDownList();
        this.chooseEntryDeletion();
        this.performEntryDeletion();
        this.confirmEntryDeletion();
    }
}
