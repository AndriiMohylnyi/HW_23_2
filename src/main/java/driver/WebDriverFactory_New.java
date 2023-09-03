package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class WebDriverFactory_New {
    public static WebDriver initDriver(WebDriverType webDriverType) throws MalformedURLException {
        WebDriver driver = null;
        switch (webDriverType) {
            case CHROME:
                //WebDriverManager.chromedriver().setup();
                //driver = new ChromeDriver();

                ChromeOptions options = new ChromeOptions();
                options.setCapability("browserVersion", "114.0");
                options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                    /* How to add test badge */
                    put("name", "Test badge...");

                    /* How to set session timeout */
//                    put("sessionTimeout", "15m");

                    /* How to set timezone */
                    put("env", new ArrayList<String>() {{
                        add("TZ=UTC");
                    }});

                    /* How to add "trash" button */
                    put("labels", new HashMap<String, Object>() {{
                        put("manual", "true");
                    }});

                    /* How to enable video recording */
                    put("enableVideo", false);
                }});
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initDriver() throws MalformedURLException {
        WebDriverType webDriverType = null;
        try {
            webDriverType = WebDriverType.valueOf(System.getProperty("webDriverType", "chrome").toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("This driver is not supported. \nPlease choose: chrome, edge, firefox");
            System.exit(-1); // Щоб не йшло виконання далі
        }
        return initDriver(webDriverType);
    }

}
