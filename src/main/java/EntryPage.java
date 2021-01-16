import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ThreadLocalRandom;

public class EntryPage {

    private WebDriver driver;

    public EntryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleInputField = By.xpath("//*[@id='id_title']");
    private By slugInputField = By.xpath("//*[@id='id_slug']");
    private By textMarkdownInputField = By.xpath("//*[@id='id_text_markdown']");
    private By textInputField = By.xpath("//*[@id='id_text']");
    private By entrySubmitButton = By.xpath("//*[@id='entry_form']/div/div/input[1]");
    private By blogButton = By.xpath("//*[@id=\"container\"]/div[2]/a[2]");
    private By addEntryHeading = By.xpath("//*[text()='Добавить entry']");

    public static int randomNumber = ThreadLocalRandom.current().nextInt(100000000, 1000000000 + 1);

    public void checkForAddEntryHeading() { //проверка на наличие заголовка с текстом "Добавить entry"
        if (driver.findElements(addEntryHeading).size() > 0 && driver.findElement(addEntryHeading).getTagName().contains("h")) {
            System.out.println("Heading 'Добавить entry' is on the Entry Page");
        } else System.out.println("Heading 'Добавить entry' is not on the Entry Page");
    }

    private void inputTitle(String title) {
        driver.findElement(titleInputField).sendKeys(title + randomNumber);
    }

    private void inputSlug(String slug) {
        driver.findElement(slugInputField).sendKeys(slug + randomNumber);
    }

    private void inputTextMarkdown(String textmarkdown) {
        driver.findElement(textMarkdownInputField).sendKeys(textmarkdown + randomNumber);
    }

    private void inputText(String text) {
        driver.findElement(textInputField).sendKeys(text + randomNumber);
    }

    private void clickSubmitEntry() {
        driver.findElement(entrySubmitButton).click();
    }

    public void makingNewEntry(String title, String slug, String textmarkdown, String text) {
        this.inputTitle(title);
        this.inputSlug(slug);
        this.inputTextMarkdown(textmarkdown);
        this.inputText(text);
        this.clickSubmitEntry();
    }

    public void switchToBlogPage() {
        driver.findElement(blogButton).click();
    }

}

