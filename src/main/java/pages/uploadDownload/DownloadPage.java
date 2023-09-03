package pages.uploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MyBasePage;

import java.io.File;
import java.net.MalformedURLException;

public class DownloadPage extends MyBasePage {

    @FindBy(id = "content")
    private WebElement fileName;

    public DownloadPage() throws MalformedURLException {
        super();
    }

    public DownloadPage findFile(File file) {
        fileName.findElement(By.linkText(file.getName())).click();
        return this;
    }

}
