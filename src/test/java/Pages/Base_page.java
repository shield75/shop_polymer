package Pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_page extends Driver {
    public void scrollIntoElement_andClick(WebElement element, WebDriver driver) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        element.click();
        Thread.sleep(1000);
    }
    public void input(WebDriver driver, WebElement element, String text) throws InterruptedException {
        element.sendKeys(text);
        Thread.sleep(500);
    }
    public void selectOptions(WebDriver driver, WebElement element1, WebElement element2) throws InterruptedException {
        element1.click();
        Thread.sleep(700);
        element2.click();
    }
}

