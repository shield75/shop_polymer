package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Outwear extends Base_page {
    public By cssSelectorForHost1 = By.cssSelector("shop-app[page='list']");
    public By cssSelectorForHost2 = By.cssSelector("shop-list[name='list']");
    public By cssSelectorForHost4 = By.cssSelector("shop-image");
    public By imageClick = By.cssSelector("#img");
    public By moItem = By.cssSelector(" ul:nth-child(6) > li:nth-child(16) > a:nth-child(1) > shop-list-item:nth-child(1)");
    public By loItem = By.cssSelector(" ul:nth-child(6) > li:nth-child(5) > a:nth-child(1) > shop-list-item:nth-child(1)");
    public void shadow_element_click(WebDriver driver, By item) throws InterruptedException{
        SearchContext shadow0 = driver.findElement(cssSelectorForHost1).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(cssSelectorForHost2).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow2 = shadow1.findElement(item).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow3 = shadow2.findElement(cssSelectorForHost4).getShadowRoot();
        Thread.sleep(1000);
        WebElement select = shadow3.findElement(imageClick);
        scrollIntoElement_andClick(select, getLocalDriver());
    }
}






