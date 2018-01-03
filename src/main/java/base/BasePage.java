package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(String url) {
        driver.navigate().to(url);
    }

    protected WebElement findElement(By by) {

        WebElement el;
        try {
            el = driver.findElement(by);
            scrollToElement(el);
        } catch (Exception e) {
            el = null;
        }
        return el;
    }

    protected void scrollToElement(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
    }

    protected void clickElement(By by) {
        findElement(by).click();
    }

    protected void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    protected String getText(By by) {
        return findElement(by).getText();
    }

}
