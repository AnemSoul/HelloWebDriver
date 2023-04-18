package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class DnDSUSearchResult {
    private final String splitRegex = "\\s";
    private WebDriver driver;
    private String searchTerm;
    private String defaultLocator = "//input[@class='btn btn-green'%s]";
    private String containsPart = " and contains(.,'%s')";
    @FindBy(xpath = "//input[@class='btn btn-green']")
    private List<WebElement> generalSearchResults;

    public DnDSUSearchResult (WebDriver driver, String searchTerm) {
        this.searchTerm = searchTerm;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int countGeneralNumberOfSearchResults() {
        System.out.println("Search results number for requested term: " + generalSearchResults.size());
        return generalSearchResults.size();
    }

    public int countResultsNumberWithSearchTerm() {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath(buildLocatorForSearch()));
        System.out.println("Search results number for requested " + resultsNumberWithSearchTerm);
        return resultsNumberWithSearchTerm.size();
    }

    private String buildLocatorForSearch() {
        String partWithSearchTerm = "";
        String[] terms = searchTerm.split(splitRegex);
        for (String term : terms) {
            partWithSearchTerm += String.format(containsPart, term);
        }
        String locatorForSearch = String.format(defaultLocator, partWithSearchTerm);
        System.out.println("DEBUG: Final locator with search terms: " + locatorForSearch);
        return locatorForSearch;
    }
}
