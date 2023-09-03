package pages;

import driver.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class MyBasePage {

    public MyBasePage() throws MalformedURLException {
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }
}
