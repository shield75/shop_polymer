package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Product extends Base_page {
    public By cssSelectorForHost1 = By.cssSelector("shop-app[page='detail']");
    public By cssSelectorForHost2 = By.cssSelector("shop-detail[name='detail']");
    public By selectSize = By.cssSelector("#sizeSelect");
    public By size = By.cssSelector("option[value='XL']");
    public By quantity = By.cssSelector("#quantitySelect");
    public By q_number = By.cssSelector("option[value='5']");
    public By add_to_Cart = By.cssSelector("button[aria-label='Add this item to cart']");
    public By ladies_outwear = By.cssSelector("a[href='/list/ladies_outerwear']");
    public By cartIcon = By.cssSelector("#icon");
    public int cartItem = 0;
    List<SearchContext> shadows=new ArrayList<SearchContext>();
    public SearchContext selectSize_and_Quantity(WebDriver driver) throws InterruptedException{
        SearchContext shadow0 = driver.findElement(cssSelectorForHost1).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(cssSelectorForHost2).getShadowRoot();
        Thread.sleep(1000);
        By cartLocator = By.cssSelector("paper-icon-button[aria-label='Shopping cart: "+cartItem+" items']");
        SearchContext shadow3 = shadow0.findElement(cartLocator).getShadowRoot();
        shadows.add(shadow0);
        shadows.add(shadow1);
        shadows.add(shadow3);
        selectOptions(driver, shadow1.findElement(selectSize),shadow1.findElement(size));
        selectOptions(driver, shadow1.findElement(selectSize),shadow1.findElement(size));
        cartItem = cartItem + Integer.parseInt(shadow1.findElement(q_number).getText());
        Thread.sleep(1000);
        return shadow1;
    }
    public void addToCart(WebDriver driver, SearchContext shadow1) throws InterruptedException {
        shadow1.findElement(add_to_Cart).click();
        Thread.sleep(1000);
    }
    public void goTO_ladiesOutwear() throws InterruptedException {
        shadows.get(0).findElement(ladies_outwear).click();
        Thread.sleep(1000);
    }
    public void goTO_Cart() throws InterruptedException {
        shadows.get(2).findElement(cartIcon).click();
        Thread.sleep(1000);
    }
}



