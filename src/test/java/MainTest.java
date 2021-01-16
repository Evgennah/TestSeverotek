import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private EntryPage entryPage;
    private BlogPage blogPage;
    private ListOfEntriesPage listOfEntriesPage;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chromedriver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://igorakintev.ru/admin/");
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        entryPage = new EntryPage(driver);
        blogPage = new BlogPage(driver);
        listOfEntriesPage = new ListOfEntriesPage(driver);


    }

    @Test
    public void bigPositiveTest() {
        loginPage.login("selenium", "super_password");
        Assert.assertEquals(mainPage.getMainPageHeading(), "Панель управления", "There is no heading 'Панель управления' on the page");

        mainPage.clickAddEntry();

        entryPage.checkForAddEntryHeading();

        entryPage.makingNewEntry("Title", "Slug", "Textmarkdown", "Text");

        entryPage.switchToBlogPage();

        Assert.assertEquals(blogPage.getNewEntryName(), "Entry Title" + entryPage.randomNumber, "There is no new entry on the page");

        blogPage.clickEntryChangeButton();

        listOfEntriesPage.deleteNewEntry();


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
