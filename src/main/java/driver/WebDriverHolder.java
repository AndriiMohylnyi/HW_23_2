package driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class WebDriverHolder {
    private static WebDriverHolder instance = null;
    private WebDriver driver;

    WebDriverHolder() throws MalformedURLException {
        driver = WebDriverFactory_New.initDriver();
    }


    public static WebDriverHolder getInstance() throws MalformedURLException {
        if (instance == null) {
            instance = new WebDriverHolder();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

//    public JavascriptExecutor javascriptExecutor() {
//        return (JavascriptExecutor)driver;
//    }

    public void driverQuit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
