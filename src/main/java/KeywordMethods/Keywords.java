package KeywordMethods;

import Const.FilePath;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keywords {
    WebDriver driver;
    FilePath filePath;
    public void openBrowser(String url) throws InterruptedException {
        filePath = new FilePath();
        System.setProperty(filePath.key,filePath.value );
        driver=new ChromeDriver();
        driver.get(url);
        Thread.sleep(2000);
    }

    public void enterText(String locatorType, String locatorValue, String data) throws InterruptedException {
        WebElement element = locateElement(locatorType, locatorValue);
        element.sendKeys(data);
        Thread.sleep(2000);
    }

    public void click(String locatorType, String locatorValue) throws InterruptedException {
        WebElement element = locateElement(locatorType, locatorValue);
        element.click();
        Thread.sleep(6000);
    }

    public WebElement locateElement(String locatorType, String locatorValue) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return driver.findElement(By.id(locatorValue));
            case "name":
                return driver.findElement(By.name(locatorValue));
            case "xpath":
                return driver.findElement(By.xpath(locatorValue));
            case "css":
                return driver.findElement(By.cssSelector(locatorValue));
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    public void closeBrowser() {
        driver.quit();
    }
}
