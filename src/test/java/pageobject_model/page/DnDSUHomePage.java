package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starts.CustomConditions;

import java.time.Duration;
import java.util.List;

public class DnDSUHomePage {
    private static final String DNDSU_CLASS_URL = "https://dnd.su/class/";
    private WebDriver driver;
    @FindBy (xpath = "//input[@type='text'][@name='search']")
    private WebElement searchInput;
    @FindBy (xpath = "//input[@class='btn btn-green']")
    private WebElement searchButton;
    public DnDSUHomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DnDSUHomePage openPage() {
        driver.get(DNDSU_CLASS_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public DnDSUSearchResult searchForTerms (String term) {
        searchInput.sendKeys(term);
        searchButton.click();
        return new DnDSUSearchResult(driver, term);
    }
}
