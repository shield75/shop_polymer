package TestCases;

import Pages.*;
import Utilities.Driver;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.testng.annotations.Test;

public class Full_Test extends Driver {
    Home h1 = new Home();
    Outwear o1 = new Outwear();
    Product p1 = new Product();
    Cart c1 = new Cart();
    Checkout ch1 = new Checkout();

    @Test
    @Description("Full test scenario from home page to product selection and checkout")
    public void fullTest() throws InterruptedException {
       //Homepage
        getLocalDriver().get(h1.base_url);
        h1.shadow_element_click(getLocalDriver());

        //Men's Outwear page
        o1.shadow_element_click(getLocalDriver(), o1.moItem);

        //Product page
        SearchContext shadow1 =  p1.selectSize_and_Quantity(getLocalDriver());
        p1.addToCart(getLocalDriver(),shadow1);
        p1.goTO_ladiesOutwear();

        //Ladies Outwear page
        o1.shadow_element_click(getLocalDriver(), o1.loItem);

        //Product page
        p1.selectSize_and_Quantity(getLocalDriver());
        p1.addToCart(getLocalDriver(),shadow1);
        p1.goTO_Cart();

        //Cart page
        c1.checkout_button(getLocalDriver());

        //Checkout page
        ch1.checkout_information(getLocalDriver());
    }
}
