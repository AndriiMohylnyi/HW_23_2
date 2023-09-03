package practice.test.lessons21;


import driver.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.FirstPropertiesReader;

import java.io.IOException;
import java.net.MalformedURLException;

@Listeners(MyTestListener.class)
public class BaseTestClass {

    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {
        WebDriverHolder.getInstance().getDriver();
//        MyFilesUtils.clearFilesFolder();
//        MyFilesUtils.clearScreenshotsFolder();
    }

    @AfterSuite
    public void afterSuite() throws MalformedURLException {
        WebDriverHolder.getInstance().driverQuit();
    }

    public void goToUrl(String url) throws MalformedURLException {
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl() throws MalformedURLException {
        goToUrl(FirstPropertiesReader.getInstance().getProperties("app.base.url"));
    }

    public void goToPart(String part) throws MalformedURLException {
        goToUrl(FirstPropertiesReader.getInstance().getProperties("app.base.url") + part);
    }
}
