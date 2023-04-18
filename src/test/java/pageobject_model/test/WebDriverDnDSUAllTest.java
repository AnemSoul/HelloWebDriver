package pageobject_model.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.DnDSUHomePage;

import java.time.Duration;
import java.util.List;

public class WebDriverDnDSUAllTest {
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test (description = "Just first test, JIRA binding can be here")
    public void commonSearchTermTestResultsAreNotEmpty() {
        int expectedSearchResultNumber = new DnDSUHomePage(driver)
                .openPage()
                .searchForTerms("Монах")
                .countResultsNumberWithSearchTerm();
        Assert.assertTrue(expectedSearchResultNumber > 0, "Search results are empty!");
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

//    private static WebElementwaitForElementLocatedBy (WebDriver driver, By by) {
//        return new WebDriverWait(driver, Duration.ofSeconds(10)
//                .until(ExpectedConditions.presenceOfElementLocated(by));
//    }
}
