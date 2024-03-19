package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
public class Checkout extends Base_page{
    public By cssSelectorForHost1 = By.cssSelector("shop-app[page='checkout']");
    public By cssSelectorForHost2 = By.cssSelector("shop-checkout[name='checkout']");
    public By email = By.cssSelector("#accountEmail");
    public By phone = By.cssSelector("#accountPhone");
    public By address = By.cssSelector("#shipAddress");
    public By city = By.cssSelector("#shipCity");
    public By state = By.cssSelector("#shipState");
    public By zip = By.cssSelector("#shipZip");
    public By select = By.cssSelector("#shipCountry");
    public By option = By.cssSelector("div:nth-child(2) > iron-pages:nth-child(1) > " +
            "div:nth-child(1) > iron-form:nth-child(1) > form:nth-child(1) > " +
            "div:nth-child(3) > section:nth-child(1) > div:nth-child(8) > shop-select:nth-child(2) > " +
            "select:nth-child(1) > option:nth-child(2)");
    public By ch_name = By.cssSelector("#ccName");
    public By card_number = By.cssSelector("#ccNumber");
    public By select_month = By.cssSelector("#ccExpMonth");
    public By month_name = By.cssSelector("option[value='10']");
    public By select_year = By.cssSelector("#ccExpYear");
    public By year = By.cssSelector("option[value='2024']");
    public By ccv = By.cssSelector("#ccCVV");
    public By place_order = By.cssSelector("input[value='Place Order']");

    public void checkout_information(WebDriver driver) throws InterruptedException {
        SearchContext shadow0 = driver.findElement(cssSelectorForHost1).getShadowRoot();
        SearchContext shadow1 = shadow0.findElement(cssSelectorForHost2).getShadowRoot();
        input(driver, shadow1.findElement(email), "test@test.com");
        input(driver,shadow1.findElement(phone), "9184568452");
        input(driver, shadow1.findElement(address), "Sector - 11");
        input(driver,shadow1.findElement(city),"Dhaka");
        input(driver,shadow1.findElement(state),"Uttara");
        input(driver,shadow1.findElement(zip),"1230");
        selectOptions(driver,shadow1.findElement(select),shadow1.findElement(option));
        input(driver,shadow1.findElement(ch_name), "Hatake Kakashi");
        input(driver,shadow1.findElement(card_number), "789123456789456");
        selectOptions(driver,shadow1.findElement(select_month),shadow1.findElement(month_name));
        selectOptions(driver,shadow1.findElement(select_year),shadow1.findElement(year));
        input(driver,shadow1.findElement(ccv), "2476");
        shadow1.findElement(place_order).click();
        Thread.sleep(2000);
    }
}
