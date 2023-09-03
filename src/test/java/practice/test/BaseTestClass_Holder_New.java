package practice.test;


import driver.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import practice.test.lessons21.MyTestListener;
import utils.FirstPropertiesReader;
import utils.MyFilesUtils;

import java.io.IOException;
import java.net.MalformedURLException;

@Listeners(MyTestListener.class)
public class BaseTestClass_Holder_New {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeClass() throws IOException {
//        WebDriverHolder.getInstance().getDriver();
        driver = WebDriverHolder.getInstance().getDriver();
        MyFilesUtils.clearFilesFolder();
        MyFilesUtils.clearDownloadsFolder();
    }

    @AfterSuite
    public void afterClass() throws MalformedURLException {
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
