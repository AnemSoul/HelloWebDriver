package starts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

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

        Thread.sleep(4000);
        driver.quit();

    }
}
