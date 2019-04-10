import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MakeCopy {

    private String NEW_DECISION = "New Besluit Title";
    private String COPY_DECISION = "Kopie van New Besluit Title";

    @FindBy(xpath = "//span[contains(text(), 'Kopieer besluit')]")
    private WebElement copyBesluit;
    @FindBy(xpath = "//a[contains(text(), 'Besluiten')]")
    private WebElement goToBesluiten;

    @FindBy(xpath = "//h4[@class='js-title-inner'][contains(text(), 'Documenten')]")
    private WebElement goTo7Documenten;
    @FindBy(xpath = "//span[@class=\"finish action-button\"][contains(text(), 'Voltooien')]")
    private WebElement buttonVoltooien;

    @FindBy(xpath = "//a[contains(text(),\"New Besluit Title\")]")
    private WebElement besluitToCopy;


    WebDriver driver;
    WebDriverWait wait;

    public MakeCopy(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 40, 100);
        PageFactory.initElements(this.driver, this);
    }

    public void findBesluitToCopy() {
        List<WebElement> listOfBesluiten;
        listOfBesluiten = driver.findElements(By.xpath("//div[@class='app-table-content-row']"));
        for (WebElement besluit : listOfBesluiten) {
            if (besluit.getText().contains(NEW_DECISION)) {
                besluit = besluitToCopy;
                /*Actions act = new Actions(driver);
                act.doubleClick(besluitToCopy).perform();*/
                besluitToCopy.click();
                break;
            }
        }

    }

    public DeleteCopyBesluit makeCopy() {
       /* findBesluitToCopy();
        Thread.sleep(1000);*/
        besluitToCopy.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));


        copyBesluit.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        goTo7Documenten.click();
       wait.until(ExpectedConditions.elementToBeClickable(buttonVoltooien)).click();
        goToBesluiten.click();


        return new DeleteCopyBesluit(this.driver);
    }

    public boolean findCopyOfBesluit() {
        //  Thread.sleep(2000);
        List<WebElement> listOfBesluiten;
        listOfBesluiten = driver.findElements(By.xpath("//div[@class='app-table-content-row']"));
        for (WebElement besluit : listOfBesluiten) {
            if (besluit.getText().matches(COPY_DECISION)) {
                return true;
            }
        }return false;
    }
}
