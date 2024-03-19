package Pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class Home extends Driver {
    public String base_url = "https://shop.polymer-project.org/";
    public String cssSelectorForHost1 = "shop-app[page='home']";
    public String cssSelectorForHost2 = ".iron-selected";
    public By shadow_01 = By.cssSelector(cssSelectorForHost1);
    public By shadow_02 = By.cssSelector(cssSelectorForHost2);
    public By shopButton = By.cssSelector("a[aria-label=\"Men's Outerwear Shop Now\"]");
    public void shadow_element_click(WebDriver driver) throws InterruptedException {
        SearchContext shadow0 = getLocalDriver().findElement(shadow_01).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(shadow_02).getShadowRoot();
        Thread.sleep(1000);
        shadow1.findElement(shopButton).click();
        Thread.sleep(1000);
    }
}
