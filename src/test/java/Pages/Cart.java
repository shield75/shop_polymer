package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Cart {
    public By cssSelectorForHost1 = By.cssSelector("shop-app[page='cart']");
    public By cssSelectorForHost2 = By.cssSelector("shop-cart[name='cart']");
    public By cssSelectorForHost3 = By.cssSelector(" div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > shop-cart-item:nth-child(1)");
    public By checkoutButton = By.cssSelector("a[href='/checkout']");
    public By quantity = By.cssSelector("#quantitySelect");
    public void checkout_button (WebDriver driver) throws InterruptedException {
        SearchContext shadow0 = driver.findElement(cssSelectorForHost1).getShadowRoot();
        SearchContext shadow1 = shadow0.findElement(cssSelectorForHost2).getShadowRoot();
        SearchContext shadow2 = shadow1.findElement(cssSelectorForHost3).getShadowRoot();

        /*Select select = new Select(shadow2.findElement(quantity));
        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedValue = selectedOption.getAttribute("value");*/
        shadow1.findElement(checkoutButton).click();
        Thread.sleep(1000);
    }
}







