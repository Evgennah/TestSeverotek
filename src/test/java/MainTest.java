import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        entryPage = new EntryPage(driver);
        blogPage = new BlogPage(driver);
        listOfEntriesPage = new ListOfEntriesPage(driver);

        loginPage.open();
    }

    @Test
    public void bigPositiveTest() {

        loginPage.login("selenium", "super_password");

        mainPage.headingVerifying();
        mainPage.clickAddEntry();

        entryPage.checkForAddEntryHeading();
        entryPage.makingNewEntry("Title", "Slug", "Textmarkdown", "Text");
        entryPage.switchToBlogPage();

        blogPage.newEntryTitleVerifying();
        blogPage.clickEntryChangeButton();

        listOfEntriesPage.deleteNewEntry();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}

