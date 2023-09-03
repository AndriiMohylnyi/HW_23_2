package pages.uploadDownload;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MyBasePage;

import java.io.File;
import java.net.MalformedURLException;

public class UploadDownloadPage extends MyBasePage {
    @FindBy(id = "file-upload")
    private WebElement fileUpload;

    @FindBy(id = "file-submit")
    private WebElement fileSubmit;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFiles;
     public UploadDownloadPage() throws MalformedURLException {
         super();
     }
     public void clickUploadButton(){
        fileSubmit.click();
     }
     public UploadDownloadPage findUpload(File file) throws MalformedURLException {
         fileUpload.sendKeys(file.getAbsolutePath());
         clickUploadButton();
         return new UploadDownloadPage();
     }
     public String getNameFile(){
         return uploadedFiles.getText();
     }



}
