/*
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Meetings {

    WebDriverWait wait;
    WebDriver driver;

    public Meetings(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 60);
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "//*[contains(text(),'07/05/2018 13:00')]")
    private WebElement scheppencollege;
    @FindBy(xpath = "//*[contains(text(),'08/01/2019 20:00')]")
    private WebElement vastBureau;

    @FindBy(xpath = "//*[contains(text(),'26/11/2018 20:00')]")
    private WebElement gemeenteraad;

    @FindBy(xpath = "//*[contains(text(),'01/03/2019 00:00')]")
    private WebElement ocmwraad;

    @FindBy(xpath = "//*[contains(text(),'01/03/2019 00:00')]")
    private WebElement bcsd;

    @FindBy(xpath = "//*[contains(text(),'31/12/2018 00:00')]")
    private WebElement directiecomiteAGBM;

    @FindBy(xpath = "//*[contains(text(),'01/01/2019 10:30')]")
    private WebElement directiecomiteAGBI;

    @FindBy(xpath = "//*[contains(text(),'04/01/2019 00:00')]")
    private WebElement raadVanBestuurAGBM;

    @FindBy(xpath = "//*[contains(text(),'25/07/2019 00:00')]")
    private WebElement raadVanBestuurAGBI;

    @FindBy(xpath = "//span[@class='td-content']/a[contains(text(),'New Besluit Title')]")
    private WebElement findDecision;

    public Search geagendeerd() {


        scheppencollege.click();
        closeWindow();
        vastBureau.click();
        closeWindow();
        gemeenteraad.click();
        closeWindow();
        ocmwraad.click();
        closeWindow();
        bcsd.click();
        closeWindow();
        directiecomiteAGBM.click();
        closeWindow();
        directiecomiteAGBI.click();
        closeWindow();
        raadVanBestuurAGBM.click();
        closeWindow();
        raadVanBestuurAGBI.click();
        closeWindow();
        return new Search(this.driver);
    }

    public void closeWindow() {

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }


}
*/
