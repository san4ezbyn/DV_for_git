
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Reacties {


    WebDriver driver;
    WebDriverWait wait;

    public Reacties(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 60);
        PageFactory.initElements(this.driver, this);
    }

    private static String NEW_BESLUIT = "New Besluit Title";
    private static String COMMENT = "Reaction comment";

    @FindBy(xpath = "//div[@class='app-table-content-row']")
    private List<WebElement> listOfBesluiten;

    @FindBy(xpath = "//span[@class='td-content']//*[contains(text(),'New Besluit Title')]")
    private WebElement titleOfBesluit;

    @FindBy(xpath = "//div[@placeholder='Add Comment']")
    private WebElement commentField;

    @FindBy(xpath = "//div[@id='btnPublish']")
    private WebElement reageerButton;

    @FindBy(xpath = "//i[@class='fa fa-ellipsis-h']")
    private WebElement optionReaction;

    @FindBy(xpath = "//i[@class='material-icons']")
    private WebElement deleteReaction;

    @FindBy(xpath = "//a[contains(text(), 'Terug naar overzicht')]")
    private WebElement goToOverzicht;

    @FindBy(xpath = "//nav[@class='main-nav']//a[contains(text(),'Besluiten')]")
    private WebElement goToBesluiten;

    public void findBesluit() {

        for (WebElement element : listOfBesluiten) {
            if (element.getText().contains(NEW_BESLUIT)) {
                titleOfBesluit.click();
                break;
            }
        }
    }

    public MakeCopy reaction() throws InterruptedException {


        findBesluit();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));

        commentField.sendKeys(COMMENT);
        reageerButton.click();
        Assert.assertEquals(commentField.getText(), COMMENT);
        optionReaction.click();
        deleteReaction.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(commentField.getText(), "");

        wait.until(ExpectedConditions.elementToBeClickable(goToOverzicht)).click();

        return new MakeCopy(this.driver);
    }


}
