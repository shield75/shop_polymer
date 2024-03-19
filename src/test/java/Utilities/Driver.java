package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class Driver {
    private static String browserName = System.getProperty("browser", "chrome");

    public static String getBrowserName() {
        return browserName;
    }

    public static void setBrowserName(String browserName) {
        Driver.browserName = browserName;
    }

    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    public static void setLocalDriver(WebDriver driver){
        Driver.LOCAL_DRIVER.set(driver);
    }
    public static WebDriver getLocalDriver(){
        return LOCAL_DRIVER.get();
    }


    public static WebDriver createBrowser(String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            return new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")){
            return new EdgeDriver();
        }
        else {
            throw new RuntimeException("Browser Not Found!!!");
        }
    }

    @BeforeMethod
    public static synchronized void setBrowser(){
        WebDriver driver = createBrowser(getBrowserName());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        setLocalDriver(driver);
    }
    @AfterMethod
    public static synchronized void quitBrowser(){
        getLocalDriver().quit();
    }

}
