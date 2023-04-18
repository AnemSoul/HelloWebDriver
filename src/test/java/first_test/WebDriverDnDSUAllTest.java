package first_test;

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

        driver.get("https://dnd.su/class/");

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//input[@type='text'][@name='search']")));

        WebElement searchInput = driver
                .findElement(By.xpath("//input[@type='text'][@name='search']"));
        searchInput.sendKeys("Монах");

        List<WebElement> searchButton = driver
                .findElements(By.xpath("//input[@class='btn btn-green']"));

        searchButton.get(0).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//input[@class='btn btn-green']")));
        List<WebElement> searchResults = driver.findElements((By.xpath("//input[@class='btn btn-green']")));
        System.out.println("Search results number for requested term: " + searchResults.size());

        Assert.assertTrue(searchResults.size() > 0, "Search results are empty!");

    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
